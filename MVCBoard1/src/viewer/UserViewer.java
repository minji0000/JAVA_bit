package viewer;

import controller.UserController;
import model.MemberDTO;

import java.util.Scanner;

public class UserViewer {
    private Scanner scanner;
    private UserController userController;
    private MemberDTO logIn;
    private BoardViewer boardViewer;

    public UserViewer(Scanner scanner)  {
        this.scanner = scanner;
        userController = new UserController();
    }

    public void setBoardViewer(BoardViewer boardViewer) {
        this.boardViewer = boardViewer;
    }

    public void showIndex() {
        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, "1. 로그인 2. 회원가입 3. 종료");

            if(userChoice == 1) {
                logIn();
                if(logIn != null) {
                    boardViewer.setLogIn(logIn);
                    showMenu();
                }
            } else if(userChoice == 2) {
                register();
            } else if(userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void showMenu() {
        while(logIn != null) {
            int userChoice =
                    ScannerUtil.nextInt(scanner, "1. 게시판 2. 회원 정보 상세보기 3. 로그아웃");
            if (userChoice == 1) {
                boardViewer.showMenu();
            } else if(userChoice == 2) {
                printOne();
            } else if(userChoice == 3) {
                System.out.println("로그아웃 되셨습니다.");
                logIn = null;
            }
        }
    }

    private void printOne() {
        System.out.println("회원 username: " + logIn.getUsername());
        System.out.println("회원 닉네임: " + logIn.getNickname());
        int userChoice = ScannerUtil.nextInt(scanner, "1. 정보수정 2. 회원탈퇴 3. 뒤로가기");

        if(userChoice == 1) {
            update();
        } else if(userChoice == 2) {
            delete();
        } else if (userChoice == 3) {

        }
    }

    private void delete() {
        String yesNo = ScannerUtil.nextLine(scanner, "정말로 탈퇴하시겠습니까? Y/N");
        if(yesNo.equalsIgnoreCase("Y")) {
            String oldPassword = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요.");
            if(oldPassword.equals(logIn.getPassword())) {
                userController.delete((logIn.getId()));
                boardViewer.deleteByWriterId(logIn.getId());
                logIn = null;
            }
        }

        if(logIn != null) {
            printOne();
        }
    }

    private void update() {
        String password = ScannerUtil.nextLine(scanner, "새로운 비밀번호를 입력해주세요.");
        String nickname = ScannerUtil.nextLine(scanner, "새로운 닉네임을 입력해주세요.");
        String oldPassword = ScannerUtil.nextLine(scanner, "기존 비밀번호를 입력해주세요.");

        if(logIn.getPassword().equals(oldPassword)) {
            logIn.setPassword((password));
            logIn.setNickname(nickname);
            userController.update(logIn);
        }
        printOne();
    }


    private void logIn() {
        String username = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요");
        while(userController.auth(username, password) == null) {
            System.out.println("잘못 입력하셨습니다.");
            String yesNo = ScannerUtil.nextLine(scanner, "로그인을 그만하시겠습니까?");
            if (yesNo.equalsIgnoreCase("Y")) {
                break;
            }
            username = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
            password = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요.");
        }
        logIn = userController.auth(username, password);
    }


    private void register() {
        String username = ScannerUtil.nextLine(scanner,
                "사용하실 아이디를 입력해주시거나 뒤로 가시려면 X를 입력해주세요.");

        while(username.equalsIgnoreCase("X") && userController.validateUsername(username)) {
            System.out.println("잘못 입력하셨습니다.");
            username = ScannerUtil.nextLine(scanner,
                    "사용하실 아이디를 입력해주시거나 뒤로 가시려면 X를 입력해주세요.");
        }
        if(!username.equalsIgnoreCase("X")) {
            String password = ScannerUtil.nextLine(scanner, "사용하실 비밀번호를 입력해주세요.");
            String nickname = ScannerUtil.nextLine(scanner, "사용하실 닉네임을 입력해주세요.");
            MemberDTO u = new MemberDTO();
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);

            userController.insert(u);
        }
    }

    public void printNickname(int id) {
        MemberDTO u = userController.selectOne(id);
        System.out.println(u.getNickname());
    }


}
















