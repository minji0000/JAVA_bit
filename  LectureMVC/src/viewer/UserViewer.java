package viewer;
// 여기서 학생, 교수, 직원용 화면을 나눠서 보여줌.

import connector.DBConnector;
import connector.MysqlConnector;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

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
         } else if(userChoice == 0) {
            System.out.println("사용해주셔서 감사합니다 :) ");
            break;
         }
      }
   }

   private void showMenu() {
      String message = "";
      while(true) {
         if(logIn.getLevel() == 1) {
            message = "0. 뒤로가기 1. 비밀번호 변경 2. 학생 정보 3. 수강신청 4. 강의 정보 5. 성적 확인";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 0) {
               break;
            } else if(userChoice == 1) {
               update();
            }

         } else if(logIn.getLevel() == 2) {
            message = "0. 뒤로가기 1. 비밀번호 변경 2. 교수 정보";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 0) {
               break;
            } else if(userChoice == 1) {
               update();
            } else if(userChoice == 2) {

            }

         } else if(logIn.getLevel() == 3) {
            message = "0. 뒤로가기 1. 강의관리";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 0) {
               break;
            } else if(userChoice == 1) {

            }
         }
      }
   }

   private void logIn() {
      String message;
      message = "아이디를 입력해주세요.";
      int id = ScannerUtil.nextInt(scanner, message);
      message = "비밀번호를 입력해주세요.";
      String password = ScannerUtil.nextLine(scanner, message);

      UserController userController = new UserController(connector);

      logIn = userController.logIn(id, password);

      while(logIn == null) {
         System.out.println("잘못 입력하셨습니다.");
         id = ScannerUtil.nextInt(scanner, "아이디를 입력하시거나 뒤로 가시려면 0을 입력해주세요");
         if(id == 0) {
            break;
         }

         password = ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요.");
         logIn = userController.logIn(id, password);
      }

   }

   // 비밀번호 변경하는 메소드
   private void update() {
      String message = "새로운 비밀번호를 입력해주세요.";
      String newPassword = ScannerUtil.nextLine(scanner, message);

      message = "기존 비밀번호를 입력해주세요.";
      String oldPassword = ScannerUtil.nextLine(scanner, message);

      UserController userController = new UserController(connector);


   }


}
