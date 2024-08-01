package usersstatus.service;

import java.util.Scanner;

import board.bean.UsersStatusDTO;
import board.dao.UsersStatusDAO;
import board.service.Board;

public class UsersStatusWrite implements Board {
	@Override
    public void execute() {
		String userID = null;;
		String password;
		String username;
		
        Scanner scanner = new Scanner(System.in);
        
        UsersStatusDAO usersStatusDAO = UsersStatusDAO.getInstance();
        
        while(true) { //중복체크
			System.out.print("아이디 입력 : ");
			userID = scanner.next();
			
			//DB
			boolean exist = usersStatusDAO.isExistId(userID);
			
			if(exist) {
				System.out.println("사용중인 아이디 입니다");
			} else {
				System.out.println("사용가능한 아이디 입니다");
				break;
			} 
			
		} //while
        
        System.out.print("비밀번호: ");
        password = scanner.next();
        System.out.print("이름: ");
        username = scanner.next();
        
        UsersStatusDTO usersStatusDTO = new UsersStatusDTO();
        
        usersStatusDTO.setUserID(userID);
        usersStatusDTO.setPassword(password);
        usersStatusDTO.setUsername(username);
        
        int su = usersStatusDAO.usersStatusWrite(usersStatusDTO);
        
        System.out.println(su + "건의 회원가입이 완료되었습니다.");
    }
}