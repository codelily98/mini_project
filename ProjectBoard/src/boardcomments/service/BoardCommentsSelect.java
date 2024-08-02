package boardcomments.service;

import java.util.Scanner;

import board.service.Board;

public class BoardCommentsSelect implements Board {
	
	private int boardPostsID;

    public BoardCommentsSelect(int boardPostsID) {
        this.boardPostsID = boardPostsID;
    }
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		
		int num;
		
		Board board = null;
		
		while(true) {
			System.out.println();
			System.out.println("[댓글 설정]");
			System.out.println("1. 댓글 수정");			
			System.out.println("2. 댓글 삭제");
			System.out.println("3. 이전 메뉴");
			
			System.out.print("번호 입력 : ");
			num = scanner.nextInt();
			
			if(num == 3) break;
			if(num == 1) board = new BoardCommentsUpdate(boardPostsID);
			else if(num == 2) board = new BoardCommentsDelete(boardPostsID);
			else {
				System.out.println("1~3번 사이의 번호를 입력해주세요.");
			}
			board.execute();
		}
		
	}
}
