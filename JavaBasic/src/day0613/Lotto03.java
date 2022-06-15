package day0613;
// 로또게임 03
// 숫자를 모두 채우고 중복 제거 하는 대신
// 중복되지 않은 숫자만 배열에 저장하는 버전

import java.util.Random;

public class Lotto03 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] lottoNumbers = new int[6];

        for(int i = 0; i < lottoNumbers.length;) {
            boolean numSwitch = true;
            int randomNumber = random.nextInt(45)+1;

            for(int j = 0; j < i; j++) {
                if(randomNumber == lottoNumbers[j]) {
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
        for (int i = 0; i < lottoNumbers.length - 1; i ++) {
            if(lottoNumbers[i] > lottoNumbers[i+1]) {
                int temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i+1];
                lottoNumbers[i+1] = temp;
                i = -1;
            }
        }

        for(int i = 0; i < lottoNumbers.length; i++) {
            System.out.printf("%d번: [%d]\n", i, lottoNumbers[i]);
        }
    }
}
