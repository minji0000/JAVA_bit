package practice_overloading;

public class B extends A {
    public void testing () {}

    //오버로딩테스트
    //매개변수를 글자로 주면 이게 작동함
    //글자를 주는 건 무기를 변경해서 공격하겠다는 의미임(그냥 내가 정한 거)
    public void Attack() {
        System.out.println("맨주먹으로 공격한다.");
    }
    public void Attack(String w, int power) {
        System.out.println("현재 장작된 옷을 인텐토리에 집어넣는다.");
        System.out.println("새로운 무기인 " + w + "로 " + power +"의 힘으로 공격");
    }

    //매개변수를 숫자(정수)로 주면 이게 작동함.
    //숫자를 주는 건 현재 무기로 공격하겠다는 의미임 (단지, 파워를 조절가능함)
    public void Attack(int w) {
        System.out.println("현재 장착된 무기로 "+w+" 의 파워로 공격");
    }
    //매개변수를 숫자(실수)로 주면 이게 작동함.
    //숫자를 주는 건 현재 무기로 공격하겠다는 의미임 (단지, 파워를 조절가능함)
    //실수형태로 준다는 건 더 정밀하게 조절할 수 있다는 장점이 있음. (밸런스 조절 시 유리함, 패치작업)
    public void Attack(float w) {
        System.out.println("현재 장작된 무기로 " +w+ "의 파워로 공격");
    }

    //오버로딩 테스트
    //매개변수를 글자의 숫자로 주면 이게 작동함
    // 글자를 주는 건 무기를 변경해서 공격하겠다는 의미임. (그냥 내가 정함)
    // 숫자는 당연히 그 무기로 이 정도 파워로 공격하라는 것.
    public void Attack(String w, float power) {
        System.out.println("현재 장작된 무기를 인벤토리에 집어넣는다.");
        System.out.println("새로운 무기인 " + w + "로 " + power + " 정도의 파워로 공격");
    }

    public void Attack(String w, int power, float hp) {
        System.out.println(w + "를 사용해서 " + power + "의 파워로 " + hp + "정도의 데미지를 입혔다!");
    }
}
