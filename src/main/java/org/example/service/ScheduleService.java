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

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    public Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID에 대한 스케줄이 존재하지 않습니다."));
    }
    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, SchedulePutRequestDTO requestDTO) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID에 대한 스케줄이 없습니다."));
        schedule.update(requestDTO.getContents(), requestDTO.getPassword());
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id, ScheduleDeleteRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID에 대한 스케줄이 없습니다."));
        schedule.delete(requestDto.getPassword());
        scheduleRepository.deleteById(id, requestDto);
    }

    public List<Schedule> findSchedulesByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime, String userName) {
        return scheduleRepository.findSchedulesByPeriod(startDateTime, endDateTime, userName);
    }

    public void deleteAll() {
        scheduleRepository.deleteAll();
    }
}
