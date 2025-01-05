package org.example.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePutRequestDTO {
    private String password;
    private String contents;

}
