package board.contents;

import java.util.Scanner;

public class BoardContents_Write implements board {
	
		public void execute() {
			System.out.println();
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("아이디: ");
	        String id = scanner.next();
	        System.out.print("비밀번호: ");
	        String pwd = scanner.next();
	        
	        BoardDTO boradDTO = BoardDAO.getinstance();
	        String name = boardDAO.login(id, pwd); //number변수가 맞는지 다시 체크할 것

	        if(name == null) {
	        	System.out.println("아이디와 비밀번호를 확인하세요. ");
	        } else {
	        	System.out.println("로그인 성공 " + name + "님 반갑습니다." );
	        	
	        	int num;
	        	
	        	 while (true) {
	             	System.out.println();
	                 System.out.println("----------관리----------");
	                 System.out.println("        1.게시글 작성");
	                 System.out.println("        2.작성 글보기");
	                 System.out.println("        3.게시글 수정");
	                 System.out.println("        4.게시글 삭제");
	                 System.out.println("        5.이전 메뉴");
	                 System.out.println("------------------------");
	                 System.out.print("번호 선택 : ");
	                 num = scanner.nextInt();
	                 	
	                if(num == 5) break;
	                if(num == 1) {
	                	
	                }
	        }//while
		}

}
