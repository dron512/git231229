package com.three.alcoholshoppingmall.project.review;


import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.exception.ErrorCode;
import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.market.MarketRepository;
import com.three.alcoholshoppingmall.project.purchase.Purchase;
import com.three.alcoholshoppingmall.project.purchase.PurchaseRepository;
import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final AlcoholRepository alcoholRepository;
    private final UserRepository userRepository;
    private final MarketRepository marketRepository;
    private final PurchaseRepository purchaseRepository;

    public List<Reviewshow> Reviewlist(String email) {
        List<String> alcoholnames = reviewRepository.names(email);
        List<Review> reviews = reviewRepository.reviews(email);

        List<Reviewshow> list = new ArrayList<>();
        for (int i = 0; i < Math.min(alcoholnames.size(), reviews.size()); i++) {
            User user = userRepository.findByEmail(email);
            String name = alcoholnames.get(i);
            Review review = reviews.get(i);
            Reviewshow reviewshow = Reviewshow
                    .builder()
                    .id(review.getId())
                    .nickname(user.getNickname())
                    .alcoholcode(review.getAlcohol().getCode())
                    .name(name)
                    .grade(review.getGrade())
                    .writing(review.getWriting())
                    .picture(review.getPicture())
                    .date(review.getCreateDate())
                    .build();
            list.add(reviewshow);
        }
        return list;
    }

    public Reviewshow Review(ReviewDTO reviewDTO) {
        Optional<Alcohol> alcoholcheck = alcoholRepository.findByCode(reviewDTO.getAlcoholcode());
        Optional<Review> check = reviewRepository.findByUser_EmailAndAlcohol_Code(reviewDTO.getUser().getEmail(), reviewDTO.getAlcoholcode());
        Optional<Purchase> Purchasecheck = purchaseRepository.reviewPpurchase(reviewDTO.getUser().getEmail(),reviewDTO.getAlcoholcode());
        Review review;
        Reviewshow reviewshow;
        if(Purchasecheck.isPresent()) {
            if (alcoholcheck.isPresent()) {
                if (check.isPresent()) {
                    Review existingReview = check.get();
                    existingReview.setWriting(reviewDTO.getWriting());
                    existingReview.setGrade(reviewDTO.getGrade());
                    reviewRepository.save(existingReview);
                    String alcoholname = alcoholRepository.name(reviewDTO.getAlcoholcode());
                    reviewshow = Reviewshow
                            .builder()
                            .id(existingReview.getId())
                            .nickname(reviewDTO.getUser().getNickname())
                            .alcoholcode(existingReview.getAlcohol().getCode())
                            .name(alcoholname)
                            .writing(reviewDTO.getWriting())
                            .grade(reviewDTO.getGrade())
                            .picture(existingReview.getPicture())
                            .date(existingReview.getCreateDate())
                            .build();
                } else {
                    User usercheck = userRepository.findByEmail(reviewDTO.getUser().getEmail());
                    Alcohol alcohol = alcoholcheck.get();
                    review = Review.builder()
                            .user(usercheck)
                            .alcohol(alcohol)
                            .writing(reviewDTO.getWriting())
                            .grade(reviewDTO.getGrade())
                            .picture(alcohol.getPicture())
                            .build();
                    reviewRepository.save(review);
                    String alcoholname = alcoholRepository.name(reviewDTO.getAlcoholcode());
                    reviewshow = Reviewshow
                            .builder()
                            .id(review.getId())
                            .nickname(reviewDTO.getUser().getNickname())
                            .alcoholcode(review.getAlcohol().getCode())
                            .name(alcoholname)
                            .writing(reviewDTO.getWriting())
                            .grade(reviewDTO.getGrade())
                            .picture(alcohol.getPicture())
                            .date(review.getCreateDate())
                            .build();
                }
                return reviewshow;
            } else {
                throw new BizException(ErrorCode.NOTFOUNDALCOHOL);
            }
        }
            else{
                throw new BizException(ErrorCode.NOTFOUNDPURCHASE);
            }

    }

    @Transactional
    public String ReviewDelete(User user, ReviewDelete reviewDelete) {
        Optional<Review> check = reviewRepository.findByUser_EmailAndId(user.getEmail(), reviewDelete.getId());
        String Review;
        if (check.isPresent()) {
            reviewRepository.deleteByUser_EmailAndId(user.getEmail(), reviewDelete.getId());
            Review = "리뷰가 삭제 되었습니다.";
        } else {
            throw new BizException(ErrorCode.NOTFOUNDREVIEW);
        }
        return Review;
    }

    public List<ReviewCheck> Cherklist(String email) {
        List<ReviewCheck> list = new ArrayList<>();
        List<Alcohol> alcohol = alcoholRepository.alcoholreview(email);
        List<Market> market = marketRepository.marketreview(email);
        List<Purchase> purchase = purchaseRepository.purchasereview(email);
        for (int i = 0; i < alcohol.size(); i++) {
            Alcohol alcohols = alcohol.get(i);
            Market markets = market.get(i);
            Purchase purchases = purchase.get(i);
            ReviewCheck reviewCheck = ReviewCheck
                    .builder()
                    .alcoholcode(alcohols.getCode())
                    .name(alcohols.getName())
                    .marketname(markets.getMarketname())
                    .delivery(markets.getDelivery())
                    .purchaseday(purchases.getPurchaseday())
                    .picture(alcohols.getPicture())
                    .build();
            list.add(reviewCheck);
        }
        return list;
    }

    public List<Reviewshow> AlcoholReview(Long code) {
        Optional<Alcohol> alcohol = alcoholRepository.findByCode(code);
        List<Review> reviews = reviewRepository.findByAlcohol_Code(code);
        List<User> users = userRepository.reviewnickname(code);
        List<Reviewshow> list = new ArrayList<>();
        if (alcohol.isPresent()) {
            Alcohol alcohols = alcohol.get();
            for (int i = 0; i < reviews.size(); i++) {
                Review review = reviews.get(i);
                User user = users.get(i);
                Reviewshow reviewshow = Reviewshow.builder()
                        .alcoholcode(code)
                        .nickname(user.getNickname())
                        .name(alcohols.getName())
                        .writing(review.getWriting())
                        .picture(review.getPicture())
                        .grade(review.getGrade())
                        .date(review.getCreateDate())
                        .build();
                list.add(reviewshow);
            }
            return list;
        } else {
            throw new BizException(ErrorCode.NOTFOUNDALCOHOL);
        }
    }
}