package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import board.bean.BoardCommentsDTO;

public class BoardCommentsDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	private static BoardCommentsDAO instance = new BoardCommentsDAO();	//SingTon Static으로 1번 설정
	
	private Connection connection;	//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	private ResultSet resultSet;	//인터페이스
	
	public BoardCommentsDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardCommentsDAO getInstance() {
		return instance;
	}
	
	public void getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public int addComments(BoardCommentsDTO boardCommentsDTO) {
		int result = 0;
		
		String sql = "INSERT INTO BoardComments (BoardCommentsID, BoardPostsID, UsersStatusID, Content) VALUES (BoardComments_seq.NEXTVAL, ?, ?, ?)";
		
		try {
			getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, boardCommentsDTO.getBoardPostsID());
			pstmt.setInt(2, boardCommentsDTO.getUsersStatusID());
			pstmt.setString(3, boardCommentsDTO.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void printCommentsOnBoardPosts(int boardPostsID) {
		
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		
		getConnection();
		
		String sql = "SELECT UsersStatus.UserID, BoardComments.Content, BoardComments.BoardCommentsID, BoardComments.CreatedAt "
				+ "FROM BoardComments Join UsersStatus on BoardComments.UsersStatusID = UsersStatus.UsersStatusID "
				+ "Where BoardComments.BoardPostsID = ?";
        
        try {
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setInt(1, boardPostsID);
            
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {                
                System.out.println("[댓글]\n"
                				+ "아이디 : " + resultSet.getString("UserID") + "\t작성일 : " 
                				+ simpleDateFormat.format(resultSet.getTimestamp("CreatedAt")) + "\n" 
                				+ resultSet.getInt("BoardCommentsID") + ". " + resultSet.getString("Content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	public int commentsUpdate(BoardCommentsDTO boardCommentsDTO) {
		int result = 0;
		
		getConnection();
		
		String sql = "Update BoardComments set Content = ? Where BoardCommentsID = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, boardCommentsDTO.getContent());
			pstmt.setInt(2, boardCommentsDTO.getBoardCommentsID());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return result;
	}

	public int commentsDelete(BoardCommentsDTO boardCommentsDTO) {
		int result = 0;
		
		getConnection();
		
		String sql = "Delete From BoardComments Where BoardCommentsID = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, boardCommentsDTO.getBoardCommentsID());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return result;
	}
}
