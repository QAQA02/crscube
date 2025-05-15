# 학생 관리 시스템

## 개요

본 API는 학생 정보를 등록, 조회, 수정, 삭제할 수 있는 RESTful 서비스입니다.  
JWT 토큰 기반 인증을 사용하며, 토큰 발급 API도 포함되어 있습니다.

# API

## 인증 토큰 발급

- **POST** /auth/token
- 인증에 사용할 JWT 토큰을 발급합니다.

**응답 예시**
```
HTTP/1.1 200 OK
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

## 학생 등록

- **POST** /students
- **설명:** 새로운 학생을 등록합니다.  
- **요청 바디**
```json
{
  "studentNo": 3218, // 학번
  "name": "홍길동" // 이름
}
```

## 학생 정보 조회

- **GET** /students?studentNo={studentNo}
- 학번(studentNo)으로 학생 정보를 조회합니다.  
- **요청 파라미터:**  
  - studentNo (int, 필수)

**응답 예시**
```json
{
  "no": 1,
  "studentNo": 3218,
  "name": "홍길동"
}
```

## 학생 목록 조회

- **GET** /students/list  
- 등록된 모든 학생 목록을 조회합니다.

**응답 예시**
```json
[
  {
    "no": 1,
    "studentNo": 3218,
    "name": "홍길동"
  },
  {
    "no": 2,
    "studentNo": 1103,
    "name": "최현호"
  }
]
```

## 학생 정보 수정

- **PUT** /students  
- 학생 정보를 수정합니다.  
- **요청 바디 예시**
```json
{
  "no": 1,
  "studentNo": 2103,
  "name": "최현호"
}
```

## 학생 삭제

- **DELETE:** /students?no={no}
- 학생 정보를 삭제합니다.  
- **요청 파라미터:**  
  - no 

## 공통 사항

- 학생 관련 API 호출 시 반드시 HTTP Header에 JWT 토큰을 포함해야 합니다.  
```
Authorization: Bearer {발급받은_토큰}
```
