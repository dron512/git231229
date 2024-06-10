package com.three.alcoholshoppingmall.project.alcohol;

import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.market.Marketinfo;
import com.three.alcoholshoppingmall.project.review.ReviewService;
import com.three.alcoholshoppingmall.project.review.Reviewshow;
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
@RequestMapping("/detail")
@Tag(name = "detail", description = "상세 정보를 보여주는 페이지로 토큰이 필요 합니다.")
@SecurityRequirement(name = "bearerAuth")
public class DetailController {

    private final AlcoholService alcoholService;
    private final ReviewService reviewService;

    @PostMapping("")
    @Operation(summary = "상세 페이지 정보",
            description = "선택한 술의 정보와 가격 평균 평점 리뷰 갯수가 표시됩니다." +
                    "code에 술의 번호을 입력하시면 됩니다.")
    public ResponseEntity<List<DetailInformation>> Detail(@RequestBody AlcoholDto alcoholDto) {
        List<DetailInformation> list = alcoholService.DetailPage(alcoholDto);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/market")
    @Operation(summary = "해당 술을 파는 매장",
            description = "해당 술을 판매하는 매장의 정보를 출력하여 줍니다." +
                    "code에 술의 번호을 입력하시면 됩니다.")
    public ResponseEntity<List<Marketinfo>> Market(@RequestBody AlcoholDto alcoholDto) {
        List<Marketinfo> list = alcoholService.MarketDetail(alcoholDto);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PostMapping("/alcohol")
    @Operation(summary = "해당 제품의 모든 리뷰",
            description = "해당 제품의 모든 리뷰가 보입니다.<br>" +
                    "입력 값은 필요 없습니다.")
    public ResponseEntity<List<Reviewshow>> Alcohol(@RequestBody AlcoholDto alcoholDto) {
        List<Reviewshow> list = reviewService.AlcoholReview(alcoholDto.getCode());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
