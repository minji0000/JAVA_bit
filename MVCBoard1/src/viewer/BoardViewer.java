package viewer;
// 뷰어
// 뷰어는 사용자가 직접적으로 보게 되는 화면단, 즉 프론트엔드가 된다.
// 단, 지금 현재 우리는 console에서 프로그래밍을 하므로
// 뷰어가 java 클래스가 된다.

// 또한 원칙적으로 데이터베이스가 존재하기 때문에
// 우리가 필요하면 그 즉시 해당 메소드에서 Controller 객체를 생성해서
// 해당 객체의 필요한 메소드를 실행시키는 게 맞지만 없다.........
// 그래서 어쩔 수 없이, BoardController 필드를 하나 여기에 만들어주게 된다.

import controller.BoardController;
import model.BoardDTO;
import model.MemberDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoardViewer {
    private BoardController controller;
    private Scanner scanner;
    private UserViewer userViewer;
    private MemberDTO logIn;

    public BoardViewer(Scanner scanner) {
        controller = new BoardController();
        this.scanner = scanner; //BoardMain에 의존
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setLogIn(MemberDTO logIn) {
        this.logIn = logIn;
    }

    //게시글 관련 메뉴 메소드
    public void showMenu() {
        while(true) {
            String message = "1. 새 글 작성 2. 글 목록 보기 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1) {
                // 새 글 작성 메소드 호출
                writerBoard();
            } else if (userChoice == 2) {
                // 글 목록 출력 메소드 호출
                printList();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void printList() {
        ArrayList<BoardDTO> list = controller.sellectAll();
        //controller의 sellectAll을 실행시킨 값을 list에 저장한다.
        if(list.isEmpty()) {
            System.out.println("아직 등록된 글이 존재하지 않습니다.");
        } else {
            Collections.reverse(list);
            //정렬

            for(BoardDTO b : list) {
                System.out.printf("%d. %s\n", b.getId(), b.getTitle());
            }

            String message = "상세보기할 글의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

                                    // 이 부분 이해 안 돼 왜 SelectOne이랑 null이랑 비교해?
            while(userChoice != 0 && controller.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
            //0을 안 써도 코드가 끝나면 알아서 showMenu 로 가진다.
        }
    }

    // 글 번호(id)에 따른 글 상세보기
    private void printOne(int id) {
        BoardDTO b = controller.selectOne(id);
        BoardDTO b1 = new BoardDTO();

        System.out.println("\n=========================");
        System.out.println(b.getTitle());
        System.out.println("-------------------------");
        System.out.println("글번호 : " + id);
        userViewer.printNickname(b.getWriterId());
        System.out.println();
        System.out.println("-------------------------");
        System.out.println(b.getContent());
        System.out.println("=========================\n");

        String message;

        if(b.getWriterId() == logIn.getId()) {
            // 로그인된 아이디와 비교해서 본인글 일 때
            message = "1. 수정 2. 삭제 3. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                updateBoard(id);
            } else if (userChoice == 2) {
                deleteBoard(id);
            } else if (userChoice == 3) {
                printList();
            }

        } else {
            //본인글이 아닐 때
                message = "1. 뒤로가기";
                int userChoice = ScannerUtil.nextInt(scanner, message);
                printList();
        }
    }

    private void updateBoard(int id) {
        BoardDTO b = controller.selectOne(id);

        b.setTitle(ScannerUtil.nextLine(scanner, "새로운 제목을 입력해주세요."));
        b.setContent(ScannerUtil.nextLine(scanner, "새로운 내용을 입력해주세요."));

        controller.update(b);
        printOne(id);
    }

    private void deleteBoard(int id) {
        String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제 하시겠습니까? Y/N");

        if(yesNo.equalsIgnoreCase("Y")) {
            controller.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }

    private void writerBoard() {
        BoardDTO b = new BoardDTO();

        String message = "글의 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));
        b.setWriterId(logIn.getId());

        message = "글의 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner,message));

        controller.insert(b); //list에 저장하기
    }

    public void deleteByWriterId(int writerId) {
        controller.deleteByWriterId(writerId);
        // 구현 아직 안 됐지?
    }


}
