package hw;
// 가위바위보 만들기
// 컴퓨터를 상대로 하는 가위 바위 보 게임을 만들어보세요.
// 단, 플레이와 현재 기록보기 기능이 분리되어 있으며
// 플레이 시에는 1. 가위 --> 2. 바위 --> 3. 보 가 입력되어서
// 승리, 패배, 무승부가 기록됩니다.
// 현재 기록을 볼 때에는 총 ###전 ###승 ###무 ###패 (승률: ##.##%) 가 나오게 됩니다.
// 승률은 승 / (승+무+패) 입니다.

// 무한반복문 안에 넣기

import java.util.Random;
import java.util.Scanner;

public class Hw01RSP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;

        while (true) {
            System.out.println("***가위 바위 보 게임***");
            System.out.println("1. 플레이");
            System.out.println("2. 현재 기록보기");
            System.out.println("3. 종료");
            System.out.println("원하시는 메뉴의 번호를 입력해주세요.");

            int userChoice = scanner.nextInt();

            // 플레이
            if (userChoice == 1) {
                System.out.println("가위바위보 게임 Start! ");
                while (true) {
                    System.out.println("원하시는 동작의 번호를 입력해주세요.");
                    System.out.println("1. 가위");
                    System.out.println("2. 바위");
                    System.out.println("3. 보");
                    System.out.println("4. 메뉴로 돌아가기");

                    int userPlay = scanner.nextInt();

                    if (userPlay == 1) {
                        count++;
                        int aiNumber = random.nextInt((3) + 1);
                        if (aiNumber == 1) {
                            System.out.println("무승부입니다.");
                        } else if (aiNumber == 2) {
                            System.out.println("졌습니다..");
                        } else if (aiNumber == 3) {
                            System.out.println("이겼습니다!");
                        }

                    } else if (userPlay == 2) {
                        count++;
                        int aiNumber = random.nextInt((3) + 1);
                        if (aiNumber == 1) {
                            System.out.println("이겼습니다!");
                        } else if (aiNumber == 2) {
                            System.out.println("무승부입니다.");
                        } else if (aiNumber == 3) {
                            System.out.println("졌습니다..");
                        }

                    } else if (userPlay == 3) {
                        count++;
                        int aiNumber = random.nextInt((3) + 1);
                        if (aiNumber == 1) {
                            System.out.println("졌습니다..");
                        } else if (aiNumber == 2) {
                            System.out.println("이겼습니다!");
                        } else if (aiNumber == 3) {
                            System.out.println("무승부입니다.");
                        }
                    } else {
                        System.out.println("메뉴로 돌아갑니당~");
                        break;
                    }
                }

            } else if (userChoice == 2) {
                System.out.println("현재 기록은 : " + count + "회 입니다.");
                break;

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }

        }
    }
}


