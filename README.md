{
	"info": {
		"_postman_id": "a3fcd423-875e-429a-8658-344d2c44686f",
		"name": "API 명세서",
		"description": "## 1\\. Schedule Management API\n\n### Base URL: `/api/schedules`\n\n### Endpoints\n\n#### **1\\. Create Schedule**\n\n- **HTTP Method**: `POST`\n    \n- **Endpoint**: `/api/schedules`\n    \n- **Description**: Creates a new schedule.\n    \n- **Request Body**:\n    \n\n``` json\n{\n  \"id\": 1,\n  \"title\": \"Meeting\",\n  \"date\": \"2024-12-06\",\n  \"description\": \"Team meeting at 10 AM\"\n}\n\n ```\n\n- **Response Body**:\n    \n\n``` json\n{\n  \"id\": 1,\n  \"title\": \"Meeting\",\n  \"date\": \"2024-12-06\",\n  \"description\": \"Team meeting at 10 AM\"\n}\n\n ```\n\n#### **2\\. Get All Schedules**\n\n- **HTTP Method**: `GET`\n    \n- **Endpoint**: `/api/schedules`\n    \n- **Description**: Retrieves a list of all schedules.\n    \n- **Response Body**:\n    \n\n``` json\n[\n  {\n    \"id\": 1,\n    \"title\": \"Meeting\",\n    \"date\": \"2024-12-06\",\n    \"description\": \"Team meeting at 10 AM\"\n  },\n  {\n    \"id\": 2,\n    \"title\": \"Workshop\",\n    \"date\": \"2024-12-07\",\n    \"description\": \"Workshop on productivity\"\n  }\n]\n\n ```\n\n#### **3\\. Delete Schedule**\n\n- **HTTP Method**: `DELETE`\n    \n- **Endpoint**: `/api/schedules/{id}`\n    \n- **Description**: Deletes a schedule by its ID.\n    \n- **Path Parameters**:\n    \n    - `id` (Long): ID of the schedule to delete.\n        \n\n---\n\n## 2\\. User Management API\n\n### Base URL: `/signup`\n\n### Endpoints\n\n#### **1\\. Create User**\n\n- **HTTP Method**: `POST`\n    \n- **Endpoint**: `/signup/user`\n    \n- **Description**: Creates a new user.\n    \n- **Request Body**:\n    \n\n``` json\n{\n  \"id\": 1,\n  \"name\": \"John Doe\",\n  \"email\": \"john.doe@example.com\",\n  \"password\": \"securepassword\"\n}\n\n ```\n\n- **Response Body**:\n    \n\n``` json\n{\n  \"id\": 1,\n  \"name\": \"John Doe\",\n  \"email\": \"john.doe@example.com\",\n  \"password\": \"securepassword\"\n}\n\n ```\n\n  \n\n## 3\\. Page Rendering API\n\n### Endpoints\n\n#### **1\\. Home Page**\n\n- **HTTP Method**: `GET`\n    \n- **Endpoint**: `/home`\n    \n- **Description**: Renders the home page.\n    \n- **View Template**: `/home/home`\n    \n\n#### **2\\. Login Page**\n\n- **HTTP Method**: `GET`\n    \n- **Endpoint**: `/login`\n    \n- **Description**: Renders the login page.\n    \n- **View Template**: `/login/login`\n    \n\n#### **3\\. Signup Page**\n\n- **HTTP Method**: `GET`\n    \n- **Endpoint**: `/signup`\n    \n- **Description**: Renders the signup page.\n    \n- **View Template**: `/signup/signup`",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "33827299"
	},
	"item": [
		{
			"name": "User",
			"item": [
				{
					"name": "Get authenticated user",
					"event": [
						{
							"listen": "test",
							"script": {
								"exec": [
									""
								],
								"type": "text/javascript"
							}
						}
					],
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "https://api.getpostman.com/me",
							"protocol": "https",
							"host": [
								"api",
								"getpostman",
								"com"
							],
							"path": [
								"me"
							]
						},
						"description": "Gets information about the authenticated user."
					},
					"response": [
						{
							"name": "Successful Response",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "https://api.getpostman.com/me",
									"protocol": "https",
									"host": [
										"api",
										"getpostman",
										"com"
									],
									"path": [
										"me"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json",
									"name": "Content-Type",
									"description": {
										"content": "",
										"type": "text/plain"
									}
								}
							],
							"cookie": [],
							"body": "{\n    \"user\": {\n        \"id\": 12345678,\n        \"username\": \"taylor-lee\",\n        \"email\": \"taylor.lee@example.com\",\n        \"fullName\": \"Taylor Lee\",\n        \"avatar\": \"https://example.com/user/r5u9qpvmujfjf6lbqmga.jpg\",\n        \"isPublic\": true\n    },\n    \"operations\": [\n        {\n            \"name\": \"mock_usage\",\n            \"limit\": 1000000,\n            \"usage\": 110276,\n            \"overage\": 0\n        },\n        {\n            \"name\": \"monitor_request_runs\",\n            \"limit\": 10000000,\n            \"usage\": 1141750,\n            \"overage\": 0\n        },\n        {\n            \"name\": \"api_usage\",\n            \"limit\": 1000000,\n            \"usage\": 16240,\n            \"overage\": 0\n        },\n        {\n            \"name\": \"custom_domains\",\n            \"limit\": 25,\n            \"usage\": 25,\n            \"overage\": 0\n        },\n        {\n            \"name\": \"serverless_requests\",\n            \"limit\": 10000,\n            \"usage\": 0,\n            \"overage\": 0\n        },\n        {\n            \"name\": \"integrations\",\n            \"limit\": 5000,\n            \"usage\": 1018,\n            \"overage\": 0\n        },\n        {\n            \"name\": \"cloud_agent_requests\",\n            \"limit\": 1000000,\n            \"usage\": 1615,\n            \"overage\": 0\n        }\n    ]\n}"
						},
						{
							"name": "Rate Limit Exceeded",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "https://api.getpostman.com/me",
									"protocol": "https",
									"host": [
										"api",
										"getpostman",
										"com"
									],
									"path": [
										"me"
									]
								}
							},
							"status": "Too Many Requests",
							"code": 429,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json",
									"description": {
										"content": "",
										"type": "text/plain"
									}
								}
							],
							"cookie": [],
							"body": "{\n    \"error\": \"rateLimited\",\n    \"message\": \"Rate limit exceeded. Please retry after 1669048687\"\n}"
						}
					]
				}
			],
			"description": "The `/me` endpoints let you manage information about the authenticated user."
		},
		{
			"name": "Calendar_Management_App",
			"item": [
				{
					"name": "Post",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Get_All",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Get_Date",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Get_UserName",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Delete_ID",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Delete_All",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "Put_Password",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				}
			]
		}
	],
	"auth": {
		"type": "apikey",
		"apikey": [
			{
				"key": "key",
				"value": "X-API-Key",
				"type": "string"
			},
			{
				"key": "value",
				"value": "{{token}}",
				"type": "string"
			}
		]
	},
	"event": [
		{
			"listen": "prerequest",
			"script": {
				"type": "text/javascript",
				"exec": [
					""
				]
			}
		},
		{
			"listen": "test",
			"script": {
				"type": "text/javascript",
				"exec": [
					""
				]
			}
		}
	],
	"variable": [
		{
			"key": "baseUrl",
			"value": "https://farming-simulator.pstmn.io"
		}
	]
}
