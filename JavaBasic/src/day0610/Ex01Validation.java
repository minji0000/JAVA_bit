package day0610;
//if문을 사용한 값 검증하기
//사용자로부터 시험점수를 입력받아서
// 90~: A
// 80~: B
// 70~: C
// 60~: D
// 그 외: F
// 를 출력해주는 프로그램.0

import java.util.Scanner;

public class Ex01Validation {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("점수를 입력해주세요.");
        System.out.println("> ");
        int score = scanner.nextInt();

        // 값 검증하는 첫 번째 방법.
        // 조건식을 뺵빽하게 잡기
        // = 특정 코드를 실행시킬 분기를 정확하게 어떤 경우인지를 조건식에 적어주기
        // 이 방법은 올바른 값, 혹은 특정 코드를 실행시킬 조건문의 조건식이 연속적이지 않을 때 주로 사용된다.

        if(score >= 0 && score <= 100 ) {
        } else if (score >= 90) {
            System.out.println("A");
        }  else if (score >= 80) {
            System.out.println("A");
        }  else if (score >= 70) {
            System.out.println("A");
        }  else if (score >= 60) {
            System.out.println("A");
        }
         else {
            System.out.println("잘못입력했어");
        }




        // 값 검증하는 두 번째 방법
        // 중첩 if문을 사용하여 올바른 값일 때에만 추가적인 코드를 실행시키는 방법.
        // 이 검증 방법은 올바른 값의 범위가 연속적일 때 주로 사용된다.


        if (score >= 0 && score <= 100) {
            if(score >= 90) {
                System.out.println("A");
            } else if(score >= 80) {
                System.out.println("B");
            } else if(score >= 70) {
                System.out.println("C");
            } else if(score >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F"); }
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }

        System.out.println("-----------------------------------------");

        scanner.close();











    }
}
