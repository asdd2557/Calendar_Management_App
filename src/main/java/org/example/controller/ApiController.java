package org.example.controller;

import org.example.dto.ScheduleDeleteRequestDto;
import org.example.dto.SchedulePutRequestDTO;
import org.example.entity.Schedule;
import org.example.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class ApiController {

    private final ScheduleService scheduleService;

    public ApiController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public void createSchedule(@RequestBody Schedule schedule) {
        schedule.setStartDateTime(LocalDateTime.now().withNano(0));
        schedule.setUpdateDateTime(LocalDateTime.now().withNano(0));
        scheduleService.saveSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> getSchedules(
            @RequestParam(required = false) String startDateTime,
            @RequestParam(required = false) String endDateTime,
            @RequestParam(required = false) String userName
    ) {
        LocalDateTime start= startDateTime != null ? LocalDateTime.parse(startDateTime).withNano(0) : null;
        LocalDateTime end = endDateTime != null ? LocalDateTime.parse(endDateTime).withNano(0) : null;
        return scheduleService.findSchedulesByPeriod(start, end, userName);
    }

    @PutMapping("/{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody SchedulePutRequestDTO requestDTO) {
        scheduleService.updateSchedule(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestBody ScheduleDeleteRequestDto requestDto) {
        scheduleService.deleteSchedule(id, requestDto);
    }
    @DeleteMapping("/all")
    public void deleteAllSchedule(){
        scheduleService.deleteAll();
    }
}
