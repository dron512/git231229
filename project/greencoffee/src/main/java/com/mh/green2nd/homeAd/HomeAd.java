// HomeAdEntity.java

package com.mh.green2nd.homeAd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
public class HomeAd{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_head")
    private String adHead;

    @Column(name = "ad_content")
    private String adContent;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "ad_upload_time")
    private LocalDateTime adUploadTime;

    @Column(name = "ad_due_date")
    private LocalDateTime adDueDate;

    @Enumerated(EnumType.STRING)
    private HomeAdCategory category;

}
