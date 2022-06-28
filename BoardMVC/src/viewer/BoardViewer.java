package viewer;

import connector.DBConnerctor;
import controller.BoardController;
import controller.UserController;
import model.BoardDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    private Scanner scanner;
    private DBConnerctor connerctor;
    private UserDTO logIn;

    public BoardViewer(Scanner scanner, DBConnerctor connerctor, UserDTO logIn) {
        this.scanner = scanner;
        this.connerctor = connerctor;
        this.logIn = logIn;
    }

    public void showMenu() {
        String message = "1. 새 글 작성 2. 글 목록 보기 3. 뒤로가기";
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
                write();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }

        }

    }

    private void write() {
        BoardDTO b = new BoardDTO();
        b.setWriterId(logIn.getId());

        b.setTitle(ScannerUtil.nextLine(scanner, "제목을 입력해주세요."));
        b.setContent(ScannerUtil.nextLine(scanner, "내용을 입력해주세요."));

        BoardController controller = new BoardController(connerctor);
        controller.insert(b);

    }

    private void printList() {
        BoardController controller = new BoardController(connerctor);
        ArrayList<BoardDTO> list = controller.selectAll();

        if(list.isEmpty()) {
            System.out.println("아직 등록된 글이 없습니다.");
        } else {
            for(BoardDTO b : list) {
                System.out.printf("%d. %s\n", b.getId(), b.getTitle());
            }
        }
        String message = "상세보기할 글의 번호나 뒤로 가시려면 0을 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while(userChoice != 0 && controller.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner,message);

        }

        if(userChoice != 0 ){
            printOne(userChoice);
        }

    }

    private void printOne(int id) {
        BoardController boardController = new BoardController(connerctor);
        UserController userController = new UserController(connerctor);
        BoardDTO b = boardController.selectOne(id);

        System.out.println("제목: " + b.getTitle());
        System.out.println("글 번호: " + b.getId());
        System.out.println("글 작성자: " + userController.seleteOne(b.getWriterId()).getNickname());
        System.out.println(b.getContent()); // 글 내용

        ReplyViewer replyViewer = new ReplyViewer(scanner, connerctor, logIn);
        replyViewer.printList(id);

        if(logIn.getId() == b.getWriterId()) {
            int userChoice = ScannerUtil.nextInt(scanner, "1. 글 수정하기 2. 글 삭제하기 3. 댓글 달기 4. 뒤로가기");
            if(userChoice == 1) {
                update(id);
            } else if(userChoice == 2) {
                delete(id);
            } else if(userChoice == 3) {
               replyViewer.write(id);
               printOne(id);
            } else if(userChoice == 3) {
                printList();
            }
        } else {
            int userChoice = ScannerUtil.nextInt(scanner, "1. 댓글 달기 2. 뒤로가기");
            if(userChoice == 1) {
                replyViewer.write(id);
                printOne(id);
            } else if(userChoice == 2) {
                printList();
            }
        }
    }

    private void update(int id) {
        BoardController controller = new BoardController(connerctor);
        BoardDTO b = controller.selectOne(id);

        b.setTitle(ScannerUtil.nextLine(scanner, "새로운 제목을 입력해주세요."));
        b.setContent(ScannerUtil.nextLine(scanner, "새로운 내용을 입력해주세요."));

        controller.update(b);
        printOne(id);
    }

    public void delete(int id) {
        BoardController controller = new BoardController(connerctor);
        String yesNo = ScannerUtil.nextLine(scanner, "정말로 삭제하시겠습니까? Y/N");
        if(yesNo.equalsIgnoreCase("y")) {
            controller.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }

































}
