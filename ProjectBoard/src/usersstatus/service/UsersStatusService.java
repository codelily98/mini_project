package usersstatus.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import board.service.Board;

public class UsersStatusService implements Board {
	
	@Override
	public void execute() {
		System.out.println();
        Scanner scanner = new Scanner(System.in);
        
        int num;
        Board board = null;
        
        while (true) {
        	System.out.println("       [회원정보]");
            System.out.println("**********관리**********");
            System.out.println("        1.회원정보 수정");
            System.out.println("        2.회원정보 삭제");
            System.out.println("        3.이전 메뉴");
            System.out.println("**********관리**********");
            System.out.print("번호 선택 : ");
            
            try {
            	num = scanner.nextInt();

                if (num == 3) {
                	System.out.println();
                	break;                	
                }
                else if(num == 1) board = new UsersStatusUpdate();
                else if(num == 2) board = new UsersStatusDelete();
                else {
                    System.out.println("1~3번 중에 선택하세요");
                    System.out.println();
                    continue;
                }
                if (board != null) {
                    board.execute();
                }
                
            } catch(InputMismatchException e) {
            	System.out.println("숫자만 입력해주세요!");
                scanner.next();
                System.out.println();
            }
        }//while
	}
}
