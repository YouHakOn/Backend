# Backend

# 📘 Git 브랜치 및 커밋 컨벤션

## ✅ 브랜치 전략

우리 프로젝트에서는 브랜치를 다음과 같은 규칙으로 생성합니다.

### 🔹 기능/일반 이슈 작업

- 브랜치명 형식:  
  `YOUHAK-<이슈번호>`

- 예시:  
  `YOUHAK-101`

### 🔹 긴급 수정 (Hotfix)

- 브랜치명 형식:  
  `Hotfix-<이슈번호>`

- 예시:  
  `Hotfix-202`

---

## ✅ 커밋 메시지 컨벤션

커밋 메시지는 다음과 같은 형식을 따릅니다:

### 커밋 태그 종류

- `feat`: 새로운 **기능 추가**
- `chore`: 빌드 업무, 패키지 매니저 설정 등 **기타 변경**
- `infra`: **인프라** 관련 작업
- `docs`: **문서** 코드 추가 및 수정
- `test`: **테스트** 코드 추가 및 수정
- `refactor`: **리팩토링** (기능 변경 없이 구조 개선)

### 커밋 메시지 예시(only _English_)

- feat: add login feature
- infra: modify Docker compose settings
- chore: update package dependencies
- docs: update README with commit convention
- test: add unit test for user registration
- refactor: remove duplicate code

---

## ✅ Pull Request 규칙

- PR 제목 형식:  
  `[YOUHAK-<이슈번호>] <작업 요약>`

- PR 생성 시 체크리스트:
  - 리뷰어 지정 필수
  - 관련 이슈 번호 연결 (예: `Closes #101`)

---

## ✅ 코드 컨벤션

- 우리 프로젝트에서는 Java 코드는 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 기반으로 작성된 [우아한테크코스 자바 스타일 가이드](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 따릅니다.
- 패키지 구조는 계층 기반이 아닌 **책임 기반 모듈 구조**를 따릅니다.

| 패키지명   | 역할 설명                                                           |
| ---------- | ------------------------------------------------------------------- |
| `shared`   | 공통 유틸, 상수, 예외, 어노테이션 등 **범용적으로 재사용되는 자원** |
| `global`   | 전역 설정, AOP, 예외 처리 등 **Spring 애플리케이션 전반 설정 구성** |
| `external` | **외부 시스템** (API, DB, 메시지 등)과의 통신 어댑터                |
| `domain`   | **핵심 비즈니스 도메인 모델과 로직**                                |

### 추가 규칙

- 클래스 선언 직후에는 한 줄을 띄웁니다.
