package boardcomments.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.bean.BoardCommentsDTO;
import board.dao.BoardCommentsDAO;
import board.service.Board;

public class BoardCommentsDelete implements Board {
	
	private int boardPostsID; // 게시글 번호를 저장하기 위한 필드

    public BoardCommentsDelete(int boardPostsID) {
        this.boardPostsID = boardPostsID;
    }
	
	@Override
	public void execute() {
		
		Scanner scanner = new Scanner(System.in);

		int num;
		
		System.out.println();
		System.out.println("[댓글 삭제]");
		System.out.print("번호 : ");	
		
		try {
			num = scanner.nextInt();
			
			BoardCommentsDAO boardCommentsDAO = BoardCommentsDAO.getInstance();
			BoardCommentsDTO boardCommentsDTO = new BoardCommentsDTO();
			
			boardCommentsDTO.setBoardCommentsID(num);
			System.out.println();
			
			int result = boardCommentsDAO.commentsDelete(boardCommentsDTO);
			
			if(result > 0) {
				System.out.println(result + "건의 댓글 삭제가 완료되었습니다.");
				System.out.println();
				boardCommentsDAO.printCommentsOnBoardPosts(boardPostsID);
				System.out.println();
			} else {
				System.out.println("댓글 삭제에 실패했습니다.");
				System.out.println();
			}
			
		} catch (InputMismatchException e) {
            System.out.println("숫자만 입력해주세요!");
            scanner.next();
            System.out.println();
        }
	}
}
