package com.three.alcoholshoppingmall.project.user;

import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.exception.ErrorCode;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.three.alcoholshoppingmall.project.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class UserService {
    @Value("${spring.mail.username}")
    private String senderEmail;

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JavaMailSender javaMailSender;

    public User withdrawUser(String email) { // 회원 정보 탈퇴 코드
        User dbUser = userRepository.findByEmail(email);
        if (dbUser.getWithdrawStatus()== WithdrawStatus.Y){
            throw new BizException(WITHDRAWUSER);
        }
        if (dbUser != null) {
            dbUser.setWithdrawStatus(WithdrawStatus.Y);
            userRepository.save(dbUser);
            return dbUser;

        } else {
            throw new BizException(NOTFOUNDUSER); // 예외처리
        }
    }

    public String updateUser(String email, UserUpdate userUpdate) {
        User dbUser = userRepository.findByEmail(email);
        User phoneUser = userRepository.findByPhone(userUpdate.getPhone());

        if (dbUser == null) {
            throw new BizException(NOTFOUNDUSER);
        }
        if (phoneUser != null && dbUser.getEmail() == phoneUser.getEmail()) {
            dbUser.setNickname(userUpdate.getNickname());
            dbUser.setAddress(userUpdate.getAddress());
            dbUser.setAddress2(userUpdate.getAddress2());
            userRepository.save(dbUser);
        } else if (phoneUser != null && userUpdate.getPhone().equals(phoneUser.getPhone())) {
            throw new BizException(DUPLPHONE);
        } else {
            dbUser.setNickname(userUpdate.getNickname());
            dbUser.setPhone(userUpdate.getPhone());
            dbUser.setAddress(userUpdate.getAddress());
            dbUser.setAddress2(userUpdate.getAddress2());
            userRepository.save(dbUser);
        }
        return "회원정보가 수정되었습니다";
    }

    public User userInfo(String email) {
        User dbUser = userRepository.findByEmail(email);
        if (dbUser == null) {
            throw new BizException(NOTFOUNDUSER);
        } else {
            User user = User.builder()
                    .email(dbUser.getEmail())
                    .nickname(dbUser.getNickname())
                    .phone(dbUser.getPhone())
                    .address(dbUser.getAddress())
                    .address2(dbUser.getAddress2())
                    .gender(dbUser.getGender())
                    .birthdate(dbUser.getBirthdate())
                    .build();
            return user;
        }
    }

    public String updatePw(String email, PwUpdate pwUpdate) {
        User dbUser = userRepository.findByEmail(email);
        if (dbUser == null) {
            throw new BizException(NOTFOUNDUSER);
        } else if (!encoder.matches(pwUpdate.getPassword(), dbUser.getPassword())) {
            throw new BizException(DIFFERPASSWORD);
        } else if (!pwUpdate.getNewPassword().equals(pwUpdate.getPasswordch())) {
            throw new BizException(CHECKPASSWORD);
        } else if (pwUpdate.getPassword().equals(pwUpdate.getNewPassword())) {
            throw new BizException(SAMEPASSWORD);
        }
        else {
            dbUser.setPassword(encoder.encode(pwUpdate.getNewPassword()));
            userRepository.save(dbUser);

        }

        return "비밀번호 수정이 완료되었습니다.";
    }

    public String withdrawEmailAuth(String email) {

        if (email == null || email.equals("")) {
            throw new BizException(ErrorCode.NOTINPUTEMAIL);
        }
        User userEmail = userRepository.findByEmail(email);
        if (userEmail == null) {
            throw new BizException(NOTFOUNDUSER);
        }
        if (userEmail.getWithdrawStatus()==WithdrawStatus.Y){
            throw new BizException(WITHDRAWUSER);
        }

        MimeMessage message = javaMailSender.createMimeMessage();

        int num = (int) (Math.random() * 10000);

        try {
            message.setFrom(senderEmail);   // 보내는 이메일
            message.setRecipients(MimeMessage.RecipientType.TO, email); // 보낼 이메일 설정
            message.setSubject("[AlcoholFree] 회원탈퇴를 위한 이메일 인증");  // 제목 설정
            String body = "";
            body += "<h1>" + "안녕하세요." + "</h1>";
            body += "<h1>" + "AlcoholFree 입니다." + "</h1>";
            body += "<h3>" + "회원탈퇴를 위한 요청하신 인증 번호입니다." + "</h3><br>";
            body += "<h2>" + "아래 코드를 회원탈퇴 창으로 돌아가 입력해주세요." + "</h2>";

            body += "<div align='center' style='border:1px solid black; font-family:verdana;'>";
            body += "<h2>" + "회원탈퇴 인증 코드입니다." + "</h2>";
            body += "<h1 style='color:blue'>" + num + "</h1>";
            body += "</div><br>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body, "UTF-8", "html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);
        User user = userRepository.findByEmail(email);
        user.setWithdrawStatus(WithdrawStatus.Y);
        userRepository.save(user);
        return num + "";

    }
}