package board.main;

import board.service.BoardMain;

public class IndexMain {
    public static void main(String[] args) {
        BoardMain boardMain = new BoardMain();
        boardMain.menu();

        System.out.println("시스템을 종료합니다.");
    }
}
