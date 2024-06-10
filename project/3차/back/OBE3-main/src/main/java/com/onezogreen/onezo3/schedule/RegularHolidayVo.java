package com.onezogreen.onezo3.schedule;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegularHolidayVo {
    private Long holiday_id;
    private Long store_id;
    private String week;
}
