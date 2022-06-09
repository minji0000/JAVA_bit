package day0609;

import java.util.Scanner;

public class Ex06NextedIf {
    public static void main(String[] args) {

        Scanner scanner;
        scanner = new Scanner(System.in);
        int man;
        int age;
        int grade;

        System.out.println("남자면 0, 여자면 1을 입력해주세요.");
        man = scanner.nextInt();

        if (man == 0) {
            System.out.println("나이를 입력해주세요.");
            age = scanner.nextInt();
            if(age >= 19) {
                System.out.println("신체검사 등급을 입력해주세요.");
                grade = scanner.nextInt();
                if(grade <= 3) {
                    System.out.println("축하드립니다. 현역입니다.");
                } else if(grade == 4) {
                    System.out.println("면제입니다.");
                } else {
                    System.out.println("다시 입력하세요.");
                }
            } else {
                System.out.println("미성년자입니다.");
            }
        } else if (man == 1 ){
            System.out.println("국방의 의무가 없습니다.");
        } else {
            System.out.println("다시 입력하세요.");
            man = scanner.nextInt();
        }
    }
}



//int number = 0;
// 만약 number에 저장된 값이 양의 정수이면 "양의 정수입니다. " 가 출력되고
// 추가적으로 한 자리면 "한 자리의 양의 정수입니다. "
// 두 자리면 "두 자리의 양의 정수입니다."
// 그 외는 "세 자리 이상의 양의 정수입니다. " 가 출력된다.
// 만약 0일 때에는 "0입니다. "가 출력된다.
// 음의 정수는 ""음의 정수입니다. "가 출력된다.

        /*
        if( number > 0) {
            System.out.println("양의 정수입니다.");

            if(number < 10) {
                System.out.println("한 자리 양의 정수입니다.");
            } else if(number < 100) {
                System.out.println("두 자리 양의 정수입니다.");
            } else {
                System.out.println("세 자리 이상의 양의 정수입니다.");
            }

        } else if (number == 0) {
            System.out.println("0입니다.");

        } else {
            System.out.println("음의 정수입니다.");
        } */
