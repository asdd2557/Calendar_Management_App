package org.example.repository;


import org.example.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository {
    List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName);
    void save(Schedule schedule);
    void update(Long id, Schedule schedule);
    void deleteById(Long id);
    void deleteAll();
    List<Schedule> findAll();
}

