package day0613;
import java.util.Random;
import java.util.Scanner;

public class Lotto04 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int[] lottoNumbers = new int[6];

        //컴퓨터 숫자 결정
        for(int i = 0; i < lottoNumbers.length;) {
            boolean numSwitch = true;
            int randomNumber = random.nextInt(45) + 1;

            for(int j = 0; j < i; j++) {
                if (randomNumber == lottoNumbers[j]) {
                    numSwitch = false;
                }
            }

            // 중복된 숫자가 아닌 경우 실행
            if (numSwitch) {
                lottoNumbers[i] = randomNumber;
                i++;
            }
        }
        // 정렬
        for (int i = 0; i < lottoNumbers.length - 1; i++) {
            if(lottoNumbers[i] > lottoNumbers[i + 1]) {
                int temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i+1];
                lottoNumbers[i + 1] = temp;
                i = -1;
            }
        }

        // 사용자 숫자 배열 결정
        int [] userNumbers = new int[6];
        // 1. 사용자로부터 자동 혹은 수동을 입력받는다.
        System.out.println("1. 자동 2. 수동");
        System.out.println("> ");
        int userChoice = scanner.nextInt();

        for (int i = 0; i < userNumbers.length;) {
            int temp;
            boolean numberSwitch = true;

            if (userChoice == 1) {
                //자동일 경우
                temp = random.nextInt(45)+1;

            } else {
                //수동일 경우
                System.out.println((i+1)+"번째 숫자");
                System.out.println("1부터 45 사이의 숫자를 입력해주세요.");
                System.out.println("> ");
                temp = scanner.nextInt();
            }

            for(int j = 0; j < i; j++) {
                if (userNumbers[j] == temp) {
                    numberSwitch = false;
                }
            }

            // 사용자가 잘못된 값을 입력했을 경우
            if (temp > 45 || temp < 1) {
                numberSwitch = false;
            }

            if(numberSwitch) {
                userNumbers[i] = temp;
                i++;

                //수동이면서 잘못 입력했을 경우
            } else if(userChoice == 2) {
                System.out.println("잘못 입력하셨습니다.");
            }

        }

            for(int i = 0; i < userNumbers.length - 1; i++) {
                if(userNumbers[i] > userNumbers[i+1]) {
                    int temp = userNumbers[i];
                    userNumbers[i] = userNumbers[i + 1];
                    userNumbers[i + 1] = temp;
                    i = -1;
                }
            }

        //똑같은 숫자의 갯수를 저장할 변수
        int count = 0;

        for (int i = 0; i < lottoNumbers.length; i++) {
            for (int j = 0; j < userNumbers.length; j++) {
                if(lottoNumbers[i] == userNumbers[j]) {
                    count++;
                }
            }
        }

        System.out.print("컴퓨터 숫자: [");
        for (int i = 0; i < lottoNumbers.length; i++) {
            System.out.printf("%2d", lottoNumbers[i]);
            if(i < lottoNumbers.length -1 ) {
                System.out.print(" ");
            } else {
                System.out.println("]");
            }
        }

        System.out.print("사용자숫자: [");
        for(int i = 0; i<lottoNumbers.length; i++) {
            System.out.printf("%2d", lottoNumbers[i]);
            if(i < lottoNumbers.length -1 ) {
                System.out.print(" ");
            } else {
                System.out.println("]");
            }
        }

        System.out.println("총 맞은 갯수: " + count + "개");

        scanner.close();
    }
}
