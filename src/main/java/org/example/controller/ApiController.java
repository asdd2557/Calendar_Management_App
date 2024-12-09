package org.example.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.ScheduleRequestDTO;
import org.example.entity.Schedule;
import org.example.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class ApiController {
    private final ScheduleService scheduleService;

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ScheduleRequestDTO updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDTO scheduleRequestDTO,
            @RequestParam String password // 비밀번호를 쿼리 파라미터로 전달
    ) {
        return scheduleService.updateSchedule(id, scheduleRequestDTO, password);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }

    @DeleteMapping("/all")
    public void allDeleteSchedule() {
        scheduleService.allDeleteSchedule();
    }
    @GetMapping
    public List<ScheduleRequestDTO> getSchedules(
            @RequestParam(required = false) String startDateTime,
            @RequestParam(required = false) String endDateTime,
            @RequestParam(required = false) String userName
    ) {
        // 파라미터 파싱
        LocalDateTime startDate = (startDateTime != null && !startDateTime.isEmpty())
                ? LocalDateTime.parse(startDateTime)
                : null;

        LocalDateTime endDate = (endDateTime != null && !endDateTime.isEmpty())
                ? LocalDateTime.parse(endDateTime)
                : null;

        return scheduleService.getSchedulesByPeriod(startDate, endDate, userName);
    }

}
