package com.onezogreen.onezo3.schedule;

import com.onezogreen.onezo3.menu.sold_out_yn;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleVo {
    private Long schedule_id;
    private Long store_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String content;
    private delete_yn delete_yn;
}
