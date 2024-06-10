package com.three.alcoholshoppingmall.project.review;


import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholDto;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Tag(name = "reviewpicture", description = "마이 페이지 입니다.")
@SecurityRequirement(name = "bearerAuth")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/list")
    @Operation(summary = "내 리뷰 목록",
            description = "해당 회원이 작성한 리뷰들을 보여 주는 기능입니다.<br>" +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Reviewshow>> ReviewList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Reviewshow> list = reviewService.Reviewlist(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("")
    @Operation(summary = "내 리뷰 등록 이미 있는경우 수정",
            description = "해당 술에 리뷰를 남기는 기능으로 이미 해당 술에 리뷰를 남긴경우 글과 평점 사진을 수정 하는 기능입니다." +
                    "alcohol에 술의 고유 코드의 입력이 필요 합니다.<br>" +
                    "코드는 1~50까지 있습니다.<br>" +
                    "writing 는 리뷰 글, grade는 평점으로 0~10까지만 입력이 가능합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Reviewshow> Review(@RequestBody ReviewDTO reviewDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        reviewDTO.setUser(user);
        Reviewshow list = reviewService.Review(reviewDTO);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("")
    @Operation(summary = "내 리뷰 삭제",
            description = "해당 술에 리뷰를 지우는 기능 입니다.<br>" +
                    "고유 id 값의 입력이 필요합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> ReviewDeleteA(@RequestBody ReviewDelete reviewDelete) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String list = reviewService.ReviewDelete(user, reviewDelete);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/check")
    @Operation(summary = "리뷰 가능한 제품 확인",
            description = "리뷰 작성이 가능한 제품을 확이하는 기능 입니다.<br>" +
                    "입력 값은 필요 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<ReviewCheck>> Cherk() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<ReviewCheck> list = reviewService.Cherklist(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}