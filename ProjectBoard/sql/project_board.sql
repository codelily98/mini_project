-- 회원 테이블
CREATE TABLE UsersStatus (
    UsersStatusID NUMBER PRIMARY KEY,              -- UserID를 NUMBER로 수정
    UserID VARCHAR2(50) NOT NULL UNIQUE,
    Password VARCHAR2(50) NOT NULL,
    Username VARCHAR2(100) NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    IsOnline NUMBER DEFAULT 0 -- 로그인 상태를 나타내는 컬럼
);

-- 게시판 테이블
CREATE TABLE BoardPosts (
    BoardPostsID NUMBER PRIMARY KEY,              -- PostID를 NUMBER로 수정
    UsersStatusID NUMBER,                          -- UserID를 NUMBER로 수정
    Title VARCHAR2(100) NOT NULL,
    Content CLOB NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (UsersStatusID) REFERENCES UsersStatus(UsersStatusID) -- 외래 키 제약 조건
);

-- 댓글 테이블
CREATE TABLE BoardComments (
    BoardCommentsID NUMBER PRIMARY KEY,           -- CommentID를 NUMBER로 수정
    BoardPostsID NUMBER,                         -- PostID를 NUMBER로 수정
    UsersStatusID NUMBER,                         -- UserID를 NUMBER로 수정
    Content CLOB NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_Posts FOREIGN KEY (BoardPostsID) REFERENCES BoardPosts(BoardPostsID), -- 외래 키 제약 조건
    CONSTRAINT fk_Users FOREIGN KEY (UsersStatusID) REFERENCES UsersStatus(UsersStatusID)   -- 외래 키 제약 조건
);

CREATE SEQUENCE UsersStatus_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE BoardPosts_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE BoardComments_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

---------------------------------------------------------
select * from UsersStatus;
select * from BoardPosts;
select * from BoardComments;

commit;