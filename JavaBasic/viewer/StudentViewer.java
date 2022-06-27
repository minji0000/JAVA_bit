package viewer;

import connector.DBConnector;
import controller.StudentController;
import model.StudentDTO;
import util.ScannerUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentViewer {
    private Scanner scanner;
    private DBConnector connector;

    public StudentViewer(Scanner scanner, DBConnector connector) {
        this.scanner = scanner;
        this.connector = connector;
    }

    public void ShowMenu() {
        String massage = "1. 입력 2. 목록출력 3. 종료";
        while(true) {
            int userChoice = ScannerUtil.nextInt(scanner, massage);
            if(userChoice == 1) {
                insertStudent();
            } else if(userChoice == 2) {
                printList();
            } else if(userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void printList() {
        StudentController controller = new StudentController(connector);
        ArrayList<StudentDTO> list = controller.selectALL();
        //DB 있는데 왜 리스트를 또 만들어줘 ..? ?? ? ?? ?

        if(list.isEmpty()) {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            for (StudentDTO s : list) {
                System.out.printf("%d. %s\n", s.getId(), s.getName());
            }
            String message = "상세보기할 학생의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && controller.selectOne(userChoice) == null) {
                System.out.println("잘못입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    public void printOne(int id) {
        StudentController controller = new StudentController(connector);
        StudentDTO s = controller.selectOne(id);

        int sum = s.getKorean() + s.getEnglish() + s.getMath();
        double average = (double) sum/3;

        System.out.printf("번호: %d번 이름: %s\n", s.getId(), s.getName());
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n",
                s.getKorean(), s.getEnglish(), s.getMath());
        System.out.printf("총점:  %03d점 평균  %06.2f점\n", sum, average);

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner,message);

        if(userChoice == 1) {
            updateStudent(id);
        } else if(userChoice == 2) {
            deleteStudent(id);
        } else if(userChoice == 3 ) {
            printList();
        }
    }

    private void updateStudent(int id) {
        StudentController controller = new StudentController(connector);
        StudentDTO s = controller.selectOne(id);

        String message = "새로운 국어 점수를 입력해주세요.";
        s.setKorean(ScannerUtil.nextInt(scanner, message, 0, 100));

        message = "새로운 영어 점수를 입력해주세요.";
        s.setEnglish(ScannerUtil.nextInt(scanner, message, 0, 100));

        message = "새로운 수학 점수를 입력해주세요.";
        s.setMath(ScannerUtil.nextInt(scanner, message, 0, 100));

        controller.update(s);
        printOne(id);
    }

    private void deleteStudent(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if(yesNo.equalsIgnoreCase("y")) {
            StudentController controller = new StudentController(connector);
            controller.delete(id);
            printList();

        } else {
            printOne(id);
        }
    }

    private void insertStudent() {
        StudentDTO s = new StudentDTO();

        String message;

        message = "학생의 이름을 입력해주세요.";
        s.setName(ScannerUtil.nextLine(scanner,message));

        message = "학생의 국어 점수를 입력해주세요.";
        s.setKorean(ScannerUtil.nextInt(scanner,message, 0, 100));

        message = "학생의 영어 점수를 입력해주세요.";
        s.setEnglish(ScannerUtil.nextInt(scanner,message, 0, 100));

        message = "학생의 수학 점수를 입력해주세요.";
        s.setMath(ScannerUtil.nextInt(scanner,message, 0, 100));

        StudentController controller = new StudentController(connector);
        controller.insert(s);

    }
}
