package org.example.service;

import org.example.dto.ScheduleDeleteRequestDto;
import org.example.dto.SchedulePutRequestDTO;
import org.example.entity.Schedule;
import org.example.repository.ScheduleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {
    private final JdbcTemplate jdbcTemplate;
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(JdbcTemplate jdbcTemplate, ScheduleRepository scheduleRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName) {
        return scheduleRepository.findSchedulesByPeriod(startDateTime, endDateTime, userName);
    }

    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, SchedulePutRequestDTO requestDTO) {
        scheduleRepository.update(id, requestDTO);
    }

    public void deleteSchedule(Long id, ScheduleDeleteRequestDto requestDto) {
        scheduleRepository.deleteById(id, requestDto);
    }
    public void deleteAll(){
        scheduleRepository.deleteAll();
    }
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }
}
