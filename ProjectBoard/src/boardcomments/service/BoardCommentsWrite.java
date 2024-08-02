package boardcomments.service;

import java.util.Scanner;

import board.bean.BoardCommentsDTO;
import board.dao.BoardCommentsDAO;
import board.dao.UsersStatusDAO;
import board.service.Board;

public class BoardCommentsWrite implements Board {
	
	private int boardPostsID;
	
	public BoardCommentsWrite(int boardPostsID) {
		this.boardPostsID = boardPostsID;
	}
	
	@Override
	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		String content = null;
		
		UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
		
        if (usersStatusDAO.getLoggedInUser() == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }
        
        int loggedInUserID = usersStatusDAO.getLoggedInUser().getUsersStatusID();
        
		System.out.print("댓글 입력 : ");
		content = scanner.nextLine();
				
		BoardCommentsDTO boardCommentsDTO = new BoardCommentsDTO();
		boardCommentsDTO.setBoardPostsID(boardPostsID);
		boardCommentsDTO.setUsersStatusID(loggedInUserID);
		boardCommentsDTO.setContent(content);
		
		BoardCommentsDAO boardCommentsDAO = BoardCommentsDAO.getInstance();
		int result = boardCommentsDAO.addComments(boardCommentsDTO);
		
		System.out.println();
		
		if(result > 0) {
			System.out.println(result + "건의 댓글이 등록되었습니다.");
			boardCommentsDAO.printCommentsOnBoardPosts(boardPostsID);
			
			BoardCommentsSelect boardCommentsSelect = new BoardCommentsSelect(boardPostsID);
			boardCommentsSelect.execute();
		} else {
			System.out.println("댓글 등록에 실패했습니다.");
		}
	}
}
