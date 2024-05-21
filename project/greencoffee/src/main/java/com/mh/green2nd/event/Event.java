package com.mh.green2nd.event;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "event")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(name = "eventimgurl", nullable = true)
    @Schema(title = "이벤트상세이미지url주소",description = "이벤트상세이미지url주소")
    private String eventimgurl;
}
