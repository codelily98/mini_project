package board.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import boardposts.service.BoardPostsService;
import usersstatus.service.UsersStatusLogin;
import usersstatus.service.UsersStatusService;
import usersstatus.service.UsersStatusWrite;
import usersstatus.service.UsersStatusLogOut;

public class BoardService {	
	
	public void menu() {
        Scanner scanner = new Scanner(System.in);
        int num;
        Board board = null;
        
        while (true) {
        	System.out.println("       [메인화면]");
            System.out.println("**********관리**********");
            System.out.println("        1.회원가입");
            System.out.println("        2.로그인");
            System.out.println("        3.로그아웃");
            System.out.println("        4.게시판 접속");
            System.out.println("        5.회원정보 수정");
            System.out.println("        6.종료");
            System.out.println("**********관리**********");
            System.out.print("번호 선택 : ");
            
            try {
            	num = scanner.nextInt();
                
                if (num == 6) break;
                else if(num == 1) board = new UsersStatusWrite();
                else if(num == 2) board = new UsersStatusLogin();
                else if(num == 3) board = new UsersStatusLogOut();
                else if(num == 4) board = new BoardPostsService();
                else if(num == 5) board = new UsersStatusService();
                else {
                    System.out.println("1~6번 중에 선택하세요");
                    continue;
                }
                if (board != null) {
                    board.execute();
                }
                
            } catch(InputMismatchException e) {
            	System.out.println("숫자만 입력해주세요.");
            	scanner.next();
            	System.out.println();
            }
            
        }//while
    }//menu()
}
