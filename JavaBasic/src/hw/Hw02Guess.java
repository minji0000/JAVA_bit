package hw;
//숫자 맞추기 게임
// 컴퓨터가 뽑은 1~100 안의 랜덤한 숫자 맞추기
// 플레이:
// 사용자가 숫자를 입력해서 해당 숫자보다 크면 "Down"이 출력되고 작으면 "Up"이 출력된다.
// 사용자가 숫자를 입력할 때마다 현재 점수가 1점씩 오른다.
// 만약 숫자를 맞췄을 경우, 간단하게 축하하고 최고기록을 출력해준다.
// 단, 현재 기록이 최고 기록을 갱신할 경우 현재 기록이 새로운 최고 기록이 됨을 알려준다.
// 현재 최고 기록 보기: 현재 최고 점수를 보여준다.
// 단, 플레이 기록이 없을 경우 경고 메시지를 출력해준다.

// 사용자가 잘못된 정수 입력 하면 검증해 !@ - 잘못 입력하셨습니다. 다시 입력해즈세여~
// 잘못 입력 시 점수 안 깎여

import java.util.Random;
import java.util.Scanner;

public class Hw02Guess {
    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;
        int reCount = 0;
        int playCount = 0;

        while(true) {
            System.out.println("**********************************");
            System.out.println("숫자 맞추기 게임 ~ ! 야호 ~!");
            System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
            System.out.println("1. 숫자 맞추기 게임하기");
            System.out.println("2. 현재 최고 기록 보기");
            System.out.println("3. 종료");
            System.out.println("**********************************");
            int userChoice = scanner.nextInt();
            int aiNumber = random.nextInt(100) + 1;
            int playNumber = 0;
            int rePlayNumber = 0;

            if (userChoice == 1) {
                System.out.println("숫자 맞추기 게임 Start ! !");
                System.out.println("1~100 까지의 숫자 중에서 하나를 맞춰보세요 !");

                while (playNumber != aiNumber) {
                    playNumber = scanner.nextInt();

                    if (playNumber > aiNumber) {
                        System.out.println(playNumber + "보다 더 작아요 !");
                    } else if (playNumber < aiNumber) {
                        System.out.println(playNumber + "보다 더 커요 !");
                    }
                    count++;

                }
                playCount ++;
                System.out.println("축하합니다! ! !");
                System.out.println(count + "회만에 성공하셨습니다 !");
                System.out.println("계속 도전하시겠습니까?");
                System.out.println("1. 계속 도전하기");
                System.out.println("2. 그만하기");
                int reChoice = scanner.nextInt();

                if (reChoice == 1) {
                  System.out.println("1~100 까지의 숫자 중에서 하나를 맞춰보세요 !");

                    int reAiNumber = random.nextInt((100) + 1);
                    while (rePlayNumber != reAiNumber) {
                        rePlayNumber = scanner.nextInt();
                        if (rePlayNumber > reAiNumber) {
                            System.out.println(rePlayNumber + "보다 더 작아요 !");

                        } else if (rePlayNumber < reAiNumber) {
                            System.out.println(rePlayNumber + "보다 더 커요 !");
                        }
                        reCount++;

                    }
                    System.out.println("축하합니다! ! !");
                    System.out.println(reCount + "회만에 성공하셨습니다 !");

                }

            } else if (userChoice == 2) {
                if(playCount > 0 ){
                    if(count > reCount) {
                    System.out.println("최고 기록은 " + reCount + " 회 입니다.");
                    } else {
                        System.out.println("최고 기록은 " + count + "회 입니다.");
                    }
                } else {
                    System.out.println("플레이 기록이 없습니다.");
                    System.out.println("얼른 플레이 하고 와주세요 ^0^");
                }

            } else if (userChoice == 3) {
                System.out.println("플레이 해주셔서 감사합니다. ^0^");
                break;
            }

        }

    }

}
