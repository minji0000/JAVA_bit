package day0615;
//Student 데이터타입의 배열을 사용하여
//다섯명의 학생을 관리하는 프로그램을 작성하시오.
//동적할당 X
//심화: 위 프로그램을 완성하신 분들은 ArrayUtil에 Student 타입 배열을
//동적할당하는 메소드들을 구현하시오.

import struct.Student;
import util.ScannerUtil;

import java.util.Scanner;

public class Ex02GradeBook01 {
        public static Student[] array;
        public static int nextIndex;
        public static Scanner scanner;

        public static final int STUDENT_SIZE = 5;
        public static final int SUBJECT_SIZE = 3;
        public static final int SCORE_MIN = 0;
        public static final int SCORE_MAX = 100;

    public static void init() {
        array = new Student[STUDENT_SIZE];
        nextIndex = 1;
        scanner = new Scanner(System.in);
    }

    public static void showMenu() {
        while(true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1) {

            } else if(userChoice == 2) {

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void insert() {
        if(nextIndex < STUDENT_SIZE) {
            //아직 배열에 빈 자리가 있으므로 입력 가능하다.
            //정보를 담을 Student 변수
            Student s = new Student();

            //번호 입력
            String message = "학생의 번호를 입력해주세요.";
            s.id = ScannerUtil.nextInt(scanner, message);

            //이름 입력
            message = "학생의 이름을 입력해주세요.";
            s.name = ScannerUtil.nextLine(scanner, message);

            //국어 점수 입력
            message = "학생의 국어점수를 입력해주세요.";
            s.korean= ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            //영어 점수 입력
            message = "학생의 영어점수를 입력해주세요.";
            s.english= ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            //수학 점수 입력
            message = "학생의 수학점수를 입력해주세요.";
            s.math= ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

            //배열에 추가
            array[nextIndex] = s;

            //nextIndex를 1 증가시켜서 다음 입력할 인덱스를 저장
            nextIndex++;

        } else {
            //더 이상 배열에 빈 자리가 없으므로 경고 메시지만 출력
            System.out.println("더 이상 입력하실 수 없습니다.");
        }

    }

    public static void print() {
        if (nextIndex == 0) {
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            for(Student s : array) {
                int sum = s.korean + s.english + s.math;
                double average = (double)sum / SUBJECT_SIZE;
                System.out.printf("번호: %d번 이름: %s\n" , s.id, s.name);
                System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.korean, s.english, s.math);

                // 가독성이 좋아지도록 짧게 쓰려면
                //Student s = array[i];
                // int sum = s.korean + s.english + s.math;
                // double average = (double)sum / SUBJECT_SIZE;
                // System.out.printf("번호: %d번 이름: %s\n" , s.id, s.name);
                // System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.korean, s.english, s.math);

                    /*
                    int sum = array[i].korean + array[i].english + array[i].math;
                    double average = (double)sum / SUBJECT_SIZE;

                    System.out.printf("번호: %d번 이름: %s\n" , array[i].id, array[i].name);
                    System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", array[i].korean, array[i].english, array[i].math);
                    */
            }
        }
    }

    public static void main(String [] args) {
        init();
        showMenu();
        scanner.close();
    }


















}
