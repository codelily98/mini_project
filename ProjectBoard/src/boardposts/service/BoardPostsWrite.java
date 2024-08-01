package boardposts.service;

import java.util.Scanner;

import board.bean.BoardPostsDTO;
import board.service.Board;


public class BoardPostsWrite implements Board {

	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		
		String title;
		String content;
		
		System.out.print("제목 : ");
		title = scanner.next();
		scanner.nextLine();
		System.out.print("내용 : ");
		content = scanner.nextLine();
		
		BoardPostsDTO boardPostsDTO = new BoardPostsDTO();
		

	}

}
