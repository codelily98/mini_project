package usersstatus.service;

import java.util.Scanner;

import board.dao.UsersStatusDAO;
import board.service.Board;

public class UsersStatusDelete implements Board {
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.print("삭제할 아이디 : ");
			String userID = scanner.next();
			System.out.print("비밀번호 입력 : ");
			String password = scanner.next();
			UsersStatusDAO usersStatusDAO = new UsersStatusDAO();

			boolean existId = usersStatusDAO.isExistId(userID);
			boolean existPwd = usersStatusDAO.isExistPwd(password);

			if(!(existId && existPwd)) {
				System.out.println("아이디나 비밀번호가 맞지 않습니다.");
				System.out.println();
				return;
			}
			
			int su = usersStatusDAO.usersStatusDelete(userID);
			System.out.println(su+"개의 행이 삭제되었습니다.");
			System.out.println();
			break;
		}		
	}
}
