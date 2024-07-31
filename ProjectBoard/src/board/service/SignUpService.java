package board.service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

import java.util.Scanner;

public class SignUpService implements Board {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        BoardDTO boardDTO = new BoardDTO();
        BoardDAO boardDAO = BoardDAO.getInstance();
        
        System.out.println();
        System.out.print("아이디: ");
        boardDTO.setId(scanner.next());
        System.out.print("비밀번호: ");
        boardDTO.setPwd(scanner.next());
        System.out.print("이름: ");
        boardDTO.setName(scanner.next());
        
        boardDAO.signUp(boardDTO);
        System.out.println("회원가입이 완료되었습니다.");
    }
}