package com.onezogreen.onezo3.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    public final ScheduleMapper scheduleMapper;

    public List<ScheduleVo> scheduleSelect(Long store_id){
        List<ScheduleVo>schedulList = scheduleMapper.scheduleSelect(store_id);
        return schedulList;
    }

    public boolean scheduleInsert(Long store_id, ScheduleVo scheduleVo){
        scheduleVo.setStore_id(store_id);
        boolean check = scheduleMapper.scheduleInsert(scheduleVo);
        return check;
    }

    public boolean scheduleUpdate(Long schedule_id, ScheduleVo scheduleVo){
        scheduleVo.setSchedule_id(schedule_id);
        boolean check = scheduleMapper.scheduleUpdate(scheduleVo);
        return check;
    }

    public boolean scheduleDelete(Long schedule_id){
        boolean check = scheduleMapper.scheduleDelete(schedule_id);
        return check;
    }

    public boolean regularHolidayInsert(RegularHolidayVo regularHolidayVo){
        boolean check = true;
        scheduleMapper.regularHolidayInsert(regularHolidayVo);
        return check;
    }
}
