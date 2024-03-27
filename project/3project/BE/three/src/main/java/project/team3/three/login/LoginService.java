package project.team3.three.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;
import project.team3.three.user.User;
import project.team3.three.user.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    // 회원가입
    public User signUp(User user){
        User emailPhoneNumUser =loginRepository.findByEmailAndPhoneNum(user.getEmail(), user.getPhoneNum());
        // 이메일이나 전화번호가 중복나면 에러
        if(emailPhoneNumUser != null){
            throw new BizException(ErrorCode.DUPLICATE);
        }

        User signUpUser = loginRepository.save(user);

        return signUpUser;
    }

    // 로그인
    public User signIn(String email, String password) {
        User dbuser = loginRepository.findByEmailAndPasswordAndN(email, password);
        return dbuser;
    }

    // 아이디(이메일) 찾기
    public Optional<String> findByNameAndStudiesAndPhoneNum(String name, String studies, String phoneNum) {
        Optional<String> userId = loginRepository.findByNameAndStudiesAndPhoneNum(name, studies, phoneNum);
        return userId;
    }

    // 비밀번호 찾기
    public Optional<Long> findByNameAndStudiesAndPhoneNumAndEmail(String name, String studies, String phoneNum, String email) {
        Optional<Long> userPw = loginRepository.findByNameAndStudiesAndPhoneNumAndEmail(name, studies, phoneNum, email);
        return userPw;
    }
}
