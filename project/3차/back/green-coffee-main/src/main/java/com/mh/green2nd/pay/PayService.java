package com.mh.green2nd.pay;

import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class PayService {

    private final PayRepository payRepository;
    private final UserRepository userRepository;

    @Value("${toss.client.apikey}")
    private String clientId;

    @Value("${toss.client.secretkey}")
    private String secretKey;

    @Value("${toss.client.successUrl}")
    private String successUrl;

    @Value("${toss.client.failUrl}")
    private String failUrl;

    @Value("${toss.client.OriginUrl}")
    private String tossOriginUrl;

    @Transactional
    public PayRes requestPay(PayReq payReq) {
        Long amount = payReq.getAmount();
        String payType = payReq.getPayType().name();
        String email = payReq.getEmail();

        if (amount == null) {
            throw new RuntimeException("금액을 입력하세요");
        }
        if (!payType.equals("CARD") && !payType.equals("POINT")) {
            throw new RuntimeException("결제방법을 다시 입력하세요.");
        }
        PayRes payRes;
        try {
            Pay pay = payReq.toEntity();
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new RuntimeException("회원가입을 하세요");
            }
            user.addPay(pay);

            payRes = pay.toDto();
            payRes.setSuccessUrl(successUrl);
            payRes.setFailUrl(failUrl);
            payRepository.save(pay);

            return payRes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public void verifyRequest(String paymentKey, String orderId, Long amount) {
        payRepository.findByOrderId(orderId)
                .ifPresentOrElse(
                        P -> {
                            if (P.getAmount().equals(amount)) {
                                P.setPaymentKey(paymentKey);
                            } else {
                                throw new RuntimeException("결제금액이 일치하지 않습니다.");
                            }
                        }, () -> {
                            throw new RuntimeException("결제가 존재하지 않습니다.");
                        }

                );
    }

    @Transactional
    public ResponseEntity<JSONObject> requestFinalPayment(String paymentKey, String orderId, Long amount) throws IOException, ParseException, URISyntaxException {
        // 기본 인증 설정
        secretKey = secretKey + ":";
        String encodedAuth = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));

        URI uri = new URI("https://api.tosspayments.com/v1/payments/confirm");
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        JSONObject obj = new JSONObject();
        obj.put("orderId", orderId);
        obj.put("amount", amount);
        obj.put("paymentKey", paymentKey);

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(obj.toString().getBytes(StandardCharsets.UTF_8));
        }

        int code = connection.getResponseCode();
        boolean isSuccess = code == 200;

        try (InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();
             Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return ResponseEntity.status(code).body(jsonObject);
        }
    }
//    @Transactional
//    public ResponseEntity<JSONObject> requestFinalPayment(String paymentKey, String orderId, Long amount) throws JSONException, IOException, ParseException {
//        // api 호출 하는 클래스
//        RestTemplate rest = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        JSONParser parser = new JSONParser();
//        secretKey = secretKey + ":";
//        String encodedAuth = new String(Base64.getEncoder().encode(secretKey.getBytes(StandardCharsets.UTF_8)));
//
//        URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        connection.setRequestProperty("encodedAuth", encodedAuth);
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
////
////        headers.setBasicAuth(encodedAuth);
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        JSONObject obj = new JSONObject();
//
//        obj.put("orderId", orderId);
//        obj.put("amount", amount);
//        obj.put("paymentKey", paymentKey);
//
//        OutputStream outputStream = connection.getOutputStream();
//        outputStream.write(obj.toString().getBytes("UTF-8"));
//
//        int code = connection.getResponseCode();
//        boolean isSuccess = code == 200;
//
//        InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();
//
////        // TODO: 결제 성공 및 실패 비즈니스 로직을 구현하세요.
//        Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
//        JSONObject jsonObject = (JSONObject) parser.parse(reader);
//        responseStream.close();
////
//
//        return ResponseEntity.status(code).body(jsonObject);
////    }
//
//        return rest.postForEntity(
//                tossOriginUrl + paymentKey,
//                new HttpEntity<>(param , (MultiValueMap<String, String>) connection),
//                String.class
//        ).getBody();


    @Transactional
    public PaymentResHandleFailDto requestFail(String errorCode, String errorMsg, String orderId) {
        Pay pay = payRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("주문아이디 없음"));

        pay.setPaySuccessYn("N");
        pay.setPayFailReason(errorMsg);

        payRepository.save(pay);
        return PaymentResHandleFailDto.builder()
                .orderId(orderId)
                .errorCode(errorCode)
                .errorMsg(errorMsg)
                .build();
    }

}

