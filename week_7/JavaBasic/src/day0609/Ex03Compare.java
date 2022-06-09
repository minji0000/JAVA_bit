package day0609;
//참조형 데이터 타입에 대한 값 비교를 할 때 주의할 점
public class Ex03Compare {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = str1;

        System.out.printf("str1: [%s]\n", str1);
        System.out.printf("str2: [%s]\n", str2);
        System.out.printf("str3: [%s]\n", str3);
        System.out.printf("str4: [%s]\n", str4);

        System.out.println("Str1 == str2: "+ (str1 == str2));
        System.out.println("Str1 == str3: "+ (str1 == str3));
        System.out.println("Str1 == str4: "+ (str1 == str4));
        System.out.println("Str2 == str3: "+ (str2 == str3));
        System.out.println("Str2 == str4: "+ (str2 == str4));
        System.out.println("Str3 == str4: "+ (str3 == str4));

        // 클래스 메소드 사용하기
        // 해당 클래스 변수 혹은 값을 적고 뒤에 . 연산자를 통해 해당 메소드를 호출한다.

        System.out.println("str1.equals(str3): " + str1.equals(str3));

        System.out.printf("%06.5f", 3.5);


















    }












}
