package com.mh.green2nd.user;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String email, String password) {
        Optional<User> loginuser = userRepository.findByEmailAndPassword(email,password);
        if (loginuser.isEmpty()){
            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ﾟ 검색된 유저가 없습니다. ʕ •ᴥ•ʔ ━☆");
        }
        else if (loginuser.get().getResign().equals(Resign.Y)) {
            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ﾟ 이미 탈퇴한 계정입니다. ʕ •ᴥ•ʔ ━☆");
        }
        else {
            return loginuser.get();
        }

    }

    public User signup(User user) {

        User duemail = userRepository.findByEmail(user.getEmail());
        User dunickname = userRepository.findByNickname(user.getNickname());

//        Optional<User>
        if (duemail != null){
            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ 중복된 이메일이 있습니다. ʕ •ᴥ•ʔ ━☆");
            //에러코드 제작예정
        }
        if(dunickname != null){
            throw new RuntimeException(" ʕ •ᴥ•ʔ ━☆ 중복된 닉네임이 있습니다. ʕ •ᴥ•ʔ ━☆");
        }
        else {
            User signupUser = userRepository.save(user);

            return signupUser;
    }
        }



    public String resignuser(String email) {
        User user = userRepository.findByEmail(email);
        user.setResign(Resign.Y);
        userRepository.save(user);
        return "ʕ •ᴥ•ʔ ━☆ﾟ 탈퇴 완료되었습니다. ʕ •ᴥ•ʔ ━☆ﾟ";
    }

//    public User update(UpdateDto updateDto) {
    public User updateUserByEmail(UpdateDto updateDto) {
        User updateuser = userRepository.findByEmail(updateDto.getEmail());
        System.out.println("여기오나 서비스까지?");
        
        if (updateuser == null) {
            throw new UsernameNotFoundException("그런 이메일의 유저는 없습니다: " + updateDto.getEmail());
        }
//        if (updateDto.getPassword() != null && !updateDto.getPassword().isEmpty()) {
//        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,20}")
//        @NotBlank(message = "비밀번호는 필수 입력 사항입니다. 최소6 최대20")
//        updateuser.setPassword(updateDto.getPassword());
//        }
//        if (updateDto.getPassword() != null)
//            updateuser.setPassword(updateDto.getPassword());
        if (updateDto.getPassword() != null && !updateDto.getPassword().isEmpty()) {
            String passwordPattern = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,20}";
            if (Pattern.matches(passwordPattern, updateDto.getPassword())) {
                updateuser.setPassword(updateDto.getPassword());
            } else {
                throw new IllegalArgumentException("비밀번호가 정규식 패턴과 일치하지 않습니다.");
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



    public String findemail(String nickname, String phone) {
        User user = userRepository.findByNicknameAndPhone(nickname,phone);
        if (user == null){
            throw new RuntimeException("입력하신 정보에 맞는 이메일이 없습니다.");
        }
        return user.getEmail();
    }

    // order add/new
    //
    // 주문정보 jwt item


    // member
    // item

    @Transactional  // entitymanager.clear();
    public String findpw(String nickname, String phone) {
        User user = userRepository.findByNicknameAndPhone(nickname,phone);
        user.setPassword("임시비밀번호");
        if (user == null){
            throw new RuntimeException("입력하신 정보에 맞는 비밀번호가 없습니다.");
        }
        return user.getPassword();
    }


    public String checkpw(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

    return "ʕง•ᴥ•ʔง 비밀번호 인증되었습니다. ʕง•ᴥ•ʔง";
    }
}
