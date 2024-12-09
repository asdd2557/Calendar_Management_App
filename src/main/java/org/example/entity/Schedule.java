package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.ScheduleRequestDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String userName;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime updateDateTime;

    @PrePersist
    public void prePersist() {
        this.startDateTime = (this.startDateTime == null) ? LocalDateTime.now().withNano(0) : this.startDateTime;
        this.updateDateTime = (this.updateDateTime == null) ? LocalDateTime.now().withNano(0) : this.updateDateTime;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDateTime = LocalDateTime.now().withNano(0);
    }
}

