package day0609;
//사용자로부터 나이를 입력 받아서
// 5세 이하: 영아
// 13세 이하: 어린이
// 18세 이하: 청소년
// 그 외: 성인이 출력되는 프로그램을 작성하시오.


import java.util.Scanner;

public class Ex05AgeChecker {

    public static void main(String[] args) {

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("나이를 입력하세요.");
        System.out.print(">");
        int age;
        age = scanner.nextInt();

        if( age > 0 && age <150 ) {
            if (age <= 5) {
                System.out.println("영아");
            } else if (age <= 13) {
                System.out.println("어린이");
            } else if (age <= 18) {
                System.out.println("청소년");
            } else {
                System.out.println("성인");
            }
        } else {
            System.out.println("다시 입력해");
        }

        scanner.close();
    }


}
