package lol;

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

    }

}
