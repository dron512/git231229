package com.onezogreen.onezo3.review;

import com.onezogreen.onezo3.exception.BizException;
import com.onezogreen.onezo3.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;

    @Operation(summary = "리뷰,댓글,별점 조회",
            description = "store_id를 param값으로 받아서 review, reply, star를 리스트로 조회"
    )
    @GetMapping("/select/{store_id}")
    public ResponseEntity<List<ReviewVo>> getReviewReply(@PathVariable Long store_id) {
        List<ReviewVo> reviewReply = reviewService.getReviewReply(store_id);
        if (reviewReply == null || reviewReply.isEmpty()) {
            throw new BizException(ErrorCode.NOTSELECT);
        }

        return ResponseEntity.ok(reviewReply);
    }

    @Operation(summary = "댓글 달기 & 수정",
            description = "review_id를 param값으로 받아서 reply를 body값으로 보내면 성공여부를 알려줌"
    )
    @PutMapping("/reply/update/{review_id}")
    public String addReply(@PathVariable Long review_id, @RequestBody ReviewVo reviewVo) {
        reviewService.AddReply(review_id, reviewVo);

        return "댓글 달기(수정)성공";
    }

    @Operation(summary = "댓글 삭제",
            description = "review_id를 parm값으로 받아서 replyDelete_yn 값을 기본값인 N 에서 Y로 바꿔줌"
    )
    @PutMapping("/reply/delete/{review_id}")
    public String deleteReply(@PathVariable Long review_id, ReviewVo reviewVo) {
        reviewService.DeleteReply(review_id, reviewVo);

        return "댓글 삭제 성공";
    }

    @Operation(summary = "댓글 삭제",
            description = "review_id를 parm값으로 받아서 reviewDelete_yn 값을 기본값인 N 에서 Y로 바꿔줌"
    )
    @PutMapping("/delete/{review_id}")
    public String deleteReview(@PathVariable Long review_id, ReviewVo reviewVo) {
        reviewService.DeleteReview(review_id, reviewVo);

        return "리뷰 삭제 성공";
    }

}
