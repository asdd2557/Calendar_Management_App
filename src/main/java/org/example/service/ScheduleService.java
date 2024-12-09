package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ScheduleRequestDTO;
import org.example.entity.Schedule;
import org.example.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // 일정 수정
    public ScheduleRequestDTO updateSchedule(Long id, ScheduleRequestDTO dto, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with id: " + id));

        // 비밀번호 확인
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password.");
        }

        // 업데이트 가능한 필드만 수정
        schedule.setDescription(dto.getDescription());
        schedule.setUserName(dto.getUserName());
        schedule.setUpdateDateTime(LocalDateTime.now());

        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return ScheduleRequestDTO.fromEntity(updatedSchedule);
    }



    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
    public void allDeleteSchedule(){
        scheduleRepository.deleteAll();
    }
    public List<ScheduleRequestDTO> getSchedulesByPeriod(LocalDateTime startDate, LocalDateTime endDate, String userName) {
        List<Schedule> schedules = scheduleRepository.findSchedulesByPeriod(startDate, endDate, userName);
        return schedules.stream()
                .map(ScheduleRequestDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
