package project.team3.three.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User getUserByuserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new BizException(ErrorCode.NOTSELECT);
        } else {
            return optionalUser.get();
        }
    }

    public User updateUser(User user) {

        User userId = userRepository.findMyCustom(user.getUserId());
        if (userId == null) {
            throw new BizException(ErrorCode.NOTUPDATE);
        }
        userId.setEmail(user.getEmail());
        userId.setGrade(user.getGrade());
        userId.setPassword(user.getPassword());
        userId.setStudies(user.getStudies());
        userId.setEnrollmentStatus(user.getEnrollmentStatus());
        userId.setWithdrawStatus(user.getWithdrawStatus());
        userId.setNickname(user.getNickname());
        userId.setPhoneNum(user.getPhoneNum());

        User dbUser = userRepository.save(userId);
        return dbUser;
    }

    public User withdrawUser(User user) {
        User userId = userRepository.findMyCustom(user.getUserId());
        if (userId == null) {
            throw new BizException(ErrorCode.NOTUPDATE);
        }
        userId.setWithdrawStatus(user.getWithdrawStatus());

        User dbUser = userRepository.save(userId);
        return dbUser;
    }


}
