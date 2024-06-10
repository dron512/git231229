package com.mh.green2nd.user;


import com.mh.green2nd.exception.ErrorCode;
import com.mh.green2nd.exception.UserException;
import com.mh.green2nd.jwt.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final TokenManager tokenManager;

    public User login(String email, String password) {
        Optional<User> loginuser = userRepository.findByEmailAndPassword(email, password);
        if (loginuser.isEmpty()) {
            System.out.println("여기 왔나");
//            throw new RuntimeException("조건에 맞는 사용자가 없습니다. 이메일과 비밀번호를 확인해주세요.");
            throw new UserException(ErrorCode.LOGINFAILED1);
        } else if (loginuser.get().getResign().equals(Resign.Y)) {
            System.out.println("탈퇴여기 왔나");
//            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ﾟ 이미 탈퇴한 계정입니다. ʕ •ᴥ•ʔ ━☆");
            throw new UserException(ErrorCode.LOGINFAILED2);
        } else {
            return loginuser.get();
        }

    }

    public User signup(User user) {

        User duemail = userRepository.findByEmail(user.getEmail());
        User dunickname = userRepository.findByNickname(user.getNickname());
        User dupphone = userRepository.findByPhone(user.getPhone());


//        Optional<User>
        if (duemail != null) {
//            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ 중복된 이메일이 있습니다. ʕ •ᴥ•ʔ ━☆");
            throw new UserException(ErrorCode.DUPLICATEEMAIL);
        }
        if (dunickname != null) {
//            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ 중복된 닉네임이 있습니다. ʕ •ᴥ•ʔ ━☆");
            throw new UserException(ErrorCode.DUPLICATENICKNAME);
        }
        if (dupphone != null) {
//            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ 중복된 닉네임이 있습니다. ʕ •ᴥ•ʔ ━☆");
            throw new UserException(ErrorCode.DUPLICATEPHONE);
        } else {
            User signupUser = userRepository.save(user);

            return signupUser;
        }
    }


    public String resignuser(String email) {
        User user = userRepository.findByEmail(email);
        user.setResign(Resign.Y);
        user.setResignDate(LocalDateTime.now());
        userRepository.save(user);
        return "ʕ •ᴥ•ʔ ━☆ﾟ 탈퇴 완료되었습니다. ʕ •ᴥ•ʔ ━☆ﾟ";
    }


    public User updateUserByEmail(UpdateDto updateDto) {
        User updateuser = userRepository.findByEmail(updateDto.getEmail());

        if (updateuser == null) {
            throw new UsernameNotFoundException("그런 이메일의 유저는 없습니다: " + updateDto.getEmail());
        }

        if (updateDto.getPassword() != null && !updateDto.getPassword().isEmpty()) {
            String passwordPattern = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,20}";
            if (Pattern.matches(passwordPattern, updateDto.getPassword())) {
                updateuser.setPassword(updateDto.getPassword());
            } else {
                throw new IllegalArgumentException("비밀번호가 정규식 패턴과 일치하지 않습니다.");
            }
        }

        if (updateDto.getNickname() != null) {

            User userWithSameNickname = userRepository.findByNickname(updateDto.getNickname());
            if (userWithSameNickname != null && !updateuser.getNickname().equals(updateDto.getNickname())) {
                throw new UserException(ErrorCode.DUPLICATENICKNAME);
            }
        }

        if (updateDto.getPhone() != null) {
            User userWithSamePhone = userRepository.findByPhone(updateDto.getPhone());
            if (userWithSamePhone != null && !updateuser.getPhone().equals(updateDto.getPhone())) {
                throw new UserException(ErrorCode.DUPLICATEPHONE);
            }
        }

        User userWithSameNickname = userRepository.findByNickname(updateDto.getNickname());
        if (userWithSameNickname != null && !updateuser.getNickname().equals(updateDto.getNickname())) {
            throw new UserException(ErrorCode.DUPLICATENICKNAME);
        }


        if (updateDto.getPhone() != null) {
            User userWithSamePhone = userRepository.findByPhone(updateDto.getPhone());
            if (userWithSamePhone != null && !updateuser.getPhone().equals(updateDto.getPhone())) {
                throw new UserException(ErrorCode.DUPLICATEPHONE);
            }
        }


        if (updateDto.getNickname() != null)
            updateuser.setNickname(updateDto.getNickname());
        if (updateDto.getBirthdate() != null)
            updateuser.setBirthdate(updateDto.getBirthdate());
        if (updateDto.getPhone() != null)
            updateuser.setPhone(updateDto.getPhone());

        User dbuser = userRepository.save(updateuser);
        return dbuser;
    }


    public String findemail(String phone) {
        User user = userRepository.findByPhone(phone);
        if (user == null) {
//            throw new RuntimeException("입력하신 정보에 맞는 이메일이 없습니다.");
            throw new UserException(ErrorCode.NOTFOUNDPHONE);
        }
        return user.getEmail();
    }

    @Transactional  // entitymanager.clear();
    public String findpw(String phone) {
        User user = userRepository.findByPhone(phone);

        if (user == null) {
//            throw new RuntimeException("입력하신 정보에 맞는 비밀번호가 없습니다.");
            throw new UserException(ErrorCode.NOTFOUNDPHONE);
        }
        user.setPassword("1q2w3e4r!");
        return user.getPassword();
    }


    public String checkpw(String email, String password) {
        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
        if (!user.getPassword().equals(password)) {
//            throw new RuntimeException("비밀번호가 틀렸습니다.");
            throw new UserException(ErrorCode.PWCHECKFAILED);
        }

        return "ʕง•ᴥ•ʔง 비밀번호 인증되었습니다. ʕง•ᴥ•ʔง";

    }


    public String sendEmail(String toEmail) {
        // 6자리 난수 생성
        String verificationCode = String.format("%06d", (int) (Math.random() * 1000000));

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("회원가입 인증 코드");
        mailMessage.setText("회원가입 인증 코드는 " + verificationCode + " 입니다.");

        javaMailSender.send(mailMessage);

        return verificationCode;
    }

    public boolean verifyEmail(String email, String inputCode) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return user.getVerificationCode().equals(inputCode);

    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void resigndelete() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        List<User> users = userRepository.findAllByResignAndResignDateBefore(Resign.Y, oneMonthAgo);
        userRepository.deleteAll(users);
    }

