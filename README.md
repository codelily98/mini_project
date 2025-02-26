![title.png](attachment:832afa02-a116-48ec-a7cc-5580a290e70e:title.png)

**요약**

- 24년 8월 2일부터 4일까지 진행한 Java의 기본기 확립 및 웹페이지 기능 기본기 확립을 위한 미니 게시판 개인 프로젝트.

**역할**

- ERD 설계 및 FlowChart 작성
- 프로젝트 구조 및 기능 설계/구현

**기능**

- 회원
    - 회원가입
    - 로그인
    - 로그아웃
    - 정보수정
    - 회원탈퇴
- 게시판
    - 글 작성
    - 글 수정
    - 글 삭제
    - 댓글 작성
    - 댓글 수정
    - 댓글 삭제

**성과**

- ERD 작성을 통한 관계 구조 이해
- FlowChart 작성을 통한 기능 설계 경험
- Java의 인터페이스에 대한 이해
- 기능과 DB연결에 대한 이해

**시기**

- 프로젝트 진행 기간 (2024.08.02 ~ 2024.08.04)

# 📝Skills & Tools

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/e5e2038a-96fb-4f59-89ad-f7af09a12fc0/Untitled.png)

---

# 📝ERD

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/5197ea24-97aa-48a0-af5c-66413ff44287/Untitled.png)

---

# 📝Project Structure

---

```
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
```

---

# 📝FlowChart

---

### [메인 화면]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/9d31a71b-23f6-4ab1-a4b2-b0035aa76857/Untitled.png)

### [회원가입]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/0fa99492-02e7-4c2d-b6a0-5e23758fd8f3/Untitled.png)

### [로그인]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/f6727b88-980c-46a8-b672-ab97b03248d6/Untitled.png)

### [로그아웃]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/0b2b6a67-f1d6-4ca1-938d-5b7e8ae03104/Untitled.png)

### [게시판 메뉴 화면]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/a0af4d94-6e13-47d2-9c80-e427951a9894/Untitled.png)

### [게시글 작성]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/c23039f0-dbcb-4d37-80e9-97dfa9aced27/Untitled.png)

### [게시글 목록 및 댓글 작성 & 수정  & 삭제]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/ae6d9bff-acf2-49b8-9da6-004fc4cd319a/Untitled.png)

### [게시글 수정]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/ab635bc9-e021-4e0e-94cd-179641083da9/Untitled.png)

### [게시글 삭제]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/d321f2c0-b125-48bd-9191-dbe5c5d4920b/Untitled.png)

### [회원정보 메뉴]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/90115229-8ffd-45a4-b2c0-974d77e83749/Untitled.png)

### [회원정보 수정]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/a493e8d5-04ed-4d2b-8158-f4abb25fe468/Untitled.png)

### [회원정보 삭제]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/c1be7066-efbd-4d75-aefa-53fb11aba111/Untitled.png)

### [프로그램 종료]

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/4fcacab6-3bc3-4192-b8f3-c2f0b88df883/Untitled.png)

---

# 📝Run Program

---

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/d61bf60b-797a-4e6f-b5fb-ec1584bbb00b/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/29ced62a-6214-49f9-912e-5b219f7d4a1d/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/b5c85573-5efc-4556-b8ab-136a18c91e8e/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/d0f38317-807a-400d-a455-1f790c011cc0/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/f58fc42c-eb43-4b86-ba04-45a162eab705/34b0c790-85c2-4732-812e-55e4ffe55d31/Untitled.png)

---

[◀ 이전 페이지 돌아가기](https://www.notion.so/191f7fcc4bde80fdb314fb8f344b97f2?pvs=21)
