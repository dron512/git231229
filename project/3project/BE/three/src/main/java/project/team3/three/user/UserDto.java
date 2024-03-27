package project.team3.three.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDto {

    private Long userId;

    private String name;

    private String nickname;

    @NotBlank
    private String phoneNum;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String studies;

    private Grade grade;

    private EnrollmentStatus enrollmentStatus;

    private WithdrawStatus withdrawStatus;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime createDate;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime modifyDate;

    public static User of(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setName(user.getName());
        user.setNickname(user.getNickname());
        user.setPhoneNum(userDto.getPhoneNum());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setStudies(user.getStudies());
        user.setGrade(userDto.getGrade());
        user.setEnrollmentStatus(userDto.getEnrollmentStatus());
        user.setWithdrawStatus(userDto.getWithdrawStatus());
        user.setCreateDate(userDto.getCreateDate());
        return user;
    }


}

