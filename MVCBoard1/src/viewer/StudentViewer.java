package viewer;

import controller.StudentController;
import model.StudentDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentViewer {
   private StudentController controller;
   private Scanner scanner = new Scanner(System.in);

   public StudentViewer() {
       controller = new StudentController();
   }


    public void showMenu() {
        while(true) {
            String message = "1. 학생 입력 2. 학생 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1 ) {
                insert();
            } else if(userChoice == 2) {
                printList();
            } else if(userChoice == 3 ) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }

        }
    }

    private void insert() {
        StudentDTO s = new StudentDTO();

        String message = "아이디를 입력해주세요.";
        s.setUsername(ScannerUtil.nextLine(scanner, message));

        if(controller.validateUsername(s.getUsername())) {
            System.out.println("중복된 아이디입니다.");
            s.setUsername(ScannerUtil.nextLine(scanner, message));
        } else {

            message = "학생 이름을 입력해주세요.";
            s.setName(ScannerUtil.nextLine(scanner, message));

            message = "국어 점수를 입력해주세요.";
            s.setKorean(ScannerUtil.nextInt(scanner, message));

            message = "영어 점수를 입력해주세요.";
            s.setEnglish(ScannerUtil.nextInt(scanner, message));

            message = "수학 점수를 입력해주세요.";
            s.setMath(ScannerUtil.nextInt(scanner, message));

            controller.insert(s);
        }
    }

    private void printList() {
        ArrayList<StudentDTO> list = controller.printAll();

        if(list.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            Collections.reverse(list);

            for(StudentDTO s : list) {
                System.out.printf("%d. %s\n ", s.getId(), s.getName());
            }

            String message = "점수 확인할 학생의 번호를 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while(userChoice != 0 && controller.printOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if(userChoice != 0) {
                printOne(userChoice);
            }
            //show메뉴로 안 가져 ㅜ랑ㅠㅜ
        }

    }

    private void printOne(int id) {
        StudentDTO s = controller.printOne(id);
        System.out.println("---------------------------");
        System.out.println("학생 번호: " + id);
        System.out.println("학생 이름: " + s.getName());
        System.out.println("아이디: " + s.getUsername());
        System.out.println("국어 점수: " + s.getKorean());
        System.out.println("영어 점수: " + s.getEnglish());
        System.out.println("수학 점수: " + s.getMath());
        System.out.println("---------------------------");

        String message;

        if(s.getId() == id) {
            message = "1. 수정 2. 삭제 3. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1) {
                update(id);
            } else if(userChoice == 2) {
                delete(id);
            } else if(userChoice == 3) {
                printList();
            }
        } else {
            message = "1. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            printList();
        }
    }

    private void update(int id) {
       StudentDTO s = controller.printOne(id);

       s.setKorean(ScannerUtil.nextInt(scanner, "새로운 국어 점수를 입력해주세요."));
       s.setEnglish(ScannerUtil.nextInt(scanner, "새로운 영어 점수를 입력해주세요."));
       s.setMath(ScannerUtil.nextInt(scanner, "새로운 수학 점수를 입력해주세요."));

       controller.update(s);
       printOne(id);
    }

    private void delete(int id) {
       String yesNo = ScannerUtil.nextLine(scanner,  "정말 삭제하시겠습니까? Y/N");

       if(yesNo.equalsIgnoreCase("y")) {
           controller.delete(id);
           printList();
       } else {
           printOne(id);
       }
    }


}
