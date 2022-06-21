package util;
//스캐너를 사용할 시에 도움이 될 메소드를 정의한 클래스
import java.util.Scanner;

public class ScannerUtil {
    // 0. 입력 받을 내용을 출력하는 printMessage
    public static void printMessage(String message) {

        System.out.println("=============================");
        System.out.println(message);
        System.out.println("=============================");
        System.out.println("> ");
    }

    // 1. 스캐너 버그를 미리 해결한 nextLine()
    public static String nextLine(Scanner scanner, String message){
        printMessage(message);
        String temp = scanner.nextLine();
        //String 변수/상수 혹은 값의 경우
        //isEmpty() 메소드를 실행시키면
        // 아무런 값도 없으면 true, 아무 글자가 하나라도 있으면 false가 리턴된다. 공백도 좋아ㅏ!
        if(temp.isEmpty()) {
            temp = scanner.nextLine();
        }
        return temp;
    }

    // 2. int를 처리하는 nextInt()
    public static int nextInt(Scanner scanner, String message) {
        printMessage(message);
        int temp = scanner.nextInt();
        return temp;
    }
    //3. 특정 범위안의 int를 리턴하는 nextInt()
    public static int nextInt(Scanner scanner, String message, int min, int max){
        int temp = nextInt(scanner, message);

        while(temp < min || temp > max) {
            System.out.println("잘못 입력해써 잘 좀 해봐");
            temp = nextInt(scanner, message);

        }

        return temp;
    }

}
