package lol;

import java.sql.SQLOutput;

public class dealer extends garen {

    String sword;
    String ninja;
    int poison;
    float power;

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
















}
