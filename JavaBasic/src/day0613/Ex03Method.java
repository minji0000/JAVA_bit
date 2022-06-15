package day0613;
//method
//메소드란 특정 여러 줄의 코드를 매번 반복하여
//처음부터 끝까지 실행시켜야 하는 경우
//그 코드를 전부 다 적어주는 것이 아니라
//하나의 "단축키"를 만들어서
// 그 단축키를 적어주면 자동으로 모든 것이 실행되게 만들어주는 코드의 집합을 뜻하게 된다.

//public: 퍼블릭은 접근 제한자 중에 하나로써
//해당 메소드 혹은 변수/상수 등을 외부 패키지의 어디서든 접근 가능하게 설정해주는 키워드이다.

//static: 스태틱 키워드는 해당 메소드 혹은 변수/상수를
//우리가 클래스 변수를 안 만들고 직접 사용할 수 있게 만들어준다.
//단, 스태틱 메소드가 내부에서 다른 메소드 혹은 변수/상수를
//호출할 때에는 반드시 다른 메소드, 변수/상수도 static 키워드가 붙어야 한다.

// 메소드는 기본적으로 다음과 같은 구조를 가진다.
// public static 리턴타입 메소드이름(파라미터)

// 리턴타입: 해당 메소드가 실행이 끝나면서 호출된 곳으로 보내줄 값의 데이터 타입.
// 만약 아무런 값도 호출된 곳으로 보내주지 않는다면 void 라고 적어준다.

// 메소드 이름: 소문자로 시작하고 낙타등 표기법을 사용하는 동사

// 파라미터(매개변수): 이 메소드를 실행하는 데 필요로 하는 외부의 값을
// 변수처럼 사용할 수 있게 선언된 부분
// 만약 이 메소드를 실행시킬 때 외부의 값이 필요 없다면 빈칸으로 남겨둔다.


import java.util.Random;

public class Ex03Method {
    public static void main(String[] args) {
    //1. 특정 코드를 실행만 시킬 경우
        sign();

    //2. 외부의 값을 받아와서 내부에서 처리하여 실행시키는 경우
        int num = 3;
        /*
        if(num % 2 == 1) {
            System.out.println("홀수입니다.");
        } else {
            System.out.println("짝수입니다.");
        }

        num = 98;
        if(num % 2 == 1) {
            System.out.println("홀수입니다.");
        } else {
            System.out.println("짝수입니다.");
        } */

        // 파라미터의 이름이 달라도 같은 int 값이면 상관없어 ~
        printEvenOdd(15);

        int randomNum;
        randomNum = setRandomNum();
        randomNum = setRandomNum();
        randomNum = setRandomNum();
        randomNum = setRandomNum();
        randomNum = setRandomNum();

        int bigger;
        int num1 = 200;
        int num2 = 300;
        bigger = returnBigger(num1, num2);
        bigger = returnBigger(90,100);
        System.out.println(returnBigger(30,200));
        returnBigger(returnBigger(50,100),1000);

    } // 메인메소드

    public static void sign() {
        System.out.println("나는 밍디");
        System.out.println("이 과제는 다른 사람의 도움 없이 혼자 힘으로 풀었어욥");
        System.out.println("다른 사람의 힘을 빌렸을 경우 해당 과제는 0점처리됨을 동의합니다.");
    }

    public static void printEvenOdd(int a) {
        if (a % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
    }

    public static int setRandomNum() {
        Random random = new Random();
        int temp = random.nextInt();
        return temp;
    }

    public static int returnBigger(int num1, int num2) {
        //리턴은 두개 쓸 수 있으나 한 번에 하나만 실행이 된다.
        if(num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }
}
