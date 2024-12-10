# API 명세서

## 프로젝트 개요
- **프로젝트 이름:** 일정 관리 API
- **설명:** 이 API는 일정 데이터를 생성, 조회, 수정, 삭제하는 기능을 제공합니다.
- **기술 스택:** Java, Spring Boot, MySQL

---

## API 목록
1. [일정 생성 (Create Schedule)](#1-일정-생성-create-schedule)
2. [일정 조회 (Get Schedules)](#2-일정-조회-get-schedules)
   - 전체 일정 조회
   - 특정 작성자 조회
   - 특정 기간 조회
3. [일정 수정 (Update Schedule)](#3-일정-수정-update-schedule)
4. [일정 삭제 (Delete Schedule)](#4-일정-삭제-delete-schedule)

---

### **1. 일정 생성 (Create Schedule)**

- **Method:** POST
- **URL:** `/api/books`
- **Headers:**
  ```json
  {
      "Content-Type": "application/json"
  }






