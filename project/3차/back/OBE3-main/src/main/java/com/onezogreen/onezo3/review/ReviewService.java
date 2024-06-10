package com.onezogreen.onezo3.review;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    public final ReviewMapper reviewMapper;

    public void AddReply(Long review_id, ReviewVo reviewVo) {
        reviewVo.setReview_id(review_id);
        reviewMapper.updateReply(reviewVo);
    }
    public void DeleteReply(Long review_id, ReviewVo reviewVo){
        reviewVo.setReview_id(review_id);
        reviewMapper.deleteReply(reviewVo);
    }
    public void DeleteReview(Long review_id, ReviewVo reviewVo){
        reviewVo.setReview_id(review_id);
        reviewMapper.deleteReview(reviewVo);
    }
    public List<ReviewVo> getReviewReply(Long store_id) {
        return reviewMapper.selectReviewReply(store_id);
    }
}
