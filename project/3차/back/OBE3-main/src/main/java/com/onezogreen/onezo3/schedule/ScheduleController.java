package com.onezogreen.onezo3.schedule;

import com.onezogreen.onezo3.exception.BizException;
import com.onezogreen.onezo3.exception.ErrorCode;
import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("schedule")
@RequiredArgsConstructor
public class ScheduleController {

    public final ScheduleService scheduleService;

    @GetMapping("select")
    @Operation(summary = "일정을 조회합니다")
    public List<ScheduleVo> selectSchedule( Authentication authentication){
        ManagerVo managerVo = (ManagerVo)authentication.getPrincipal();
        Long store_id = managerVo.getStore_id();
        List<ScheduleVo>schedulList = scheduleService.scheduleSelect(store_id);
        if(schedulList == null || schedulList.isEmpty()){
            throw new BizException(ErrorCode.NOTSELECT);
        }
        return schedulList;
    }

    @PostMapping("insert")
    @Operation(summary = "일정을 추가합니다", description = "날짜 포맷은 yyyy-MM-dd HH:mm:ss로 맞춰주세요")
    public boolean insertSchedule(Authentication authentication, @RequestBody ScheduleVo scheduleVo){
        ManagerVo managerVo = (ManagerVo)authentication.getPrincipal();
        Long store_id = managerVo.getStore_id();
        boolean check = scheduleService.scheduleInsert(store_id, scheduleVo);
        if(check == false){
            throw new BizException(ErrorCode.INSERTFAIL);
        }
        return check;
    }

    @PutMapping("update/{schedule_id}")
    @Operation(summary = "일정을 수정합니다", description = "날짜 포맷은 yyyy-MM-dd HH:mm:ss로 맞춰주세요")
    public boolean updateSchedule(@PathVariable Long schedule_id, @RequestBody ScheduleVo scheduleVo){
        boolean check = scheduleService.scheduleUpdate(schedule_id, scheduleVo);
        if(check == false){
            throw new BizException(ErrorCode.UPDATEFAIL);
        }
        return check;
    }

    @DeleteMapping("delete/{schedule_id}")
    @Operation(summary = "일정을 삭제합니다", description = "삭제여부 N -> Y")
    public boolean deleteSchedule(@PathVariable Long schedule_id){
        boolean check = scheduleService.scheduleDelete(schedule_id);
        return check;
    }

    @PostMapping("regularHoliday")
    @Operation(summary = "정기휴무 등록 ", description = "[\n" +
            "  {\n" +
            "    \"dayOfWeek\": \"월요일\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayOfWeek\": \"화요일\"\n" +
            "  }\n" +
            "]")
    public boolean insertRegularHoliday(Authentication authentication, @RequestBody List<WeekDto> weekDtos){
        try {
            ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
            Long store_id = managerVo.getStore_id();

            weekDtos.stream().forEach(
                    weekDto -> scheduleService.regularHolidayInsert(
                            RegularHolidayVo.builder()
                                    .store_id(store_id)
                                    .week(weekDto.getDayOfWeek())
                                    .build())
            );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
