package lol;

import java.util.Scanner;

public class play {

    public static void main(String[] args) {

        garen ren = new garen();
        ren.setName("가붕");
        ren.putName();
        ren.setHp(100);
        ren.putHp();
        ren.setHeight(179.5f);
        ren.putHeight();
        ren.setNationality("데마시아!!!!!!!!!!");
        ren.putNationality();

        System.out.println("직업을 골라주세요.");
        dealer dea = new dealer();
        dea.question();



       /*  Scanner sc = new Scanner(System.in); // 스캐너를 쓰겠다는 뜻
        String job = sc.nextLine();


        dealer dea = new dealer();
        // equals는 문자열을 비교 시 사용하며, 변수.equals("비교할 문자열")
        if (job.equals("딜러")) {
            System.out.println("[딜러]를 선택하셨습니다.");
        }

        System.out.println("도구를 선택해주세요.");
        System.out.println("1. 장미칼");
        System.out.println("2. 방망이");

        String weapon = sc.nextLine();

        if (weapon.equals("장미칼")) {
            dea.setSword("장미칼");
            dea.putSword();
            System.out.println("딜러 가렌은 [장미칼]을 얻었다!");
        }

        System.out.println("신발을 선택해주세요.");
        System.out.println("1. 닌자신");
        System.out.println("2. 나막신");

        String shose = sc.nextLine();

        if (shose.equals("닌자신")) {
            dea.setNinja("오른이 업그레이드 해준 신발");
            dea.putNinja();
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

        System.out.println("인벤토리를 확인하시겠습니까?");
        System.out.println("1. 열기");
        System.out.println("2. 다음에");




        dealer dea = new dealer();
        dea.setSword("장미칼");
        dea.putSword();
        System.out.println("딜러 가렌은 [장미칼]을 얻었다!");

        if (job.equals("신발")) {
            System.out.println("[신발]를 선택하셨습니다.");
            dea.setNinja("오른이 업그레이드 해준 신발");
            dea.putNinja();
        }



        tanker tan = new tanker();

        tan.setShield("완전 멋진 짱짱 센 방패");
        tan.putShield();
        tan.setHermes("이즈리얼이 신던 거 뻇어온 신발");
        tan.putHermes();
        tan.setPotion(5);
        tan.putPotion();
        tan.Defensing(96.2f);

        dealer dea = new dealer();
        dea.setSword("장미칼");
        dea.putSword();
        dea.setNinja("오른이 업그레이드 해준 신발");
        dea.putNinja();
        dea.setPoison(7);
        dea.putPoison();
        dea.setPower(287.9f);
        dea.putPower();

        */


    }
}
