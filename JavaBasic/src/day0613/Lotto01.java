package day0613;
// 배열 없이 로또 번호 추점기 만들기
import java.util.Random;

public class Lotto01 {
    public static void main (String [] args) {
        Random random = new Random();

        // 각 로또 번호를 저장할 int 변수
        int lottoNum1 = 0;
        int lottoNum2 = 0;
        int lottoNum3 = 0;
        int lottoNum4 = 0;
        int lottoNum5 = 0;
        int lottoNum6 = 0;

        // int 변수 temp에 첫 번째 로또 숫자를 지정한다.
        int temp = random.nextInt(45)+1;
        lottoNum1 = temp;

        while ( temp == lottoNum1) {
            temp = random.nextInt(45)+1;
        }
        lottoNum2 = temp;

        while ( temp == lottoNum1 || temp == lottoNum2) {
            temp = random.nextInt(45)+1;
        }

        lottoNum3 = temp;

        while(temp == lottoNum1 || temp == lottoNum2 || temp == lottoNum3) {
            temp = random.nextInt(45)+1;
        }

        lottoNum4 = temp;

        while(temp == lottoNum1 || temp == lottoNum2 || temp == lottoNum3 || temp == lottoNum4) {
            temp = random.nextInt(45)+1;
        }

        lottoNum5 = temp;

        while(temp == lottoNum1 || temp == lottoNum2 || temp == lottoNum3 || temp == lottoNum4 || temp == lottoNum5) {
            temp = random.nextInt(45)+1;
        }

        lottoNum6 = temp;

        System.out.printf("%d %d %d %d %d %d \n", lottoNum1, lottoNum2, lottoNum3, lottoNum4, lottoNum5, lottoNum6);

        int sortedNum1 = 0;
        int sortedNum2 = 0;
        int sortedNum3 = 0;
        int sortedNum4 = 0;
        int sortedNum5 = 0;
        int sortedNum6 = 0;

        temp = lottoNum1;
        if (temp > lottoNum2) {
            temp = lottoNum2;
        }
        if (temp > lottoNum3) {
            temp = lottoNum3;
        }
        if (temp > lottoNum4) {
            temp = lottoNum4;
        }
        if (temp > lottoNum5) {
            temp = lottoNum5;
        }
        if (temp > lottoNum6) {
            temp = lottoNum6;
        }

        sortedNum1 = temp;



    }
}
