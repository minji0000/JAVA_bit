package lol;

public class tanker extends garen {
    //속성
    String shield;
    String hermes;
    int potion;
    //액션
    float defense;


    // 방패
    public void setShield(String str1) {
        shield = str1;
    }

    public String getShield( ) {
        return shield;
    }

    public void putShield( ) {
        System.out.println("내가 가진 방패의 이름은 " + shield);
    }

    // 헤르메스
    public void setHermes(String str2) {
        hermes = str2;
    }

    public String getHermes( ) {
        return hermes;
    }

    public void putHermes( ) {
        System.out.println("내가 가진 헤르메스의 이름은 " + hermes);
    }

    // 포션
    public void setPotion(int int1) {
        potion = int1;
    }

    public int getPotion( ) {
        return potion;
    }

    public void putPotion( ) {
        System.out.println("나는 " + potion + "개의 포션을 가지고 있어!");
    }

    //액션
    public void Defensing(float flo1) {
        defense = flo1;
        System.out.println("내 방어력은 " + defense + "이야!");
    }

}
