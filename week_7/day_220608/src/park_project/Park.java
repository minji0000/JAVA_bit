package park_project;

import java.util.Scanner;
import java.util.ArrayList;

public class Park {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in_time = 0;
        String car_number = "";
        ArrayList<Integer> car_time = new ArrayList<Integer>();
        ArrayList<String> number = new ArrayList<String>();

        while (true) {
            System.out.println("원하시는 서비스를 선택해주세요.");
            System.out.println("1. 입차");
            System.out.println("2. 출차");
            System.out.println("3. 종료");

            // 고객이 원하는 서비스를 선택할 숫자 입력
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("차량 번호를 입력해주세요.");
                    car_number = sc.next();


                    number.add(car_number);
                    System.out.println("입차 시간을 입력해주세요.");
                    in_time = sc.nextInt();
                    time.add(in_time);
                    System.out.println("입차되었습니다.");
                    break;

                case 2:
                    for(int i = 0; i <number.size(); i++) {
                        System.out.println("주차된 차량번호를 입력해주세요.");
                        String remove_number = sc.next();
                        if(remove_number.equals(number.get(i))) {
                            number.remove(i);
                            System.out.println("출차되었습니다.");
                        } else {
                            System.out.println("다시 입력해주세요.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("종료하겠습니다.");
                    System.exit(0); // 정말 종료가 되는 상황에서 사용
            }
        }
    }

}