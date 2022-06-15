package hw;

import java.util.Random;
import java.util.Scanner;

public class Rv02Guess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bestScore = 0;

        while (true) {
            System.out.println("1. 플레이 2. 최고 점수 보기 3. 종료");
            int userChoice = scanner.nextInt();

            if(userChoice == 1) {
                // 현재 점수를 저장할 변수
                int currentScore = 0;

                // 1. 숫자 맞추기 게임

                // 컴퓨터 숫자 결정
                int computerNumber = random.nextInt(100) + 1;

                // 사용자한테 숫자를 입력 받는다.
                System.out.println("1~100 사이의 숫자를 입력해주세요.");
                System.out.println(" > ");
                int userNumber = scanner.nextInt();
                currentScore++;

                // 사용자 숫자와 컴퓨터 숫자가 다르면 거기에 맞춘 결과를 추가해준다.
                while (userNumber != computerNumber) {
                    if(userNumber > computerNumber) {
                        System.out.println("DOWN");
                    } else {
                        System.out.println("Up !");
                    }

                    System.out.println("1~100 사이의 숫자를 입력해주세요.");
                    System.out.println(" > ");
                    userNumber = scanner.nextInt();

                    currentScore++;
                }

                // 2. 현재 점수 출력
                System.out.println("현재 점수: " + currentScore);

                // 3. 최고기록 갱신 여부 결정
                if (bestScore == 0) {
                    System.out.println("기존 플레이 기록이 없으므로 현재 기록이 최고 기록이 됩니다!");
                    bestScore = currentScore;
                } else {
                    System.out.println("기존 최고기록: " + bestScore);
                     if(bestScore > currentScore) {
                         System.out.println("짝짝짝 ! 새로운 최고 기록입니다.");
                         bestScore = currentScore;
                     }
                }

            } else  if(userChoice == 2) {

                if (bestScore == 0) {
                    System.out.println("아직 플레이 기록이 없습니다.");
                } else {
                    System.out.println("현재 최고기록: " + bestScore);
                }

            } else  if (userChoice == 3) {
                System.out.println("플레이 해주셔서 감사합니다.");
                break;
            }
        }

        scanner.close();
    }
}
