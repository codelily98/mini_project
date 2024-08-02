package boardposts.service;

import java.util.Scanner;

import board.service.Board;

public class BoardPostsService implements Board { 
	
	@Override
	public void execute() {
		System.out.println();
	    Scanner scanner = new Scanner(System.in);
	        
	    int num;
	    Board board = null;
	        
	    while (true) {
	    	System.out.println("        [게시판]");
	        System.out.println("**********관리**********");
	        System.out.println("        1.게시글 작성");
	        System.out.println("        2.게시글 목록");
	        System.out.println("        3.게시글 수정");
	        System.out.println("        4.게시글 삭제");
	        System.out.println("        5.이전 메뉴");
	        System.out.println("**********관리**********");
	        System.out.print("번호 선택 : ");
	        num = scanner.nextInt();

	        if (num == 5) break;
	        else if(num == 1) board = new BoardPostsWrite();
	        else if(num == 2) board = new BoardPostsList();
	        else if(num == 3) board = new BoardPostsUpdate();
	        else if(num == 4) board = new BoardPostsDelete();
	        else {
	            System.out.println("1~6번 중에 선택하세요");
	            continue;
	        }
	        board.execute();
	    }//while
		
	}
}
