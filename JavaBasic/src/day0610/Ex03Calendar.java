package day0610;
// 사용자로부터 월을 입력 받아서 해당 월이 며칠까지 있는지 보여주는 프로그램

import java.util.Scanner;
public class Ex03Calendar {
    public static void main (String [] args ) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("월을 입력해주세요.");
        System.out.println("> ");
        int month = scanner.nextInt();

        switch (month) {
            case 2:
                System.out.println("28일까지입니다.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30일까지입니다.");

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31일까지입니다.");
                break;
        }

        scanner.close();
    }
}
