package board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class LoginService implements Board {

	@Override
    public void execute() {
		System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디: ");
        String id = scanner.next();
        System.out.print("비밀번호: ");
        String pwd = scanner.next();

        BoardDAO boardDAO = BoardDAO.getInstance();
        String name = boardDAO.login(id, pwd);

        if (name == null) {
        	System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
        } else {
        	System.out.println("로그인 성공! " + name + "님 환영합니다.");
        	
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

                if (num == 5) break;
                if(num == 1) {
                	 System.out.println();
                     System.out.println("[게시글 작성]");        
                     System.out.print("제목 : ");
                     String title = scanner.next();
                     scanner.nextLine();
                     System.out.print("내용 : ");
                     String content = scanner.nextLine();
                     
                     boardDAO.writePost(id, title, content);
                     System.out.println("게시글이 입력되었습니다.");
                }
                else if(num == 2) {
                	List<BoardDTO> posts = new ArrayList<>();
                	
                	System.out.println();
                    System.out.println("[작성 글보기]");
                    posts = boardDAO.viewPosts(id);
                    
                    for(BoardDTO boardDTO : posts) {
                    	System.out.println(boardDTO);
                    }
                }
                else if(num == 3) {
                	System.out.println();
                	System.out.print("수정할 게시글 번호: ");
                	int seq = scanner.nextInt();
                	
                	boardDAO.selectseq(seq);
                	//리스트
                	
                	System.out.print("수정할 제목 : ");
                	String title = scanner.next();
                	scanner.nextLine();
                	System.out.print("수정할 내용 : ");
                	String content = scanner.nextLine();

                    boardDAO.modifyPost(seq, title, content);
                    System.out.println("수정 되었습니다.");
                }
                else if(num == 4) {
                	System.out.println();
                    System.out.print("삭제할 게시글 번호: ");
                    int seq = scanner.nextInt();

                    boardDAO.deletePost(id, seq);
                    System.out.println("게시글이 삭제되었습니다.");
                }
                else {
                    System.out.println("1~5번 중에 선택하세요");
                    continue;
                }
            }//while
        }
    }
}
