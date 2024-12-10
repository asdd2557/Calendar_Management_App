{
    "info": {
        "name": "API 명세서"
    },
    "item": [
        {
            "name": "일정 생성",
            "request": {
                "method": "POST",
                "header": [
                    {
                        "key": "Content-Type",
                        "value": "application/json"
                    }
                ],
                "body": {
                    "mode": "raw",
                    "raw": "{\n    \"userName\": \"exampleUser\",\n    \"description\": \"Meeting with client\",\n    \"startDateTime\": \"2024-12-09T12:00:00\"\n}"
                },
                "url": {
                    "raw": "http://localhost:8080/api/books",
                    "host": ["localhost"],
                    "path": ["api", "books"]
                }
            },
            "response": []
        }
    ]
}
