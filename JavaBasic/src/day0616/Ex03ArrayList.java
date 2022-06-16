package day0616;
// 어레이리스트를 사용한 로또 번호 제작기

import java.util.ArrayList;
public class Ex03ArrayList {
    public static void main(String[] args) {
        // 어레이리스트 객체는 반드시 해당 객체가
        // 어떤 클래스 객체의 모음인지를 적어주어야 하기 때문에
        // 다음과 같은 방법으로 선언과 초기화를 한다.
        //ArrayList<클래스이름> 객체이름 = new ArrayList<>();
        // 이러한 <>을 우리가 템플릿이라고 부른다.

        //"Integer" 클래스를 모아둔 ArrayList 객체 list
        ArrayList<Integer> list = new ArrayList<>();

        // 1. 해당 어레이리스트에 객체가 존재하는지 안 하는지 체크하고 싶다면?
        System.out.println("isEmpty(): " + list.isEmpty());
        // 2. 해당 어레이리스트에 몇 개의 객체가 존재하는지 알고 싶다면?
        System.out.println("size(): " + list.size());
        // 3. 해당 어레이리스트에 가장 마지막에 새로운 요소를 추가하고 싶다면?

        //추가할 Integer 객체들
        // Integer 객체의 초기화는 int 값으로도 가능하다.
        Integer i1 = 1;
        Integer i2 = 2;
        int num3 = 3;
        Integer i3 = num3;
        Integer i4 = new Integer(6);

        // list에 값을 추가해보자
        list.add(i1);
        list.add(i2);
        list.add(2);
        list.add(num3);
        list.add(i3);
        System.out.println("add() 후 size(): " + list.size());

        // 4. 리스트에 특정 인덱스 값의 저장된 객체를 불러올 때에는?
        // get()
        System.out.println("get(1): " + list.get(1));

        // 5. 리스트의 특정 위치에 새로운 객체를 끼어넣을 떄에는?
        list.add(1, 200);
        System.out.println("get(1): " + list.get(1));

        // 6. 리스트의 특정 인덱스의 값을 삭제할 때에는?
        list.remove(1);
        System.out.println("get(1): " + list.get(1));

        // 7. 리스트의 전체 내용을 삭제할 때에는?
        list.clear();
        System.out.println("isEmpty(): " + list.isEmpty());

        // 아래의 메소드들은 정확한 결과를 받기 위해서는
        // 반드시 해당 클래스 안에 equals() 메소드가
        // 정확하게 오버라이드되어 있어야 한다.

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 특정 요소가 리스트에 존재하는지 알고 싶을 때는?
        // contains()
        System.out.println("contains(i2): " + list.contains(i2));
        System.out.println("contains(i4): " + list.contains(i4));










    }
}



















