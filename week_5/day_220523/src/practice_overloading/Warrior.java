package practice_overloading;

public class Warrior {

    public void useAttackWithWeapons() {
        System.out.println("인벤토리에 저장된 무기 중 첫 번째 무기로 공격");
    }
    public void useAttackWithWeapons(String a) {
        System.out.println(a+"로 공격");
    }

    public void useAttackWithWeapons(String a, float b) {
        System.out.println(a + "로" + " 데미지를 " + b + "만큼 입혔다!" );
    }

    public void attackWithSword() {
        System.out.println("Warrior Attack ! !");
    }

    public void defendWithShield( ) {
        System.out.println("Warrior is Running");

    }
}
