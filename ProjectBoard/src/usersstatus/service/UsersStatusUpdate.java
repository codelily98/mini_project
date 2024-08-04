package usersstatus.service;

import java.util.Scanner;

import board.bean.UsersStatusDTO;
import board.dao.UsersStatusDAO;
import board.service.Board;

public class UsersStatusUpdate implements Board {
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.print("수정할 아이디 : ");
			String UserID = scanner.next();
			System.out.print("비밀번호 입력 : ");
			String Password = scanner.next();
			UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
			UsersStatusDTO usersStatusDTO = usersStatusDAO.getMember(UserID);

			boolean existId = usersStatusDAO.isExistId(UserID);
			boolean existPwd = usersStatusDAO.isExistPwd(Password);
			
			if(!(existId&& existPwd)) {
				System.out.println("아이디나 비밀번호가 맞지 않습니다.");
				return;
			} else {
				System.out.print("수정할 비밀번호 입력 : ");
				String RePassword = scanner.next();
				System.out.print("수정할 이름 입력 : ");
				String UserName = scanner.next();

				usersStatusDTO.setPassword(RePassword);
				usersStatusDTO.setUsername(UserName);
				
				int su = usersStatusDAO.update(usersStatusDTO);
				
				if(su > 0) {
					System.out.println();
					System.out.println(su + "개의 행을 수정하였습니다.");
					System.out.println();
					break;
				}			
			}
		}		
	}
}
