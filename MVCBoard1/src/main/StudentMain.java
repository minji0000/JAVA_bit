package main;
// 메뉴
// 1. 학생 입력 (이름, 번호, 국어, 영어, 수학)
// 2. 학생 출력 (이름 or 번호)
// 3. 종료


import model.StudentDTO;
import viewer.StudentViewer;

public class StudentMain {
    public static void main(String[] args) {
        StudentViewer viewer = new StudentViewer();

        viewer.showMenu();
    }

}
