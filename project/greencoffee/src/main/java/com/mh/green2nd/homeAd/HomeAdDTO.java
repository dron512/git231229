// HomeAdDTO.java

package com.mh.green2nd.homeAd;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class HomeAdDTO {
    private String adHead;
    private String adContent;
    private String imageUrl; // 이미지 URL 추가
    private LocalDateTime adUploadTime;
    private LocalDateTime adDueDate;

    // Other fields as needed
}
