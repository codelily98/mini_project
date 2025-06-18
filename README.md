## 미니 게시판

간단한 게시판 프로젝트를 구상하였습니다. 글을 작성하고 댓글을 달 수 있는 게시판을 구현했습니다.

## 기술스택

<img src="https://storage.googleapis.com/next-step-assets/miniboard/stack.png" />

## ERD

<img src="https://storage.googleapis.com/next-step-assets/miniboard/erd.png" />

## FLOWCHART

<img src="https://storage.googleapis.com/next-step-assets/miniboard/flowchart.png" />

## 기능

- 회원
  - 회원가입
  - 로그인/로그아웃
  - 정보수정
  - 회원탈퇴
- 게시판
  - 글 작성/수정/삭제
  - 댓글 작성/수정/삭제

## 프로젝트 구조

src
│
├── board
│   ├── bean
│   │   ├── BoardCommentsDTO.java
│   │   ├── BoardPostsDTO.java
│   │   └── UsersStatusDTO.java
│   │
│   ├── dao
│   │   ├── BoardCommentsDAO.java
│   │   ├── BoardPostsDAO.java
│   │   └── UsersStatusDAO.java
│   │
│   ├── main
│   │   └── BoardMain.java
│   │
│   ├── service
│   │   ├── Board.java (interface)
│   │   └── BoardService.java
│   │
│   ├── boardcomments
│   │   └── service
│   │       ├── BoardCommentsDelete.java
│   │       ├── BoardCommentsList.java
│   │       ├── BoardCommentsUpdate.java
│   │       └── BoardCommentsWrite.java
│   │
│   ├── boardposts
│   │   └── service
│   │       ├── BoardPostsDelete.java
│   │       ├── BoardPostsList.java
│   │       ├── BoardPostsService.java
│   │       ├── BoardPostsUpdate.java
│   │       └── BoardPostsWrite.java
│   │
│   └── usersstatus
│       └── service
│           ├── UsersStatusDelete.java
│           ├── UsersStatusLogin.java
│           ├── UsersStatusLogOut.java
│           ├── UsersStatusService.java
│           ├── UsersStatusUpdate.java
│           └── UsersStatusWrite.java

## 역할 (BE/FE)

- **BE**
  - 프로젝트 구조 및 기능 설계/구현
  - Oracle DB 테이블 설계 및 구현
  - 회원 기능 구현 (회원가입/탈퇴, 로그인/로그아웃, 정보수정)
  - 커뮤니티 기능 구현 (글/댓글 작성/수정/삭제)

## 성과

- JDBC를 활용한 Oracle DB 연동
- Java 인터페이스 기반 프로그램 구조 이해

## 프로젝트 리뷰

- **Keep**  
  - 성공적인 DB 연동

- **Problem**  
  - 콘솔 기반이라 가독성과 활용성이 떨어짐  
    - 추후 HTML/CSS를 학습하여 개선 예정

## 느낀점

- Java의 인터페이스와 구조화를 통해 프로그램 구성 방식 이해
- JDBC와 DB 연동, 입력 기반 로직 구현 경험

## 실행화면
- **메인화면**
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/main.png" />
- **회원가입**
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/register.png" />
- **로그인**
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/login-success.png" />
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/login-fail.png" />
- **마이페이지**
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/info.png" />
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/info-update.png" />
- **게시판**
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-menu.png" />
- 게시글 목록
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-list.png" />
- 게시글 상세보기
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-details.png" />
- 게시글 작성
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-write.png" />
- 게시글 수정
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-update.png" />
- 게시글 삭제
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-delete.png" />
- 댓글 작성
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-comment.png" />
- 댓글 수정
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-update.png" />
- 댓글 삭제
<img src="https://storage.googleapis.com/next-step-assets/miniboard/run/board-delete.png" />
