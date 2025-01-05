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

    public Schedule() {
        this.startDateTime = LocalDateTime.now().withNano(0);
        this.updateDateTime = LocalDateTime.now().withNano(0);
    }

    public void update(String contents, String password) {
        validatePassword(password);
        this.description = contents;
        this.updateDateTime = LocalDateTime.now();
    }

    public void delete(String password) {
        validatePassword(password);
    }

    private void validatePassword(String inputPassword) {
        if (!this.password.equals(inputPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
