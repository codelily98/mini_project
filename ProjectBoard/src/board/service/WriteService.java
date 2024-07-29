package board.service;

import java.util.Scanner;

public class WriteService implements Board{

    @Override
    public void excute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[게시글 작성]");
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();

        System.out.println("작성 되었습니다.");
        System.out.println("아이디: " + id);
        System.out.println("제목: " + title);
        System.out.println("내용: " + content);
//                    [게시판]
//        [게시글 작성]
//        아이디 :
//        제목 :
//        내용 :
//        작성 되었습니다.
//        [작성 목록]
//        번호   아이디     제목
//        1   person1    title
//        2   person2    title
    }
}
