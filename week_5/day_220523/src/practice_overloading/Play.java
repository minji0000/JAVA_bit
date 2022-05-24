package practice_overloading;

public class Play {
    public static void main(String [] args) {

        B obj_B = new B();
        obj_B.testing();
        obj_B.Attack("엑스칼리버",6583214, 3241.14f);

        Magician mgc = new Magician();
        mgc.useMagic();
        mgc.useMagic("얼음");
        mgc.useMagic("화염");
        mgc.useMagic("소환");
        mgc.useMagic("화염", 284.3f);

        Warrior war = new Warrior ();
        war.useAttackWithWeapons();
        war.useAttackWithWeapons("칼");
        war.useAttackWithWeapons("칼", 924.34f);

       // war.attackWithSword();
       // war.defendWithShield();
    }
}
