package org.example.repository;


import org.example.dto.ScheduleDeleteRequestDto;
import org.example.dto.SchedulePutRequestDTO;
import org.example.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName);
    void save(Schedule schedule);
    void update(Long id, SchedulePutRequestDTO requestDTO);
    Optional<Schedule> findById(Long id);

    void deleteById(Long id, ScheduleDeleteRequestDto requestDto);
    void deleteAll();
    List<Schedule> findAll();
}

