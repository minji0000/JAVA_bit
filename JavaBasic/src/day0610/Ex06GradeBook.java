package day0610;
// 사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 차례대로 입력 받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오.
// 단, 만약 사용자가 잘못된 점수를 입력하면 올바른 점수가 입력될 때까지 다시 입력 받으시오.

//출력 양식:
//번호: #번 이름: #
//국어: 0##점 영어 0##점 수학: 0##점
//총점 0##점 평균: 0##.##점

import java.util.Scanner;

public class Ex06GradeBook {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;
        final int SUBJECT_SIZE = 3;

        //번호 입력
        System.out.println("번호를 입력하시오.");
        System.out.println("> ");
        int id = scanner.nextInt();

        //이름 입력
        System.out.println("이름을 입력하시오.");
        System.out.println("> ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("국어 점수를 입력하시오.");
        System.out.println("> ");
        int korean = scanner.nextInt();
        //국어 점수가 맞는지 체크하고 아니면 다시 입력
        while(!(korean >= SCORE_MIN && korean <= SCORE_MAX)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("국어 점수를 입력하시오.");
            System.out.println("> ");
            korean = scanner.nextInt();
        }

        System.out.println("영어 점수를 입력하시오.");
        System.out.println("> ");
        int english = scanner.nextInt();

        while(!(english >= SCORE_MIN && english <= SCORE_MAX)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("영어 점수를 입력하시오.");
            System.out.println("> ");
            english = scanner.nextInt();
        }

        System.out.println("수학 점수를 입력하시오.");
        System.out.println("> ");
        int math = scanner.nextInt();

        while(!(math >= SCORE_MIN && math <= SCORE_MAX)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("수학 점수를 입력하시오.");
            System.out.println("> ");
            math = scanner.nextInt();
        }

        // 결과 출력

        System.out.printf("번호: %d번 이름:%s\n", id, name);
        //총 세자리, 왼쪽 빈자리는 0으로 채워라
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n ",korean, english, math);

        int total = korean + english + math;
        double aver = total/(double)SUBJECT_SIZE;

        System.out.printf("총점: %03d점 평균: %06.2f점\n", total, aver);
        scanner.close();


    }
}
