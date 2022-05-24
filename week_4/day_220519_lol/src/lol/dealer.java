package lol;

import java.util.Scanner;

public class dealer extends garen {
    private String sword;
    private String ninja;
    private int poison;
    private float power;

    //검
    public void setSword(String s) {
        sword = s;
    }

    public String getSword() {
        return sword;
    }

    public void putSword() {
        System.out.println("내 칼의 이름은 " + sword);
    }


    //닌자신
    public void setNinja(String ninja1) {
        ninja = ninja1;
    }

    public String getNinja( ) {
        return ninja;
    }

    public void putNinja( ) {
        System.out.println("내가 가진 닌자신의 이름은 " + ninja);
    }

    //독약

    public void setPoison (int poison1) {
        poison = poison1;
    }

    public int getPoison ( ) {
        return poison;
    }

    public void putPoison ( ) {
        System.out.println("나는 " + poison + "개의 독약을 가지고 있어 !");
    }

    //공격력
    public void setPower ( float power1 ) {
        power = power1;
    }

    public float getPower ( ) {
        return power;
    }

    public void putPower ( ) {
        System.out.println("내 공격력은 " + power + "이다!!");
    }


    public void question ( ) {

        Scanner sc = new Scanner(System.in); // 스캐너를 쓰겠다는 뜻
        String job = sc.nextLine();
        // equals는 문자열을 비교 시 사용하며, 변수.equals("비교할 문자열")




        if (job.equals("딜러")) {
            System.out.println("[딜러]를 선택하셨습니다.");

        }

        System.out.println("도구를 선택해주세요.");
        System.out.println("1. 장미칼");
        System.out.println("2. 방망이");

        String weapon = sc.nextLine();

        if (weapon.equals("장미칼")) {
            setSword("장미칼");
            putSword();
            System.out.println("딜러 가렌은 [장미칼]을 얻었다!");
        }

        System.out.println("신발을 선택해주세요.");
        System.out.println("1. 닌자신");
        System.out.println("2. 나막신");

        String shose = sc.nextLine();

        if (shose.equals("닌자신")) {
            setNinja("오른이 업그레이드 해준 신발");
            putNinja();
            System.out.println("딜러 가렌은 [닌자신]을 얻었다!");
        }

        System.out.println("인벤토리를 확인하시겠습니까?");
        System.out.println("1. 열기");
        System.out.println("2. 다음에");

        String inven = sc.nextLine();

        if (inven.equals("열기")) {
            System.out.println("ínvєntσrч");
            System.out.println(weapon);
            System.out.println(shose);
        }
    }



}
