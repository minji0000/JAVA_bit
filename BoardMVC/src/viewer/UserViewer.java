package viewer;

import connector.DBConnerctor;
import connector.MysqlConnector;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class UserViewer {
    private Scanner scanner;
    private UserDTO logIn;
    private DBConnerctor connerctor;

    public UserViewer(Scanner scanner, DBConnerctor connerctor) {
        this.scanner = scanner;
        this.connerctor = new MysqlConnector();
    }

    public void ShowIndex() {
        String message = "1. 로그인 2. 회원가입 3. 종료";
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
                logIn();
                if(logIn != null) {
                    // 게시판 메뉴 이동
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

    private void logIn() {
        String message;

        message = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, message);
        message = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, message);

        UserController controller = new UserController(connerctor);

        logIn = controller.logIn(username, password);

        while(logIn == null) {
            System.out.println("잘못 입력하셨습니다.");
            username = ScannerUtil.nextLine(scanner, "아이디를 입력하시거나 뒤로 가시려면 'X'를 입력해주세요.");
            if(username.equalsIgnoreCase("x")) {
                break;
            }

            password = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요.");
            logIn = controller.logIn(username, password);
        }

    }


    private void register() {
        UserDTO u = new UserDTO();
        String message = "사용하실 아이디를 입력해주세요.";
        u.setUsername(ScannerUtil.nextLine(scanner,message));

        message = "사용하실 비밀번호를 입력해주세요.";
        u.setPassword(ScannerUtil.nextLine(scanner,message));

        message = "사용하실 닉네임 입력해주세요.";
        u.setNickname(ScannerUtil.nextLine(scanner,message));

        UserController controller = new UserController(connerctor);

        while(!controller.register(u)) {
            //중복된 아이디가 있다는 뜻
            System.out.println("잘못 입력하셨습니다");
            String yesNo = ScannerUtil.nextLine(scanner, "새로운 아이디를 입력하시겠습니까? Y/N");
            if(yesNo.equalsIgnoreCase("n")) {
                break;
            }
            u.setUsername(ScannerUtil.nextLine(scanner, "사용하실 아이디를 입력해주세요."));
            //어차피 비밀번호랑 닉네임은 아까 입력받았으므로 아이디만 다시 입력 받기
        }

    }

    private void showMenu() {
        String message = "1. 게시판 2. 회원정보 3. 로그아웃";
        while(logIn != null) {
            int userChoice = ScannerUtil.nextInt(scanner ,message);
            if(userChoice == 1) {
                BoardViewer boardViewer = new BoardViewer(scanner, connerctor, logIn);
                //set 무슨 뷰어 할 필요 없이 내가 필요하면 바로 보드뷰어 객체 만들어서 쓰기,,,
                boardViewer.showMenu();
            } else if(userChoice == 2) {
                printOne();
            } else if(userChoice == 3) {
                System.out.println("로그아웃되었습니다.");
                logIn = null;
            }
        }
    }

    private void printOne() {
        System.out.println("아이디: " + logIn.getUsername());
        System.out.println("닉네임: " + logIn.getNickname());
        int userChoice = ScannerUtil.nextInt(scanner, "1. 회원 정보 수정 2. 회원 탈퇴 3. 뒤로 가기");
        if(userChoice == 1) {
            update();
        } else if(userChoice == 2) {
            delete();
        } // 아무런 코드 안 써줘도 뒤로 가져

    }

    private void update() {
        String message = "새로운 비밀번호를 입력해주세요.";
        String newPassword =  ScannerUtil.nextLine(scanner,message);

        message = "새로운 닉네임을 입력해주세요.";
        String newNickname = ScannerUtil.nextLine(scanner,message);

        message = "기존 비밀번호를 입력해주세요.";
        String oldPassword = ScannerUtil.nextLine(scanner, message);

        UserController controller = new UserController(connerctor);
        if(controller.convertToSha(oldPassword).equals(logIn.getPassword())) {
            logIn.setPassword(newPassword);
            logIn.setNickname(newNickname);

            controller.update(logIn);
            // 다시 설정해준 로그인 객체를 업데이트 해주기

        }

    }

    private void delete() {
        String yesNo = ScannerUtil.nextLine(scanner, "정말로 탈퇴하시겠습니까? Y/N");
        if (yesNo.equalsIgnoreCase("y")) {
            String password = ScannerUtil.nextLine(scanner, "기존 비밀번호를 입력해주세요.");
            UserController controller = new UserController(connerctor);
            if(controller.convertToSha(password).equals(logIn.getPassword())) {
                controller.delete(logIn.getId());
                logIn = null;
            }
        }
    }























}
