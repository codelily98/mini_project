package board.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class BoardDTO{
	
	public BoardDTO(int seq, String id, String name, String title, String content, Date logtime) {
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.logtime = logtime;
	}
	
    //아이디, 비밀번호, 이름, 제목, 내용, 날짜
	private int seq;
    private String id;
    private String pwd;
    private String name;
    private String title;
    private String content;
    private Date logtime;
    
    @Override
    public String toString() {
    	return "글번호 : " + seq + "\t" + "작성시간 : " + logtime + "\n" + "아이디 : " + id + "\t" + "이름 : "
    					  + name + "\n" + "제목 : " + title + "\n" + "내용 : " + content + "\n";
    }
}



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