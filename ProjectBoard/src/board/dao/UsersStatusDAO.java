package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.UsersStatusDTO;

public class UsersStatusDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	private static UsersStatusDAO instance = new UsersStatusDAO();	//SingTon Static으로 1번 설정
	
	private Connection connection;	//인터페이스
	private PreparedStatement pstmt;	//인터페이스
	private ResultSet resultSet;	//인터페이스
	
	private UsersStatusDTO loggedInUser; // 로그인된 사용자 정보 유지
	
	public UsersStatusDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	// 예외처리
	}
	
	public static UsersStatusDAO getInstance() {
		return instance;
	}
	
	public void getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public int usersStatusWrite(UsersStatusDTO usersStatusDTO) {
		int su = 0;
		
		getConnection();
		
		String sql = "insert into UsersStatus (UsersStatusID, UserID, Password, Username) values(UsersStatus_seq.nextval, ?, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, usersStatusDTO.getUserID());
			pstmt.setString(2, usersStatusDTO.getPassword());
			pstmt.setString(3, usersStatusDTO.getUsername());
			
			su = pstmt.executeUpdate(); //데이터 입력
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
		return su;
		
	}
	
	public boolean isExistId(String userID) {
		boolean exist = false;
		
		getConnection();
		String sql = "select * from UsersStatus where userID = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userID);
			
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				exist = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(resultSet != null) resultSet.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return exist;
	}
	
	public boolean isExistPwd(String password) {
        //비밀번호 확인 메서드
        boolean exist = false;
        //불린형 변수설정. default값은 false 설정.
        getConnection();
        String sql = "select * from UsersStatus where Password = ?";

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, password);
            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                exist = true; //
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exist;
    }

	public String usersStatusLogin(String userID, String password) {
		String username = null;
		
		getConnection();
		
		String sql1 = "Select Username, UsersStatusID from UsersStatus Where UserID = ? and Password = ?";
		String sql2 = "Update UsersStatus set IsOnline = 1 where UserID = ?";
		try {
			pstmt = connection.prepareStatement(sql1);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			
			resultSet = pstmt.executeQuery();
			            
            if(resultSet.next()) {	
            	username = resultSet.getString("Username");
            	
            	loggedInUser = new UsersStatusDTO();
                loggedInUser.setUsersStatusID(resultSet.getInt("UsersStatusID"));
                loggedInUser.setUserID(userID);
                loggedInUser.setUsername(username);
            	
            	pstmt = connection.prepareStatement(sql2);
    			pstmt.setString(1, userID);
    			pstmt.executeUpdate();
            }            
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(resultSet != null) resultSet.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return username;
	}
	
	public UsersStatusDTO getLoggedInUser() {
        return loggedInUser;
    }
	
	public void setloggedInUser(UsersStatusDTO user) {
		this.loggedInUser = user;
	}

	public int usersStatusLogOut(int usersStatusID) {
		int result = 0;
		
		getConnection();
		
		String sql = "Update UsersStatus set IsOnline = 0 where UsersStatusID = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, usersStatusID);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int usersStatusDelete(String userID) {
		
		int result = 0;
		
		getConnection();    
        
        String sql = "delete from UsersStatus where UserID =?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userID);
            
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

	public int update(UsersStatusDTO usersStatusDTO) {
		int su = 0;
        getConnection();
        String sql = "Update UsersStatus set Password =?, Username =? where UserID =?";

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usersStatusDTO.getPassword());
            pstmt.setString(2, usersStatusDTO.getUsername());
            pstmt.setString(3, usersStatusDTO.getUserID());
            
            su = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("회원정보 수정에 실패했습니다.");
            }
        }
        return su;
	}
	
	public UsersStatusDTO getMember(String userID) {
		UsersStatusDTO usersStatusDTO = null; //객체 선언과 초기화
        getConnection();

        String sql = "select * from UsersStatus where UserID =?";
        //UsersStatus테이블에서 주어진 UserID와 일치하는 행을 선택.
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userID); //첫번째 파라미터(?)에 UserID값을 설정
            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                usersStatusDTO = new UsersStatusDTO();
                usersStatusDTO.setPassword(resultSet.getString("Password"));
                usersStatusDTO.setUsername(resultSet.getString("Username"));
                usersStatusDTO.setUserID(resultSet.getString("UserID"));
                //입력한 Paaword와 Username를 받아와서 새로운 DTO객체에 저장.
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
        return usersStatusDTO;
	}
}
