package day0609;

import  java.util.Scanner;

public class Ex04Scanner {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in); //버퍼 메모리 참조, 안 쓰면 반드시 close 라는 메소드를 써야해
        System.out.println("정수를 하나 입력해주세요.");
        System.out.println("> ");
        int number = scanner.nextInt();

        System.out.println("사용자가 입력한 정수: " + number);

        System.out.println("실수를 입력해주세요.");
        System.out.println("> ");
        double d = scanner.nextDouble();

        System.out.println("사용자가 입력한 실수: " + d);

        System.out.println("이름을 입력해주세요.");
        System.out.println("> ");

        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println();
        System.out.printf("사용자의 이름: [%s]\n", name);

        scanner.close();










    }
}
