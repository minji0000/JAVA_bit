package day0613;
// 다섯명의 학생의 성적을 관리하는 프로그램을 작성하시오.
// 단, 해당 프로그램은 입력과 출력이 분리되어있고
// 만약 다섯명을 초과하여 입력하려고 하면 경고메시지만 출력되고
// 한 명도 입력 안 하고 출력을 한다면 경고 메시지가 출력되게 코드를 작성하시오.

// 힌트: 내가 입력할 순서는 몇번...?
// 번호 이름 국어 영어 수학 ===== 다섯개의 배열 필요
// 한 명도 입력 안 하고 출력하면 " 입력된 학생이 없습니다. "
// 다섯명 입력하고 또 입력하려고 하면 " 더이상 입력하실 수 없습니다."

import java.util.Scanner;

public class GradeBook03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            // 배열은 초기화 한 그래도의 크기를 가지고 있음
            // 상수
            final int ARRAY_SIZE = 5;
            final int SUBJECT_SIZE = 3;
            final int SCORE_MIN = 0;
            final int SCORE_MAX = 100;

            //변수
            int [] idArray = new int[ARRAY_SIZE];
            String[] nameArray = new String[ARRAY_SIZE];
            int [] koreanArray = new int[ARRAY_SIZE];
            int [] englishArray = new int[ARRAY_SIZE];
            int [] mathArray = new int[ARRAY_SIZE];

            // 현재 입력할 인덱스가 몇 번 인덱스인지 저장할 변수
            int currentIndex = 0;
            while(true) {
                System.out.println("1. 입력 2. 출력 3. 종료");
                System.out.println("> ");
                int userChoice = scanner.nextInt();

                if(userChoice == 1 ) {
                    if (currentIndex < ARRAY_SIZE) {
                    System.out.println("학생의 번호를 입력해주세요.");
                    System.out.print("> ");
                    idArray[currentIndex] = scanner.nextInt();

                        System.out.println("학생의 이름을 입력해주세요.");
                        System.out.println(">");
                        scanner.nextLine();
                        nameArray[currentIndex] = scanner.nextLine();

                        int temp;
                        String message = "학생의 국어 점수를 입력해주세요.";

                        System.out.println(message);
                        System.out.println("> ");
                        temp = scanner.nextInt();

                        while (temp < SCORE_MIN || temp > SCORE_MAX) {
                            System.out.println("잘못입력하셨습니다.");
                            System.out.println(message);
                            System.out.println("> ");
                            temp = scanner.nextInt();
                        }

                        koreanArray[currentIndex] = temp;

                         message = "학생의 영어 점수를 입력해주세요.";

                        System.out.println(message);
                        System.out.println("> ");
                        temp = scanner.nextInt();

                        while (temp < SCORE_MIN || temp > SCORE_MAX) {
                            System.out.println("잘못입력하셨습니다.");
                            System.out.println(message);
                            System.out.println("> ");
                            temp = scanner.nextInt();
                        }

                        englishArray[currentIndex] = temp;

                        message = "학생의 수학 점수를 입력해주세요.";

                        System.out.println(message);
                        System.out.println("> ");
                        temp = scanner.nextInt();

                        while (temp < SCORE_MIN || temp > SCORE_MAX) {
                            System.out.println("잘못입력하셨습니다.");
                            System.out.println(message);
                            System.out.println("> ");
                            temp = scanner.nextInt();
                        }

                        mathArray[currentIndex] = temp;

                        currentIndex ++;


                    } else {
                        System.out.println("더 이상 입력하실 수 없습니다.");
                    }

                } else if (userChoice == 2 ) {

                    if(currentIndex == 0 ) {
                        System.out.println("아직 한명도 입력되지 않았습니다.");
                    } else {
                        for (int i = 0; i < currentIndex; i++) {
                            int sum = koreanArray[i] + englishArray[i] + mathArray[i];
                            double average = (double) sum / SUBJECT_SIZE;

                            System.out.printf("번호: %d 이름: %s\n", idArray[i], nameArray[i]);
                            System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점", koreanArray[i], englishArray[i], mathArray[i]);
                            System.out.printf("총점: %03d점: 평균: %06.2f점\n", sum, average);

                        }
                    }

                } else if (userChoice == 3) {
                    System.out.println("사용해주셔서 감사합니다.");
                    break;
                }
            }


        scanner.close();

    }
}
