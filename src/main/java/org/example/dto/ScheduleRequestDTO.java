package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleRequestDTO {
    private Long id;
    private String userName;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime updateDateTime;

    public static ScheduleRequestDTO fromEntity(Schedule Entity){
        ScheduleRequestDTO dto = new ScheduleRequestDTO();
        dto.setId(Entity.getId());
        dto.setUserName(Entity.getUserName());
        dto.setDescription(Entity.getDescription());
        dto.setStartDateTime(Entity.getStartDateTime());
        dto.setUpdateDateTime(Entity.getUpdateDateTime());
        return dto;
    }
}
