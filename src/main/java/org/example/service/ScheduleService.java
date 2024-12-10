package org.example.service;

import org.example.entity.Schedule;
import org.example.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName) {
        return scheduleRepository.findSchedulesByPeriod(startDateTime, endDateTime, userName);
    }

    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, Schedule schedule) {
        scheduleRepository.update(id, schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
    public void deleteAll(){
        scheduleRepository.deleteAll();
    }
    public List<Schedule> findAllSchedules() {
        return scheduleRepository.findAll();
    }
}
