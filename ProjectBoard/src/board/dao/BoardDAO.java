package board.dao;

import board.bean.BoardDTO;

import java.sql.*;

public class BoardDAO {
    //JDBC 드라이버 로드, 오라클 접속
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@tang9:1521:xe"; // ip or name으로 수정
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
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    //오라클 해제 메서드
    public void disConnection(){
        try {
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } //오라클 닫아주기 (메모리누수?)

    public int writeService(BoardDTO boardDTO) {
        int su = 0;

        getConnection();
        String sql = "insert into ProjectBoard values(seqs.NEXTVAL, ?, ?, ?, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql); //가이드 생성
            //?에 데이터 매핑
            pstmt.setString(1, boardDTO.getId());
            pstmt.setString(2, boardDTO.getPw());
            pstmt.setString(3, boardDTO.getName());
            pstmt.setString(4, boardDTO.getSubject());
            pstmt.setString(5, boardDTO.getContent());
            pstmt.setDate(6,boardDTO.getDate());
            su = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            disConnection();
        }
        return su;
    }

}
