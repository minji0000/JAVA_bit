package day0610;

public class Ex02Switch {
    public static void main (String [] args) {
        int number = 2;

        switch (number) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("그 외입니다.");
                break;
        }
    }
 }
