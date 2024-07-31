--1씩 증가하는 숫자 시퀀스 생성
CREATE SEQUENCE project_board_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

--project_board Table_signup 생성
create table User_SignUp (
id varchar2(30) primary key, -- 아이디
pwd varchar2(50), -- 비밀번호
name varchar2(15)  not  null, -- 이름
logtime date -- 날짜
);

--project_board Table 생성
create table Board_Post (
seq number,
id varchar2(30), -- 아이디
title varchar2(100) unique,  -- 제목
content varchar2(500), -- 내용
logtime date -- 날짜
);






