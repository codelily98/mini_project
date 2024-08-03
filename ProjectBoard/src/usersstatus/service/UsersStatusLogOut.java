package usersstatus.service;

import board.dao.UsersStatusDAO;
import board.service.Board;

public class UsersStatusLogOut implements Board {
	
	@Override
	public void execute() {
		UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
		
		if(usersStatusDAO.getLoggedInUser() == null) {
			System.out.println("로그인된 사용자가 없습니다.");
			System.out.println();
			return;
		}
		
		int usersStatusID = usersStatusDAO.getLoggedInUser().getUsersStatusID();
		
		int result = usersStatusDAO.usersStatusLogOut(usersStatusID);
		
		if(result > 0) {
			System.out.println("로그아웃 되었습니다.");
			usersStatusDAO.setloggedInUser(null);
			System.out.println();
		} else {
			System.out.println("로그아웃 실패");
			System.out.println();
		}
	}

}
