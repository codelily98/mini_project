package board.service;

import java.sql.*;
import java.util.Scanner;

public class BoardMain {

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@tang9:1521:xe"; // ip or name으로 수정
    private String username = "c##java";
    private String password = "1234";
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BoardMain() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getConnection() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int num;
        Board board = null;

        while (true) {
            System.out.println("**********관리**********");
            System.out.println("        1.회원가입");
            System.out.println("        2.로그인");
            System.out.println("        3.게시판");
            System.out.println("        4.종료");
            System.out.println("**********관리**********");
            System.out.print("번호 선택 : ");
            num = scanner.nextInt();

            if (num == 4) break;
            else if(num == 1) board = new SignUpService();
            else if(num == 2) board = new LoginService();
            else if(num == 3) board = new BoardService();
            else {
                System.out.println("1~4번 중에 선택하세요");
                continue;
            }
            board.excute();
        }//while
    }//menu()
}


