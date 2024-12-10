-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS schedule_db;

-- 데이터베이스 사용
USE schedule_db;

-- Schedule 테이블 생성
CREATE TABLE IF NOT EXISTS Schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,        -- 일정 ID
    userName VARCHAR(255) NOT NULL,             -- 작성자 이름
    description TEXT NOT NULL,                  -- 일정 내용
    password VARCHAR(255) NOT NULL,             -- 비밀번호
    startDateTime DATETIME NOT NULL,            -- 시작 시간
    updateDateTime DATETIME NOT NULL            -- 마지막 수정 시간
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
