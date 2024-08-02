package board.contents;

import java.util.Scanner;

public class BoardContents {

    BoardContents_Method bcm = new BoardContents_Method();
    LoginMain2 main = new LoginMain2();
    ConnectingUser conUser = new ConnectingUser();
    Scanner scan = new Scanner(System.in);

    // 게시글 작성 메소드
    public void postwrite() {
        System.out.println("제목을 입력하세요: ");
        String title = scan.nextLine(); // 제목 입력
        System.out.println("내용을 입력하세요: ");
        String content = scan.nextLine(); // 내용 입력
        String time = bcm.thisTime();
        String id = conUser.selectLoginUserId(); // 사용자의 id를 받아옴
        bcm.write(title, content, time, id);
    }

    // 게시글 목록을 출력하고 수정하는 메소드
    public void postUpdate() {
        bcm.select();
        try {
            System.out.println("수정할 게시글의 제목을 입력하세요:");
            String otitle = scan.nextLine(); // 수정할 게시글의 제목 입력
            String uid = bcm.writerId(otitle); // 게시글의 작성자 id 가져옴
            String id = conUser.selectLoginUserId(); // 접속중인 사용자의 id가져옴
            if (uid.equals(id)) { // 작성자와 접속자가 같은 경우 수행
                System.out.println("새로운 제목을 입력하세요:");
                String utitle = scan.nextLine(); // 수정할 제목 입력
                System.out.println("새로운 내용을 입력하세요:");
                String ucontent = scan.nextLine(); // 수정할 내용 입력
                bcm.update(utitle, ucontent, id); // 매개변수로 주면서 변경
            } else { // 작성자와 접속자가 다르면 수정 불가
                System.out.println(id + "님이 작성하신 글이 아닙니다.");
            }
        } catch (NullPointerException e) {
            System.out.println("해당 작성자가 없습니다.");
        }
    }

    // 게시글을 삭제하는 메소드
    public void postDelete() {
        bcm.select();
        System.out.println("삭제할 게시글의 제목을 입력하세요:");
        String dtitle = scan.nextLine(); // 삭제할 게시물 제목
        String did = bcm.writerId(dtitle); // 삭제할 게시글의 작성자
        String id = conUser.selectLoginUserId(); // 유저의 id
        String pw = conUser.selectLoginUserPw(); // 유저의 pw

        if (id.equals(did)) { // 작성자 id와 유저 id가 같으면 실행
            System.out.println("본인 확인을 위한 비밀번호를 입력하세요:");
            String dpw = scan.nextLine();
            if (pw.equals(dpw)) { // 작성자 id가 유저 id이므로 유저의 비밀번호와 입력된 비밀번호가 같은지 비교
                bcm.delete(did, dtitle);
            } else {
                System.out.println("비밀번호가 올바르지 않습니다.");
            }
        } else {
            System.out.println(id + "님이 작성하신 글이 아닙니다.");
        }
    }
}
