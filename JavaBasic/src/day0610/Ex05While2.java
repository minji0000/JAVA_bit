package day0610;
// 사용자로부터 숫자를 입력 받으면 해당 숫자 * 3한 결과값을 화면에
// "사용자가 입력한 수: ##"
// "결과 : # * 3 = ## "가 출력되는 프로그램
// 단 사용자가 0을 입력하면 "사용해주셔서 감사합니다. " 가 출력되면서 프로그램이 종료된다.

import java.util.Scanner;

public class Ex05While2 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.(0은 종료)");
        System.out.println("> ");
        int number = scanner.nextInt();

        while (number != 0) {
            System.out.println("사용자가 입력한 수: " + number);
            System.out.printf("결과: %d X 3 = %d\n", number, number*3);

            System.out.println("숫자를 입력해주세요.(0은 종료)");
            System.out.println("> ");
            number = scanner.nextInt();
        }

        System.out.println("사용해주셔서 감사합니다.");
        scanner.close();
    }
}
