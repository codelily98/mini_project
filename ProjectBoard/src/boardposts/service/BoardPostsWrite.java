package boardposts.service;

import java.util.Scanner;

import board.bean.BoardPostsDTO;
import board.dao.BoardPostsDAO;
import board.dao.UsersStatusDAO;
import board.service.Board;

public class BoardPostsWrite implements Board {
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		
		String title;
		String content;
		
		UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
		
        if (usersStatusDAO.getLoggedInUser() == null) {
            System.out.println("로그인이 필요합니다.");
            System.out.println();
            return;
        }
		
		System.out.println("[게시글 작성]");
		System.out.print("제목 : ");
		title = scanner.next();
		scanner.nextLine();
		System.out.print("내용 : ");
		content = scanner.nextLine();
		
		BoardPostsDTO boardPostsDTO = new BoardPostsDTO();
		
		boardPostsDTO.setUsersStatusID(usersStatusDAO.getLoggedInUser().getUsersStatusID());
		boardPostsDTO.setTitle(title);
		boardPostsDTO.setContent(content);
		
		BoardPostsDAO boardPostsDAO = BoardPostsDAO.getInstance();
		int su = boardPostsDAO.boardPostsWrite(boardPostsDTO);
		
		System.out.println();
		if(su > 0) {
			System.out.println("게시글 작성이 완료되었습니다.");
			System.out.println();
		} else {
			System.out.println("게시글 작성에 실패하였습니다.");
			System.out.println();
		}
	}
}
