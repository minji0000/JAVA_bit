package viewer;

import controller.MovieUserController;
import model.MovieUserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class MovieUserViewer {
    private Scanner scanner;
    private MovieUserDTO mu;
    private MovieUserController movieUserController;
    private MovieUserDTO logIn;
    private boolean managerLogin;

    private MovieViewer movieViewer;
    private CinemaViewer cinemaViewer;


    // 생성자
    public MovieUserViewer(Scanner scanner) {
        movieUserController = new MovieUserController();
        this.scanner = scanner;
        // 초기화 해주기
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }
    public void setCinemaViewer(CinemaViewer cinemaViewer) {
        this.cinemaViewer = cinemaViewer;
    }



    // 초기 메뉴
    public void showLogin() {

        while(true) {
            String message = "1. 로그인 2.회원가입 3.종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1) {
                String nickname = login();
                if(logIn != null) {
                    System.out.printf("[%s]회원님 반갑습니다.", nickname);
                     showMenu();
                } else if(managerLogin) {
                    System.out.println("관리자 로그인");
                    manageMenu();
                }
            } else if(userChoice == 2) {
                register();

            } else if(userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 회원가입
    private void register() {
        MovieUserDTO mu = new MovieUserDTO();
        String message = "아이디를 입력해주세요.";
        mu.setUsername(ScannerUtil.nextLine(scanner, message));
        //중복검사
        while(movieUserController.validateUsername(mu.getUsername())) {
            System.out.println("중복된 아이디입니다.");
            mu.setUsername(ScannerUtil.nextLine(scanner, message));
        }
        message = "비밀번호를 입력해주세요.";
        mu.setPassword(ScannerUtil.nextLine(scanner, message));
        message = "닉네임을 입력해주세요.";
        mu.setNickname(ScannerUtil.nextLine(scanner, message));

        movieUserController.insert(mu);

    }

    // 로그인
    private String login() {
        String username = ScannerUtil.nextLine(scanner,"아이디를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner,"비밀번호를 입력해주세요.");


        if(movieUserController.managerLogin(username,password)) {
            System.out.println("관리자입니다.");
            manageMenu();
        } else {
            while (movieUserController.auth(username, password) == null) {
                System.out.println("잘못 입력하셨습니다.");
                String yesNo = ScannerUtil.nextLine(scanner, "로그인을 그만하시겠습니까? Y/N");
                if (yesNo.equalsIgnoreCase("Y")) {
                    break;
                }
                username = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
                password = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요.");
            }
        }
        logIn = movieUserController.auth(username, password);
        managerLogin = movieUserController.managerLogin(username,password);

        String nickname = movieUserController.getum(username);

        return nickname;
    }



    // 관리자 메뉴
    private void manageMenu() {
        while(true) {
            int managerChoice = ScannerUtil.nextInt(scanner, "1. 영화관리 2. 극장관리 3. 상영관리 4. 회원관리 10. 로그아웃");
            if (managerChoice == 1) {
                System.out.println("영화관리");
               movieViewer.movieManage();
            } else if (managerChoice == 2) {
                System.out.println("극장관리관리");

            } else {
                System.out.println("잘못 입력하셨습니다.");
                break;
            }
        }
    }

    // 일반메뉴
    public void showMenu() {
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, "1. 영화 2. 극장 3. 상영정보 10.로그아웃");

            if(userChoice == 1) {
                movieViewer.movieMenu();
            } else if(userChoice == 2) {
                cinemaViewer.cinemaMenu();
            } else if(userChoice == 3) {

            } else if(userChoice == 10) {
                break;
            }


        }

    }



}
