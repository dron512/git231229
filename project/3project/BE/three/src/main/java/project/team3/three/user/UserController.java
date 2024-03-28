package project.team3.three.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.team3.three.exception.BizException;
import project.team3.three.exception.ErrorCode;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "UserController", description = "회원 정보 조회, 등록, 수정, 삭제")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("{userId}")
    @Operation(summary = "사용자 한명 보기", description = "사용자 한명의 정보를 조회 할 수 있습니다.")
    @Parameters(
            @Parameter(description = "조회하고자 하는 사용자 ID를 입력하세요.",
                    name = "userId",
                    required = true)
    )
    public ResponseEntity<User> getUserById(
            @PathVariable Long userId) {
        System.out.println(userId);

        User user = userService.getUserByuserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        user.setModifyDate(LocalDateTime.now());

        User dbUser = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser);
    }
    @PutMapping("withdraw")
    public ResponseEntity<String> withdrawUser(@RequestBody @Valid UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        user.setModifyDate(LocalDateTime.now());

        User dbUser = userService.withdrawUser(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser.getWithdrawStatus().toString());

    }
}


