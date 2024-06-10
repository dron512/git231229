package com.onezogreen.onezo3.review;

import lombok.*;

import java.lang.reflect.Member;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewVo {

    private Long review_id;
    private Long member_id;
    private Long store_id;
    private int star;
    private String comment;
    private String reply;
    private reviewDelete_yn reviewDelete_yn;
    private replyDelete_yn replyDelete_yn;
    private String nickname;

}
