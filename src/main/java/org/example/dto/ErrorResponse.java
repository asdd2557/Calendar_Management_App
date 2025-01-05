package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data

public class ErrorResponse {
    private int status;         // HTTP 상태 코드
    private String errorCode;   // 커스텀 에러 코드
    private String errorMessage;// 에러 메시지

    // 생성자
    public ErrorResponse(int status, String errorCode, String errorMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    // Getter
    public int getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
