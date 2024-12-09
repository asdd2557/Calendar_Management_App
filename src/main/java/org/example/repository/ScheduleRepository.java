package org.example.repository;

import org.example.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s " +
            "WHERE (:startDateTime IS NULL OR s.updateDateTime >= :startDateTime) " +
            "AND (:endDateTime IS NULL OR s.updateDateTime <= :endDateTime) " +
            "AND (:userName IS NULL OR s.userName = :userName) " +
            "ORDER BY s.updateDateTime DESC")
    List<Schedule> findSchedulesByPeriod(
            @Param("startDateTime") LocalDateTime startDateTime,
            @Param("endDateTime") LocalDateTime endDateTime,
            @Param("userName") String userName
    );

}
