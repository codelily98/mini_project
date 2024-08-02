package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardPostsDTO;
import board.bean.UsersStatusDTO;

public class BoardPostsDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	private static BoardPostsDAO instance = new BoardPostsDAO();	//SingTon Static으로 1번 설정
	
	private Connection connection;	//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	private ResultSet resultSet;	//인터페이스
	
	public BoardPostsDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	// 예외처리
	}
	
	public static BoardPostsDAO getInstance() {
		return instance;
	}
	
	public void getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public int boardPostsWrite(BoardPostsDTO boardPostsDTO) {		
		int su = 0;
		
		getConnection();
		
		String sql = "Insert into BoardPosts (BoardPostsID, UsersStatusID, Title, Content) Values(BoardPosts_seq.NEXTVAL, ?, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, boardPostsDTO.getUsersStatusID());
			pstmt.setString(2, boardPostsDTO.getTitle());
			pstmt.setString(3, boardPostsDTO.getContent());	
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}

	public void boardPostsPrintList() {
		
		getConnection();	
		
		String sql = "select BoardPostsID, Title, CreatedAt from BoardPosts";
		
		try {
			pstmt = connection.prepareStatement(sql);

			resultSet = pstmt.executeQuery();	
			
			while(resultSet.next()) {
				System.out.println("번호 : " + resultSet.getInt("BoardPostsID") + "\t제목 : " + resultSet.getString("Title") + "\t작성일 : " + resultSet.getString("CreatedAt"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();	// 에러코드 추적
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void boardPostsPrintContent(int boardPostsID) {
		getConnection();	
		
		String sql = "select BoardPosts.BoardPostsID, UsersStatus.Username, BoardPosts.Title, "
				+ "BoardPosts.Content, BoardPosts.CreatedAt, BoardPosts.UpdatedAt from BoardPosts Join UsersStatus "
				+ "On BoardPosts.UsersStatusID = UsersStatus.UsersStatusID where BoardPosts.BoardPostsID = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, boardPostsID);

			resultSet = pstmt.executeQuery();	
			
			while(resultSet.next()) {
				System.out.println("번호 : " + resultSet.getInt("BoardPostsID") + "\t아이디 : " + resultSet.getString("Username")
				 				+ "\n작성일 : " + resultSet.getTimestamp("CreatedAt") + "\n수정일 : " + resultSet.getTimestamp("UpdatedAt") 
								+ "\n제목 : " + resultSet.getString("Title") + "\n내용 : " + resultSet.getString("Content"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();	// 에러코드 추적
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
}
