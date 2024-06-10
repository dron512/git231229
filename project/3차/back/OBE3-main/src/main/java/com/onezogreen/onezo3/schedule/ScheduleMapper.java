package com.onezogreen.onezo3.schedule;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    List<ScheduleVo> scheduleSelect(Long store_id);

    boolean scheduleInsert(ScheduleVo scheduleVo);

    boolean scheduleUpdate(ScheduleVo scheduleVo);

    boolean scheduleDelete(Long schedule_id);

    void regularHolidayInsert(RegularHolidayVo regularHolidayInsert) ;
}
