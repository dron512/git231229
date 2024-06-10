package com.onezogreen.onezo3.menu;

import com.onezogreen.onezo3.review.replyDelete_yn;
import com.onezogreen.onezo3.review.reviewDelete_yn;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class MenuVo {
    private Long menu_id;
    private Long store_id;
    private String menu_name;
    private String menu_image;
    private String  menu_category;
    private sold_out_yn sold_out_yn;
}
