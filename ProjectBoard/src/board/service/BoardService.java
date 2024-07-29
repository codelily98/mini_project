package board.service;

import java.util.Scanner;


public class BoardService implements Board{

    @Override
    public void excute() {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            int num;
            Board board = null;

            while (true) {
                System.out.println("----------관리----------");
                System.out.println("        1.게시글 작성");
                System.out.println("        2.작성 내용 보기");
                System.out.println("        3.게시글 수정");
                System.out.println("        4.게시글 삭제");
                System.out.println("        5.이전 메뉴");
                System.out.println("        6.서비스 종료");
                System.out.println("------------------------");
                System.out.print("번호 선택 : ");
                num = scanner.nextInt();

                if (num == 6) {
                    System.out.print("시스템을 종료합니다.");
                    System.exit(0);
                }
                else if(num == 1) board = new WriteService();
                else if(num == 2) board = new ViewService();
                else if(num == 3) board = new ModifyService();
                else if(num == 4) board = new DeleteService();
                else if(num == 5) break;
                else {
                    System.out.println("1~6번 중에 선택하세요");
                    continue;
                }
                board.excute();
            }//while
    }
}
