package day0616;
// 5명의 학생을 Student2 객체로 관리하는
// 프로그램을 작성하시되
// 메뉴 클릭, 학생 입력, 학생 출력은 여기서 스태틱 메소드로 분리하여 만드시오
// 단, 학생 출력의 경우, 목록보기, 개별 보기 등의 기능은 필요하지 않습니다.

// 동적 할당으로 게시판,

import java.util.Scanner;

public class GradeBook01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student2 s2 = new Student2();
        int id = 0;
        String name = "";

        while(true) {
            System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
            System.out.println("1. 학생 입력");
            System.out.println("2. 학생 출력");

            int userChoice = scanner.nextInt();

            if(userChoice == 1) {
                System.out.println("학생의 번호를 입력해주세요.");
                id = scanner.nextInt();
                s2.setId(id);

                System.out.println("학생의 이름을 입력해주세요.");
                name = scanner.next();
                s2.setName(name);

            } else if (userChoice == 2) {
                System.out.println("출력할 학생의 정보를 입력해주세요.");
                System.out.println("번호: " + s2.getId());
                System.out.println("이름: " + s2.getName());
            } else {
                System.out.println("다시 입력해주세요.");
            }







        }
















    } //메인 메소드
} //클래스
