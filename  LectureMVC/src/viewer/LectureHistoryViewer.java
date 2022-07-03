package viewer;

import connector.DBConnector;
import connector.MysqlConnector;
import controller.LectureController;
import controller.LectureHistoryController;
import controller.UserController;
import model.LectureDTO;
import model.LectureHistoryDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class LectureHistoryViewer {
    // 수강 신청, 신청한 강의 보기
    // 성적 등록, 성적 확인
    private Scanner scanner;
    private DBConnector connector;
    private UserDTO logIn;

    public LectureHistoryViewer(Scanner scanner, DBConnector connector) {
        this.scanner = scanner;
        this.connector = new MysqlConnector();
    }

    // 수강신청 메소드
    public void register(UserDTO logIn) {
        LectureViewer lectureViewer = new LectureViewer(scanner, connector);
        LectureHistoryDTO lh = new LectureHistoryDTO();

        // 등록된 강의를 모두 출력하는 메소드
        lectureViewer.printLecture();

        String message = "수강 신청할 강의의 번호를 선택해주세요.";
        lh.setLectureId(ScannerUtil.nextInt(scanner, message));
        lh.setStudentId(logIn.getId());

        LectureHistoryController lectureHistoryController = new LectureHistoryController(connector);
        lectureHistoryController.register(lh);
        System.out.println("수강신청이 완료되었습니다.");
    }


    // 학생 본인이 수강하는 강의만 보여주는 메소드
    // *********************************별 로
    public void printUserLecture(UserDTO logIn) {
        LectureHistoryController lectureHistoryController = new LectureHistoryController(connector);
        LectureController lectureController = new LectureController(connector);
        UserController userController = new UserController(connector);
        for(int lectureId : lectureHistoryController.selectLecture(logIn.getId())) {
            LectureDTO l = lectureController.selectOne(lectureId);
            System.out.printf(" %d. 강의명: %s \n [%s] \n 담당교수: %s \n",
                    l.getId(), l.getClassname(), l.getContent(), userController.selectOne(l.getProfessorId()).getName());
        }
    }

    // 수강하는 학생만 보여주는 메소드


    // 성적 등록 메소드
    public void insertGrade(UserDTO logIn) {
        LectureController lectureController = new LectureController(connector);
        LectureHistoryController lectureHistoryController = new LectureHistoryController(connector);
        UserController userController = new UserController(connector);
        UserDTO u = new UserDTO();


        // 우선 교수님별로 본인이 수업하는 강의 보여줌
        for (LectureDTO l : lectureController.selectProLecture(logIn.getId())) {
            System.out.printf(" %d. 강의명: %s \n", l.getId(), l.getClassname());
        }

        String message = "성적을 등록할 강의를 선택해주세요.";
        int id = ScannerUtil.nextInt(scanner, message);

        lectureHistoryController.selectStudent(id);

        for (int studentId : lectureHistoryController.selectStudent(id)) {
            u = userController.selectOne(studentId);
            System.out.printf(" %d. 수강중인 학생: %s \n", u.getId(), u.getName() );
        }

        for(int i = 0; i< lectureHistoryController.selectStudent(id).size(); i++) {
            message = "점수를 입력할 학생의 번호를 입력해주세요.";
            int stu = ScannerUtil.nextInt(scanner, message);

            message = "학생의 점수를 입력해주세요.";
            String grade = ScannerUtil.nextLine(scanner, message);

            lectureHistoryController.insertGrade(stu, grade, id);
        }

    }



















}
