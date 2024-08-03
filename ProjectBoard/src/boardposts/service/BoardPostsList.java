package boardposts.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.dao.BoardPostsDAO;
import board.service.Board;
import boardcomments.service.BoardCommentsWrite;

public class BoardPostsList implements Board {
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		int boardPostsID;
		
		BoardPostsDAO boardPostsDAO = BoardPostsDAO.getInstance();
		System.out.println("[게시글 목록]");
		boardPostsDAO.boardPostsPrintList();
		
		System.out.println();
		
		System.out.print("게시글 선택 : ");
		
		try {
			boardPostsID = scanner.nextInt();
			
			System.out.println();
			System.out.println("[게시글]");
			boardPostsDAO.boardPostsPrintContent(boardPostsID);
			System.out.println();
			
			BoardCommentsWrite boardCommentsWrite = new BoardCommentsWrite(boardPostsID);
			boardCommentsWrite.execute();
			
		} catch (InputMismatchException e) {
            System.out.println("숫자만 입력해주세요!");
            scanner.next();
            System.out.println();
        }
	}
}
