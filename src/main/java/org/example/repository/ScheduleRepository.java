package org.example.repository;


import org.example.dto.ScheduleDeleteRequestDto;
import org.example.dto.SchedulePutRequestDTO;
import org.example.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository {
    List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName);
    void save(Schedule schedule);
    void update(Long id, SchedulePutRequestDTO requestDTO);


    void deleteById(Long id, ScheduleDeleteRequestDto requestDto);
    void deleteAll();
    List<Schedule> findAll();
}

