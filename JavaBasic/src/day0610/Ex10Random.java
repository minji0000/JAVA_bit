package day0610;
import java.util.Random;

public class Ex10Random {
    public static void main(String [] args) {
        Random random = new Random(); //괄호 안에 숫자값 넣을 수 있음

        /*
        //1. double 타입의 랜덤한 숫자를 뽑을 때는?
        System.out.println(random.nextDouble());

        //2. int 범위 내의 랜덤한 정수를 뽑을 때는?
        System.out.println(random.nextInt());

        //3. 0~99까지 안에서 랜덤한 정수를 뽑을 때는?
        System.out.println(random.nextInt(100));

        //4. 1~100까지 안에서 랜덤한 정수를 뽑을 때는?
        System.out.println(random.nextInt((100)+1));


        //5. 501~510까지 안에서 랜덤한 정수를 뽑을 때는?
        System.out.println(random.nextInt((10)+ 501));
        //숫자가 10개가 들어갈 수 있음 **0~9** 10을 넣는다는 뜻이 아냐
        */

        //연습
        //System.out.println(random.nextInt((2)+1)); 이러면 그냥 3 나와
        System.out.println(random.nextInt(3)+1);





    }
}