//    public String sendVerificationEmail(String toEmail) {
//        // 6자리 난수 생성
//        String verificationCode = String.format("%06d", (int) (Math.random() * 1000000));
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject("회원가입 인증 코드");
//        mailMessage.setText("회원가입 인증 코드는 " + verificationCode + " 입니다.");
//
//        javaMailSender.send(mailMessage);
//
//        return verificationCode;
//    }

    // Refresh Token 저장
    public void saveRefreshToken(Long userId, String refreshToken) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setRefreshToken(refreshToken);
        userRepository.save(user);
    }

    // Refresh Token 검증
//    public boolean validateRefreshToken(Long userId, String refreshToken) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//        return user.getRefreshToken().equals(refreshToken);
//    }

    //    public String validateAndRefresh(String refreshToken) {
//        User user = userRepository.findByRefreshToken(refreshToken);
//        System.out.println("User's Refresh Token: " + user.getRefreshToken());
//        System.out.println("Received Refresh Token: " + refreshToken);
//        if (user == null) {
//            throw new RuntimeException("Invalid refresh token.");
//        }
//
//        // 리프레시 토큰이 유효하면 새로운 액세스 토큰을 발행합니다.
//        return tokenManager.generateToken(user);
//    }
//    public String validateAndRefresh(HttpServletRequest request) {
//    String refreshToken = request.getHeader("Authorization");
//
//    // refreshToken이 존재하는지 확인
//    if (refreshToken == null || !refreshToken.startsWith("Bearer ")) {
//        throw new RuntimeException("Refresh Token이 없습니다.");
//    }
//
//    refreshToken = refreshToken.substring(7); // "Bearer " 제거
//
//    // DB에서 refreshToken 검색 및 검증
//    User user = userRepository.findByRefreshToken(refreshToken);
//    if (user == null) {
//        throw new RuntimeException("Invalid refresh token");
//    }
//
//    // 새로운 액세스 토큰 생성
//    String newAccessToken = tokenManager.generateToken(user);
//
//    return newAccessToken;
//}
    public String validateAndRefresh(String refreshToken) {
        User user = userRepository.findByRefreshToken(refreshToken);
        if (user == null) {
            throw new RuntimeException("해당하는 리프레시 토큰이 없습니다.");
        }
        // 새로운 액세스 토큰 생성
        String newAccessToken = tokenManager.generateToken(user);
        return newAccessToken;
    }


}