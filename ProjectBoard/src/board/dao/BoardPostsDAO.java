package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			System.out.println("driver loading");
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
			System.out.println("connection");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
