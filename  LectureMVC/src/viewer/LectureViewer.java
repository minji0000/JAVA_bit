package viewer;
//강의 등록/수정/삭제 시 사용

import connector.DBConnector;
import connector.MysqlConnector;
import controller.LectureController;
import controller.UserController;
import model.LectureDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class LectureViewer {
    private Scanner scanner;
    private DBConnector connector;

    public LectureViewer(Scanner scanner, DBConnector connector) {
        this.scanner = scanner;
        this.connector = new MysqlConnector();
    }

    public void showMenu() {
        printLecture();
        //일단 강의리스트를 보여주고
        String message = "0. 뒤로 가기 1. 강의 등록 2. 강의 수정 3. 강의 삭제";
        int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
                register();
            } else if(userChoice == 2) {
                update();
            } else if(userChoice == 3) {
                delete();
            }
    }

    // 강의 등록
    public void register() {
        UserViewer userViewer = new UserViewer(scanner, connector);

        LectureDTO l = new LectureDTO();

        String message = "등록할 강의의 이름을 입력해주세요.";
        l.setClassname(ScannerUtil.nextLine(scanner, message));

        message = "강의의 내용을 입력해주세요.";
        l.setContent(ScannerUtil.nextLine(scanner, message));

        //level2인 교수만 보여주는 메소드
        userViewer.printPro();

        message = "담당 교수의 아이디를 입력해주세요.";
        l.setProfessorId(ScannerUtil.nextInt(scanner, message));

        LectureController lectureController = new LectureController(connector);
        lectureController.register(l);
        printLecture();
        showMenu();
    }

    // 강의 수정
    private void update() {
        LectureController lectureController = new LectureController(connector);

        String message = "수정할 강의의 아이디를 선택해주세요.";
        int id = ScannerUtil.nextInt(scanner, message);

        UserViewer userViewer = new UserViewer(scanner, connector);
        message = "새로운 강의명을 입력해주세요.";
        String newName = ScannerUtil.nextLine(scanner, message);

        message = "새로운 강의 내용을 입력해주세요.";
        String newContent = ScannerUtil.nextLine(scanner, message);

        userViewer.printPro();

        message = "새로운 교수님을 지정해주세요.";
        int newPro = ScannerUtil.nextInt(scanner, message);

        LectureDTO l = new LectureDTO();

        l.setId(id);
        l.setClassname(newName);
        l.setContent(newContent);
        l.setProfessorId(newPro);
        lectureController.update(l);

        // 수정된 강의 출력해주는 메소드 추가하기
    }

    // 등록된 강의 삭제 메소드
    private void delete() {
        LectureController lectureController = new LectureController(connector);

        String message = "삭제할 강의의 아이디를 입력해주세요.";
        int id = ScannerUtil.nextInt(scanner, message);
        lectureController.delete(id);
        System.out.println("삭제되었습니다.");
        // 잘 삭제가 되었는지 강의 전체 목록 보여주기
        printLecture();
        showMenu();
    }

    // 등록된 강의 모두 보여주는 메소드
    // 수강 신청할 때 쓰일 메소드
    public void printLecture() {
        LectureController lectureController = new LectureController(connector);
        UserController userController = new UserController(connector);

        ArrayList<LectureDTO> list = lectureController.selectAll();
        System.out.println(" [강의 목록]");

        if(list.isEmpty()) {
            System.out.println("현재 수강 신청 기간이 아닙니다.");
        } else {
            for(LectureDTO l : list) {
                System.out.printf(" %d. 강의명: %s \n [%s] \n 담당교수: %s \n", l.getId(), l.getClassname(), l.getContent(), userController.selectOne(l.getProfessorId()).getName());
                System.out.println("----------------------------------------");
            }
        }
    }

}
