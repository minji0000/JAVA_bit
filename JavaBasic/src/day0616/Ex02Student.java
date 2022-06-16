package day0616;

import java.util.Scanner;

public class Ex02Student {
    public static void main(String [] args) {
        Student s1 = new Student(); // 생성자
        Student s2 = new Student();
        System.out.println(s2.equals(s1));
        Scanner scanner = new Scanner(System.in);
        System.out.println(s2.equals(s1));
        System.out.println(s1.equals(scanner));

        System.out.println(s1.id);
        System.out.println(s1.name);

        s1.id = 1;
        s1.name = "민지";
        s1.korean = 80;
        s1.english = 80;
        s1.math = 81;

        Student2 s3 = new Student2(4, "밍밍디", 50,50,51);
        // 캡슐화가 적용되었을 경우
        // 필드에 값을 저장할 때에는 우리가 해당 객체의 setter 메소드를 통하여 값을 저장하게 된다.
        s3.setId(40);
        s3.setName("베리");
        s3.setKorean(50);
        s3.setEnglish(51);
        s3.setMath(53);

        // 특정 필드의 저장되어있는 값을 호출할 때에는 getter를 사용한다.
        System.out.println("s3의 이름: " + s3.getName());

        // 만약 외부가 접근 가능한 메소드라면?
        // 그냥 기존의 방법처럼 호출하면 된다.
        s3.printInfo();

        System.out.println(s3);

    }
}











