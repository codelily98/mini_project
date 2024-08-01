package board.contents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardContents_Method {

    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;
    Connection conn;
    ConnectingUser conUser = new ConnectingUser();

    // 현재 게시글 작성 시간을 받아오는 메소드
    public String thisTime() {
        conn = new Connect();
        conn.connect();
        String time = null;
        try {
            stmt = conn.con.createStatement();
            String sql = "SELECT CURRENT_TIMESTAMP"; // 현재 시간을 받아오는 쿼리문
            rs = stmt.executeQuery(sql); // 쿼리실행
            if (rs.next()) {
                time = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("시간 출력 실패: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn.con != null) conn.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return time;
    }

    // 게시글 작성 메소드
    public void write(String title, String content, String time, String id) {
        conn = new Connect();
        conn.connect();
        try {
            String sql = "INSERT INTO BOARDPOSTS (title, content, timestamp, user_id) VALUES (?, ?, ?, ?)";
            pstmt = conn.con.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, time);
            pstmt.setString(4, id); // 접속중인 유저의 id를 받아옴
            pstmt.executeUpdate();
            System.out.println("성공적으로 게시물이 작성되었습니다.");
        } catch (SQLException e) {
            System.out.println("게시물 작성 실패: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn.con != null) conn.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 게시글 목록 : 수정 삭제할 때 포함
    public void select() {
        conn = new Connect();
        conn.connect();
        try {
            stmt = conn.con.createStatement();
            String sql = "SELECT * FROM BOARDPOSTS";
            rs = stmt.executeQuery(sql); // 쿼리실행
            System.out.println("글 목록");
            while (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                String time = rs.getString("timestamp");
                String id = rs.getString("user_id"); // 글의 정보를 변수에 저장해 출력
                System.out.printf("제목: %s, 내용: %s, 작성시간: %s, 작성자: %s%n", title, content, time, id);
            }
        } catch (SQLException e) {
            System.out.println("게시글이 없습니다: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn.con != null) conn.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 글의 작성자를 출력하는 메소드 : 수정/삭제할 게시물의 작성자가 로그인한 사용자 본인과 동일한지 확인하는 기능
    public String writerId(String text) {
        conn = new Connect();
        conn.connect();
        String id = null;
        try {
            String sql = "SELECT user_id FROM BOARDPOSTS WHERE title = ?";
            pstmt = conn.con.prepareStatement(sql);
            pstmt.setString(1, text);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getString("user_id"); // user_id 가져옴
            }
        } catch (SQLException e) {
            System.out.println("해당하는 게시글이 없습니다: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn.con != null) conn.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    // 자신의 작성 게시글을 수정하는 메소드
    public void update(String originalTitle, String newTitle, String content, String id) {
        conn = new Connect();
        conn.connect();
        try {
            String sql = "UPDATE BOARDPOSTS SET title = ?, content = ? WHERE user_id = ? AND title = ?";
            pstmt = conn.con.prepareStatement(sql);
            pstmt.setString(1, newTitle);
            pstmt.setString(2, content);
            pstmt.setString(3, id);
            pstmt.setString(4, originalTitle);
            pstmt.executeUpdate();
            System.out.println("글 내용 수정 완료");
        } catch (SQLException e) {
            System.out.println("해당 게시물이 존재하지 않습니다: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn.con != null) conn.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 자신이 작성한 게시글을 삭제하는 메소드
    public void delete(String id, String title) {
        conn = new Connect();
        conn.connect();
        try {
            String sql = "DELETE FROM BOARDPOSTS WHERE user_id = ? AND title = ?";
            pstmt = conn.con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
            System.out.println("글 삭제 성공");
        } catch (SQLException e) {
            System.out.println("삭제 실패: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn.con != null) conn.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
