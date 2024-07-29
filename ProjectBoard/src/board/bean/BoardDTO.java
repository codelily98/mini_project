package board.bean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class BoardDTO{
    //아이디, 비밀번호, 이름, 제목, 내용, 날짜
    private String id;
    private String pw;
    private String name;
    private String subject;
    private String content;
    private Date date;

/* 테이블 생성 쿼리
create table ProjectBoard(
id varchar2(50),
pw varchar2(50),
name varchar2(30),
subject varchar2(100),
content varchar2(500),
logtime date);

select * from ProjectBoard; --테이블 확인 쿼리
--시퀀스 생성 쿼리
create sequence seqs
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 100000
NOCYCLE
NOCACHE;
*/


    public BoardDTO(Date date) {
        this.date = date;
    }

}