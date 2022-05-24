package practice_overloading;

public class Magician extends human {
    // 마법사는 휴먼의 모든 기본속성과 기능을 공유한다.
    // 마법사만 사용할 수 있는 액션
    // 마법사의 액션(메소드)을 오버로딩으로 구현해보자!
    // 지금은 3개의 액션으로 구성되어있다. 이것을 1개의 메소드로 사용할 수 있게 설계를 바꿔주는 것.
    // 새로운 메소드의 이름은 useMagic()
    // 이 메소드는 2가지의 스타일로 작동될 수 있다. (문자열 매개변수 / 문자열 매개변수와 실수형)
    // 메소드의 형태는 대략 아래와 같음.
    // void useMagic (문자열)
    // void useMagic (문자열, 실수형)
    //문자열 매개변수 스타일의 메소드는 출력형태가 아래와같음
    // "A계열 마법을 사용한다." (A는 전달된 문자열이어야함)
    // 문자열 매개변수와 실수형으로 되어있는 메소드는 출력형태가 아래와같음
    // A계열 마법을 B의 마력으로 사용한다. A,B 는 전달된 문자열과 실수형데이터)

    @Override
    public void useMagic() {
        System.out.println("랜덤마법 공격!");
    }

    public void useMagic(String m) {
        System.out.println(m + "계열 마법 공격!");
    }

    public void useMagic (String m,float magic_power) {
        System.out.println(m + "계열 마법공격! 마력:" + magic_power + " 소모함");
    }





}
