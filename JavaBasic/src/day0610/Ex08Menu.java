package day0610;
//무한루프를 사용한 메뉴 구성해보기


import java.util.Scanner;

public class Ex08Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println(
                    "1. 1번 기능 실행 2. 2번 기능 실행 3. 3번 기능실행 4. 종료");
            System.out.println("> ");
            int userChoice = scanner.nextInt();

            if(userChoice == 1) {

            } else if(userChoice == 2) {

            } else if(userChoice == 3) {

            } else if(userChoice == 4) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }


        }


    }
}
