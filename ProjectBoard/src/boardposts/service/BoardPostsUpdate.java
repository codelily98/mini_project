package boardposts.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.bean.BoardPostsDTO;
import board.dao.BoardPostsDAO;
import board.dao.UsersStatusDAO;
import board.service.Board;

public class BoardPostsUpdate implements Board {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		
		String title;
		String content;
		int num ;
		
        UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
        
        
        // 사용자가 로그인했는지 확인
        if (usersStatusDAO.getLoggedInUser() == null) {
            System.out.println("로그인이 필요합니다.");
            System.out.println();
            return;
        }
        BoardPostsDAO boardPostsDAO = BoardPostsDAO.getInstance();
        boardPostsDAO.boardPostsPrintList();
        
        System.out.println();
        System.out.print("수정할 글의 번호 입력: ");
        
        try {
        	num = scanner.nextInt();
        	
            scanner.nextLine(); // 개행 문자 소비
            System.out.print("수정할 제목 : ");
            title = scanner.nextLine();
            
            System.out.print("수정할 내용 : ");
            content = scanner.nextLine();
            
            BoardPostsDTO boardPostsDTO = new BoardPostsDTO();
            boardPostsDTO.setBoardPostsID(num);  // 게시글 번호 설정
            boardPostsDTO.setTitle(title);
            boardPostsDTO.setContent(content);
            boardPostsDTO.setUsersStatusID(usersStatusDAO.getLoggedInUser().getUsersStatusID());
            
            int su = boardPostsDAO.boardPostsUpdate(boardPostsDTO);
            
            System.out.println();
            
            if (su > 0) {
                System.out.println("게시글 수정이 완료되었습니다.");
                System.out.println();
                System.out.println("[게시글]");
                boardPostsDAO.boardPostsPrintContentThis(num);            
                System.out.println();
            }
            
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력해주세요!");
            scanner.next();
            System.out.println();
        }
	}
}
