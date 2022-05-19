package lol;

public class garen {
    String name ="";
    int hp = 0;
    float height = 0.0f;
    String nationality ="";


    // 이름
    public void setName(String name1) {
        name = name1;
    }

    public String getName( ) {
        return name;
    }

    public void putName( ) {
        System.out.println("내 이름은 " + name);
    }

    //체력
    public void setHp(int hp1) {
        hp = hp1;
    }

    public int getHp( ) {
        return hp;
    }

    public void putHp( ) {
        System.out.println("내 체력은 " + hp);
    }

    // 키
    public void setHeight(float height1) {
        height = height1;
    }

    public float getHeight( ) {
        return height;
    }

    public void putHeight( ) {
        System.out.println("내 키는 " + height);
    }

    //국적
    public void setNationality(String nationality1) {
        nationality = nationality1;
    }

    public String getNationality( ) {
        return nationality;
    }

    public void putNationality( ) {
        System.out.println("내 국적은 " + nationality);
    }

}
