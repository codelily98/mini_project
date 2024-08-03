package boardcomments.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.bean.BoardCommentsDTO;
import board.dao.BoardCommentsDAO;
import board.service.Board;

public class BoardCommentsUpdate implements Board {
	
	private int boardPostsID; // 게시글 번호를 저장하기 위한 필드

    public BoardCommentsUpdate(int boardPostsID) {
        this.boardPostsID = boardPostsID;
    }
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		
		int num;
		String content;
		
		System.out.println("[댓글 수정]");
		System.out.print("번호 : ");		
		
		try {
			num = scanner.nextInt();
			
			scanner.nextLine();
			System.out.print("댓글 수정 : ");
			content = scanner.nextLine();
			
			BoardCommentsDAO boardCommentsDAO = BoardCommentsDAO.getInstance();
			BoardCommentsDTO boardCommentsDTO = new BoardCommentsDTO();
			
			boardCommentsDTO.setBoardCommentsID(num);
			boardCommentsDTO.setContent(content);		
			
			int result = boardCommentsDAO.commentsUpdate(boardCommentsDTO);
			
			if(result > 0) {
				System.out.println(result + "건의 댓글 수정이 완료되었습니다.");
				System.out.println();
				boardCommentsDAO.printCommentsOnBoardPosts(boardPostsID);
				System.out.println();
			} else {
				System.out.println("댓글 수정에 실패했습니다.");
				System.out.println();
			}
			
		} catch (InputMismatchException e) {
            System.out.println("숫자만 입력해주세요!");
            scanner.next();
            System.out.println();
        }
	}
}
