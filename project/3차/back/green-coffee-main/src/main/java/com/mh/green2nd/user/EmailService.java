package com.mh.green2nd.user;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String setFrom;    // 보내는 사람

    // 인증번호 8자리 무작위 생성
    public String createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for (int i = 0; i < 8; i++) {
            // 0~2 사이의 값을 랜덤하게 받아와 idx에 집어넣습니다.
            int idx = random.nextInt(3);

            // 랜덤하게 idx를 받았으면, 그 값을 switchcase를 통해 또 꼬아버립니다.
            // 숫자와 ASCII 코드를 이용합니다.
            switch (idx) {
                case 0:
                    // a(97) ~ z(122)
                    key.append((char) ((int) random.nextInt(26) + 97));
                    break;
                case 1:
                    // A(65) ~ Z(90)
                    key.append((char) ((int) random.nextInt(26) + 65));
                    break;
                case 2:
                    // 0 ~ 9
                    key.append(random.nextInt(9));
                    break;
            }
        }
        return key.toString();
    }

    // 메일 양식 작성
    public MimeMessage createEmailForm(String email, String authNum) throws MessagingException, UnsupportedEncodingException {
        // 코드를 생성합니다.
//        String authNum = createCode();

        String toEmail = email;        // 받는 사람(값 받아옵니다.)
        String title = "그린커피 이메일 인증번호";        // 메일 제목

        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject(title);        // 제목 설정

        // 메일 내용 설정
        String msgOfEmail = "";
        msgOfEmail += "<div style='margin:20px;'>";
        msgOfEmail += "<h1> 안녕하세요 그린커피 입니다. </h1>";
        msgOfEmail += "<br>";
        msgOfEmail += "<p>아래 코드를 입력해주세요<p>";
        msgOfEmail += "<br>";
        msgOfEmail += "<p>감사합니다.<p>";
        msgOfEmail += "<br>";
        msgOfEmail += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgOfEmail += "<h3 style='color:blue;'>인증 코드입니다.</h3>";
        msgOfEmail += "<div style='font-size:130%'>";
        msgOfEmail += "CODE : <strong>";
        msgOfEmail += authNum + "</strong><div><br/> ";
        msgOfEmail += "</div>";

        message.setFrom(setFrom);        // 보내는 사람 설정
        // 위 String으로 받은 내용을 아래에 넣어 내용을 설정합니다.
        message.setText(msgOfEmail, "utf-8", "html");

        return message;
    }

    //실제 메일 전송
    public String sendEmail(String email, HttpServletResponse response) throws MessagingException, UnsupportedEncodingException {

//        //메일전송에 필요한 정보 설정
//        MimeMessage emailForm = createEmailForm(email);
//        // 생성된 인증 코드를 쿠키에 저장
//        String verificationCode = createCode();
//        Cookie cookie = new Cookie("verificationCode", verificationCode);
//        cookie.setMaxAge(5 * 60); // 쿠키의 유효 시간을 5분으로 설정
//        response.addCookie(cookie);
//
//        //실제 메일 전송
//        emailSender.send(emailForm);
//
//        return "정상적으로 보냄"; //인증 코드 반환
        // 인증 코드 생성
        String verificationCode = createCode();

        // 메일전송에 필요한 정보 설정
        MimeMessage emailForm = createEmailForm(email, verificationCode);

        // 생성된 인증 코드를 쿠키에 저장
        Cookie cookie = new Cookie("verificationCode", verificationCode);
        cookie.setMaxAge(3 * 60); // 쿠키의 유효 시간을 3분으로 설정
        response.addCookie(cookie);

        // 실제 메일 전송
        emailSender.send(emailForm);

        return "정상적으로 보냄"; // 인증 코드 반환
    }


}
