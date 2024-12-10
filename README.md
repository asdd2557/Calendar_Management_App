# API 명세서

## 1. 일정 생성 (Create Schedule)

```
Method: POST
URL: /api/books
Headers: 
{
    "Content-Type": "application/json"
}
Request Body: 
{
    "userName": "exampleUser",
    "description": "Meeting with client",
    "startDateTime": "2024-12-09T12:00:00"
}
Response: 
{
    "id": 1,
    "userName": "exampleUser",
    "description": "Meeting with client",
    "startDateTime": "2024-12-09T12:00:00",
    "updateDateTime": "2024-12-09T12:00:00"
}
```

## 2. 일정 조회 (Get Schedules)

### 2.1 전체 일정 조회

```
Method: GET
URL: /api/books
Description: 전체 일정을 조회합니다.
Response: 
[
    {
        "id": 1,
        "userName": "exampleUser",
        "description": "Meeting with client",
        "startDateTime": "2024-12-09T12:00:00",
        "updateDateTime": "2024-12-09T12:00:00"
    }
]
```

### 2.2 특정 작성자 조회

```
Method: GET
URL: /api/books?userName=exampleUser
Description: 특정 작성자의 일정을 조회합니다.
Query Parameters: 
- userName (string, optional): 작성자 이름.
Response: 
[
    {
        "id": 1,
        "userName": "exampleUser",
        "description": "Meeting with client",
        "startDateTime": "2024-12-09T12:00:00",
        "updateDateTime": "2024-12-09T12:00:00"
    }
]
```

### 2.3 특정 기간 조회

```
Method: GET
URL: /api/books?startDateTime=2024-12-01T00:00:00&endDateTime=2024-12-09T23:59:59
Description: 특정 기간에 해당하는 일정을 조회합니다.
Query Parameters: 
- startDateTime (string, optional): 조회 시작 날짜/시간.
- endDateTime (string, optional): 조회 종료 날짜/시간.
Response: 
[
    {
        "id": 1,
        "userName": "exampleUser",
        "description": "Meeting with client",
        "startDateTime": "2024-12-01T10:00:00",
        "updateDateTime": "2024-12-05T15:00:00"
    }
]
```

## 3. 일정 수정 (Update Schedule)

```
Method: PUT
URL: /api/books/{id}?password=1234
Description: 일정의 작성자 이름 또는 내용을 수정합니다.
Path Parameters: 
- id (long, required): 수정할 일정의 ID.
Query Parameters: 
- password (string, required): 수정 권한을 확인하기 위한 비밀번호.
Request Body: 
{
    "userName": "Updated User",
    "description": "Updated description"
}
Response: 
{
    "id": 1,
    "userName": "Updated User",
    "description": "Updated description",
    "startDateTime": "2024-12-09T12:00:00",
    "updateDateTime": "2024-12-09T14:30:00"
}
```

## 4. 일정 삭제 (Delete Schedule)

```
Method: DELETE
URL: /api/books/{id}?password=1234
Description: 특정 일정을 삭제합니다.
Path Parameters: 
- id (long, required): 삭제할 일정의 ID.
Query Parameters: 
- password (string, required): 삭제 권한을 확인하기 위한 비밀번호.
Response: 
{
    "message": "Schedule successfully deleted."
}
```

## ERD (Entity-Relationship Diagram)
**URL:** https://www.erdcloud.com/d/sKYFNWfiBu76SYhSj
```

+-----------------------------+
|          Schedule           |
+-----------------------------+
| id: Long                   |
| userName: String           |
| description: String        |
| password: String           |
| startDateTime: LocalDateTime |
| updateDateTime: LocalDateTime |
+-----------------------------+
```

## 사용 방법

```
1. 서버 실행 후 http://localhost:8080 에서 API 호출.
2. Postman 또는 Curl 명령어로 테스트.
```
