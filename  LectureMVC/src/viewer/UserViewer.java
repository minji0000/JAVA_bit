package viewer;
// 여기서 학생, 교수, 직원용 화면을 나눠서 보여줌.

import connector.DBConnector;
import connector.MysqlConnector;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class UserViewer {
   private Scanner scanner;
   private DBConnector connector;
   private UserDTO logIn;


   public UserViewer(Scanner scanner, DBConnector connector) {
      this.scanner = scanner;
      this.connector = new MysqlConnector();
   }

   public void showIndex() {
      String message = "0. 종료 1. 로그인 2. 회원가입";
      while(true) {
         int userChoice = ScannerUtil.nextInt(scanner, message);
         if(userChoice == 1) {
            logIn();
            if(logIn != null) {
               showMenu();
            }
         } else if(userChoice == 2) {
            register();

         }  else if(userChoice == 0) {
            System.out.println("사용해주셔서 감사합니다 :) ");
            break;
         }
      }
   }

   // 2.  회원가입
   private void register() {
      UserDTO u = new UserDTO();
      String message = "이름을 입력해주세요.";
      u.setName(ScannerUtil.nextLine(scanner, message));

      message = "사용하실 아이디를 입력해주세요. 학생의 경우 학번을 입력해주세요.";
      u.setUsername(ScannerUtil.nextLine(scanner, message));

      message = "사용하실 비밀번호를 입력해주세요.";
      u.setPassword(ScannerUtil.nextLine(scanner, message));

      UserController userController = new UserController(connector);

      while(!userController.register(u)) {
         System.out.println("잘못 입력하셨습니다.");
         String yesNo = ScannerUtil.nextLine(scanner, "새로운 아이디를 입력하시겠습니까? Y/N");
         if(yesNo.equalsIgnoreCase("n")) {
            break;
         }
         u.setUsername(ScannerUtil.nextLine(scanner, "사용하실 아이디를 입력해주세요. 학생의 경우 학번을 입력해주세요."));
      }

   }

   public void showMenu() {
      String message = "";
      while(logIn != null) {
         if(logIn.getLevel() == 1) {
            // 학생 메뉴
            message = "1. 학생 정보 2. 로그아웃 3. 수강신청 4. 강의 정보 5. 성적 확인";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
               printOne();
            } else if(userChoice == 2) {
               System.out.println("로그아웃 되었습니다.");
               logIn = null;
            } else if(userChoice == 3) {
               LectureHistoryViewer lectureHistoryViewer = new LectureHistoryViewer(scanner, connector);
               lectureHistoryViewer.register(logIn);
            } else if(userChoice == 4) {
               LectureHistoryViewer lectureHistoryViewer = new LectureHistoryViewer(scanner, connector);
               lectureHistoryViewer.printUserLecture(logIn);
            } else if(userChoice == 5) {
               //성적확인 뷰어 연결
            }

         } else if(logIn.getLevel() == 2) {
            // 교수님 메뉴
            message = " 1. 교수님 정보 2. 로그아웃 3. 성적 입력";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
               printOne();
            } else if(userChoice == 2) {
               System.out.println("로그아웃 되었습니다.");
               logIn = null;
            } else if(userChoice == 3) {
               LectureHistoryViewer lectureHistoryViewer = new LectureHistoryViewer(scanner, connector);
               lectureHistoryViewer.insertGrade(logIn);
            }

         } else if(logIn.getLevel() == 3) {
            // 직원 메뉴
            message = "1. 로그아웃 2. 회원 관리 3. 강의 관리";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
               System.out.println("로그아웃 되었습니다.");
               logIn = null;
            } else if(userChoice == 2) {
               levelSet();
            } else if(userChoice == 3) {
               LectureViewer lectureViewer = new LectureViewer(scanner, connector);
               lectureViewer.showMenu();

            }
         }
      }
   }

   // 학생/교수 정보 출력
   private void printOne() {
      System.out.println("[인적사항]");
      System.out.println("이름: " + logIn.getName());
      System.out.println("아이디: " + logIn.getUsername());
      int userChoice = ScannerUtil.nextInt(scanner, "0. 뒤로 가기 1. 회원 정보 수정 2. 회원 탈퇴 ");

      if(userChoice == 1) {
         update();
      } else if(userChoice == 2) {
         delete();
      } // 아무런 코드 안 써도 뒤로 가짐

   }

   // 1. 로그인
   private void logIn() {
      String message;
      message = "아이디를 입력해주세요.";
      String username = ScannerUtil.nextLine(scanner, message);
      message = "비밀번호를 입력해주세요.";
      String password = ScannerUtil.nextLine(scanner, message);

      UserController userController = new UserController(connector);

      logIn = userController.logIn(username, password);

      while(logIn == null) {
         System.out.println("잘못 입력하셨습니다.");
         username = ScannerUtil.nextLine(scanner, "아이디를 입력하시거나 뒤로 가시려면 X를 입력해주세요");
         if(username.equalsIgnoreCase("x")) {
            break;
         }

         password = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요.");
         logIn = userController.logIn(username, password);
      }

   }


   // 비밀번호 변경하는 메소드
   private void update() {
      String message = "새로운 비밀번호를 입력해주세요.";
      String newPassword = ScannerUtil.nextLine(scanner, message);

      message = "기존 비밀번호를 입력해주세요.";
      String oldPassword = ScannerUtil.nextLine(scanner, message);

      UserController userController = new UserController(connector);

      if(userController.convertToSha(oldPassword).equals(logIn.getPassword())) {
         logIn.setPassword(newPassword);

         userController.update(logIn);
      }

   }

   // 회원탈퇴
   private void delete() {
      String yesNo =  ScannerUtil.nextLine(scanner, "정말로 탈퇴하시겠습니까? Y/N");
      if(yesNo.equalsIgnoreCase("y")) {
         String password = ScannerUtil.nextLine(scanner, "기존 비밀번호를 입력해주세요.");
         UserController userController = new UserController(connector);
         if(userController.convertToSha(password).equals(logIn.getPassword())) {
            userController.delete(logIn.getId());
            logIn = null;
            // 탈퇴가 됐으므로 로그인 정보 null로 초기화
         }
      }
   }

   // 직원의 회원 등급 조정 메소드
   private void levelSet() {
      UserController userController = new UserController(connector);

      printUser();

      String message = "등급을 변경할 회원의 아이디를 입력해주세요.";
      int id = ScannerUtil.nextInt(scanner, message);

      message = "변경할 등급을 입력해주세요.";
      int newLevel = ScannerUtil.nextInt(scanner, message);

      UserDTO u = new UserDTO();

      u.setId(id);
      u.setLevel(newLevel);
      userController.levelSet(u);
      printUser();

   }

   // 등록된 회원 모두 출력
   private void printUser() {
      UserController userController = new UserController(connector);
      ArrayList<UserDTO> list = userController.selectAll();
      System.out.println("[등록된 회원 정보]");

      if(list.isEmpty()) {
         System.out.println("등록된 회원이 없습니다.");
      } else {
         for(UserDTO u : list) {
            System.out.printf("id: %d 이름: %s 학번: %s 등급: %d \n " , u.getId(), u.getName(), u.getUsername(), u.getLevel());
         }
      }
   }

   public void printPro() {
      UserController userController = new UserController(connector);
      ArrayList<UserDTO> list = userController.selectPro();

      if(list.isEmpty()) {
         System.out.println("아직 등록된 교수님이 없습니다.");
      } else {
         for(UserDTO u : list) {
            System.out.println("[교수님 명단]");
            System.out.printf("id: %d 이름: %s 학번: %s \n " , u.getId(), u.getName(), u.getUsername());
         }
      }

   }



}
