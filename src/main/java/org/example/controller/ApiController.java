package org.example.controller;

import org.example.dto.ScheduleDeleteRequestDto;
import org.example.dto.SchedulePutRequestDTO;
import org.example.entity.Schedule;
import org.example.handler.Validator;
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
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id) {
        return scheduleService.findScheduleById(id);
    }
    @PostMapping
    public void createSchedule(@RequestBody Schedule schedule) {
        Validator.validateEmail(schedule.getUserName());
        Validator.validatePassword(schedule.getPassword());
        scheduleService.saveSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> getSchedules(
            @RequestParam(required = false) String startDateTime,
            @RequestParam(required = false) String endDateTime,
            @RequestParam(required = false) String userName
    ) {
        LocalDateTime start = startDateTime != null ? LocalDateTime.parse(startDateTime).withNano(0) : null;
        LocalDateTime end = endDateTime != null ? LocalDateTime.parse(endDateTime).withNano(0) : null;
        return scheduleService.findSchedulesByPeriod(start, end, userName);
    }

    @PutMapping("/{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody SchedulePutRequestDTO requestDTO) {
        Validator.validatePassword(requestDTO.getPassword());
        scheduleService.updateSchedule(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestBody ScheduleDeleteRequestDto requestDto) {
        Validator.validatePassword(requestDto.getPassword());
        scheduleService.deleteSchedule(id, requestDto);
    }

    @DeleteMapping("/all")
    public void deleteAllSchedules() {
        scheduleService.deleteAll();
    }
}
