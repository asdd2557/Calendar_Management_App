package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Schedule {

    private Long id;
    private String password;
    private String userName;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime updateDateTime;

    // 생성자: 기본 시간 설정
    public Schedule() {
        this.startDateTime = LocalDateTime.now().withNano(0);
        this.updateDateTime = LocalDateTime.now().withNano(0);
    }

    // 생성자 오버로드: 초기 값을 직접 설정
    public Schedule(Long id, String password, String userName, String description, LocalDateTime startDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.description = description;
        this.startDateTime = (startDateTime != null) ? startDateTime : LocalDateTime.now().withNano(0);
        this.updateDateTime = (updateDateTime != null) ? updateDateTime : LocalDateTime.now().withNano(0);
    }

    // 업데이트 시 시간 갱신 메서드
    public void updateTimestamps() {
        this.updateDateTime = LocalDateTime.now().withNano(0);
    }
}
