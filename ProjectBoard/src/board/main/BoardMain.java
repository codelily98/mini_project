package board.main;

import board.service.BoardService;

public class BoardMain {
	public static void main(String[] args) {
		BoardService boardService = new BoardService();
		boardService.menu();

        System.out.println("시스템을 종료합니다.");
    }
}
