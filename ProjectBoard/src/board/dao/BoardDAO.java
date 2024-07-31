package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardDTO;

public class BoardDAO {
    //JDBC 드라이버 로드, 오라클 접속
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ip or name으로 수정
    private String username = "c##java";
    private String password = "1234";
    
    private Connection con; //오라클 연결하는 객체
    private PreparedStatement pstmt; //JDBC => TCP를 이용하는 프로그램
    private ResultSet rs; //

    //싱글톤 인스턴스를 위한 변수
    private static BoardDAO instance = new BoardDAO();


    public BoardDAO(){
        try {
            Class.forName(driver); //리플렉션 => 클래스의 정보를 읽어서 메모리 할당
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
    }

    //인스턴스를 반환하는 메서드
    public static BoardDAO getInstance()
    {
        return instance;
    }

    //오라클 연결 메서드
    public void getConnection(){
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //오라클 해제 메서드
    public void disConnection(){
        try {
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    } //오라클 닫아주기 (메모리누수)
    
    public void signUp(BoardDTO boardDTO) {
        
    	getConnection();
    	
    	String sql = "INSERT INTO User_SignUp (id, pwd, name, logtime) VALUES (?, ?, ?, SYSDATE)";
        try {
        	pstmt = con.prepareStatement(sql);
        	
            pstmt.setString(1, boardDTO.getId());
            pstmt.setString(2, boardDTO.getPwd());
            pstmt.setString(3, boardDTO.getName());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            disConnection();
        }
    }
    
    public String login(String id, String pwd) {
    	String name = null;
    	
    	getConnection();
    	
        String sql = "SELECT name FROM User_SignUp WHERE id = ? AND pwd = ?";
        try {
        	pstmt = con.prepareStatement(sql);
        	
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	name = rs.getString("name");
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            disConnection();
        }
        return name;
    }
    
    public void writePost(String id, String title, String content) {
    	getConnection();
    	
    	String sql = "INSERT INTO Board_Post values (SEQ.NEXTVAL, ?, ?, ?, sysdate)";
    	
    	try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
    }
    
    public List<BoardDTO> viewPosts(String id) {
    	getConnection();
    	List<BoardDTO> posts = new ArrayList<BoardDTO>();
    	
    	String sql = "SELECT * FROM Board_Post JOIN User_SignUp ON Board_Post.id = User_SignUp.id WHERE User_SignUp.id = ?";
    	try {
        	pstmt = con.prepareStatement(sql);
        	
            pstmt.setString(1, id);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	BoardDTO post = new BoardDTO(
            			rs.getInt("seq"),
            			rs.getString("id"),
            			rs.getString("name"),
            			rs.getString("title"),
            			rs.getString("content"),
            			rs.getDate("logtime")
            			);
            	posts.add(post);
            }    
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            disConnection();
        }
    	return posts;        
    }
    
    public void selectseq(int seq) {
    	getConnection();
    	
    	String sql = "SELECT * FROM Board_Post WHERE SEQ = ?";
    	
    	try {
        	pstmt = con.prepareStatement(sql);
        	
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	System.out.println("글번호 : " + rs.getInt("seq") + "\t" + "작성시간 : " + rs.getDate("logtime") + "\n" + "제목 : " + rs.getString("title") + "\n" + "내용 : " + rs.getString("content") + "\n");
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            disConnection();
        }
    }
    
    public void modifyPost(int seq, String title, String content) {
    	getConnection();
    	
    	String sql = "UPDATE Board_Post SET title = ?, content = ? WHERE seq = ?";
        try {
        	pstmt = con.prepareStatement(sql);
        	
        	pstmt.setString(1, title);
        	pstmt.setString(2, content);
            pstmt.setInt(3, seq);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            disConnection();
        }
    }
    
    public void deletePost(String id, int seq) {
    	getConnection();
    	
    	String sql = "DELETE FROM Board_Post WHERE seq = ? and id = ?";
        try {
        	pstmt = con.prepareStatement(sql);
        	
        	pstmt.setInt(1, seq);
        	pstmt.setString(2, id);
            pstmt.executeUpdate();            
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            disConnection();
        }
    }

}
