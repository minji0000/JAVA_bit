package day0610;
// 학생의 정보를 입력받고 출력하는 프로그램을 작성하시오.
// 해당 프로그램은 다음과 같은 기능이 있습니다.
// 입력: 학생의 정보를 입력받는다.
// 출력: 가장 마지막으로 입력된 학생의 정보를 출력한다.
// 종료: 사용자가 종료를 선택하면 프로그램이 종료되지만 그 외에는 실행시킬 기능을 입력받아 해당 기능을 실행한다.

// 심화: 만약 아무런 입력없이 출력을 선택할 경우
// "아직 정보가 입력된 학생이 존재하지 않습니다."가 출력되게 코드를 작성해보시오.

import java.util.Scanner;

public class Ex09GradeBook02 {
    public static void main(String[] args) {
        int id =0;
        int korean =0;
        int math = 0;
        int english=0;
        String name="";
        int total = 0;
        double aver =0;

        // 사용자가 값을 입력하면 true가 저장되는 boolean 변수
        boolean inputSwitch = false;


        Scanner scanner = new Scanner(System.in);

        System.out.println("사용하실 기능의 번호를 입력해주세요.");
        System.out.println("1. 입력");
        System.out.println("2. 출력");
        System.out.println("3. 종료");
        int number = scanner.nextInt();

        while (number != 3) {

            if (number == 1) {
                final int SCORE_MIN = 0;
                final int SCORE_MAX = 100;
                final int SUBJECT_SIZE = 3;

                System.out.println("번호를 입력하시오.");
                System.out.println("> ");
                id = scanner.nextInt();

                //이름 입력
                System.out.println("이름을 입력하시오.");
                System.out.println("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                System.out.println("국어 점수를 입력하시오.");
                System.out.println("> ");
                korean = scanner.nextInt();
                //국어 점수가 맞는지 체크하고 아니면 다시 입력
                while (!(korean >= SCORE_MIN && korean <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("국어 점수를 입력하시오.");
                    System.out.println("> ");
                    korean = scanner.nextInt();
                }

                System.out.println("영어 점수를 입력하시오.");
                System.out.println("> ");
                english = scanner.nextInt();

                while (!(english >= SCORE_MIN && english <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("영어 점수를 입력하시오.");
                    System.out.println("> ");
                    english = scanner.nextInt();
                }

                System.out.println("수학 점수를 입력하시오.");
                System.out.println("> ");
                math = scanner.nextInt();

                while (!(math >= SCORE_MIN && math <= SCORE_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("수학 점수를 입력하시오.");
                    System.out.println("> ");
                    math = scanner.nextInt();
                    break;
                }
                inputSwitch = true;

            } else if(number == 2) {

                //학생 정보 출력 코드 구현
                if(inputSwitch) {

                    System.out.printf("번호: %d번 이름:%s\n", id, name);
                    //총 세자리, 왼쪽 빈자리는 0으로 채워라
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n ", korean, english, math);

                    total = korean + english + math;
                    aver = total/3.0;

                    System.out.printf("총점: %03d점 평균: %06.2f점\n", total, aver);

                }

            }

        } System.out.println("종료되었습니다."); //while문
    } //메인
} //클래스