package usersstatus.service;

import java.util.Scanner;

import board.dao.UsersStatusDAO;
import board.service.Board;

public class UsersStatusLogin implements Board {
	@Override
    public void execute() {
		System.out.println();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("아이디: ");
        String userID = scanner.next();
        System.out.print("비밀번호: ");
        String password = scanner.next();

        UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
        String username = usersStatusDAO.usersStatusLogin(userID, password);

        if (username == null) {
        	System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
        	System.out.println();
        } else {
        	System.out.println("로그인 성공! " + username + "님 환영합니다.");
        	System.out.println();
        }
    }
}
