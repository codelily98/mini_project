package boardposts.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.dao.BoardPostsDAO;
import board.service.Board;

public class BoardPostsDelete implements Board {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

        int num;
        
        BoardPostsDAO boardPostsDAO = BoardPostsDAO.getInstance();
        boardPostsDAO.boardPostsPrintList();
        
        System.out.println();
        System.out.println("[게시글 삭제]");
        System.out.print("삭제할 게시글 번호: ");
        
        try {
        	num = scanner.nextInt();
            
            int result = boardPostsDAO.boardPostsDelete(num);

            System.out.println();
            if (result > 0) {
                System.out.println(result + "건의 게시글 삭제가 완료되었습니다.");
                System.out.println();
            } 
        	
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력해주세요!");
            scanner.next();
            System.out.println();
        }
	}
}
