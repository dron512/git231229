package com.mh.green2nd.pay;


import com.mh.green2nd.pay.response.SingleResult;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/payment")
public class PayController {

//    https://api.tosspayments.com/v1/payments/confirm

    private final PayService payService;
    private final ResponseService responseService;
    @PostMapping("")
    public PayRes requestPay(@ModelAttribute PayReq payReq) {
        try {
            return responseService.getSingleResult(
                    payService.requestPay(payReq)
            ).getData();
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/success")
    public ResponseEntity<JSONObject> requestFinalPayments(@RequestParam String paymentKey,
                                                           @RequestParam String orderId,
                                                           @RequestParam Long amount){
        try {
            System.out.println("paymentKey= " + paymentKey);
            System.out.println("orderId= "+ orderId);
            System.out.println("amount= " + amount);
            payService.verifyRequest(paymentKey, orderId, amount);
             ResponseEntity<JSONObject> result = payService.requestFinalPayment(paymentKey, orderId, amount);
            return result;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }

    }
    @GetMapping("/fail")
    public SingleResult<PaymentResHandleFailDto> requestFinalPaymentsFail(@RequestParam String errorCode,
                                                                          @RequestParam String orderId,
                                                                          @RequestParam String errorMsg){
        try {
            return responseService.getSingleResult(
                    payService.requestFail(errorCode, errorMsg, orderId)
            );
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
