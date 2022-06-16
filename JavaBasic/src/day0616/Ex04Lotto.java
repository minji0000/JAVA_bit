package day0616;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Ex04Lotto {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        // 1.리스트에 중복되지 않은 숫자 추가하기
        while(list.size() < 6) {
            int num = random.nextInt(45)+1;
            if(!list.contains(num)) {
                list.add(num);
            }
        }

        // 2. 정렬하기
        Collections.sort(list);

        // 3. 출력하기
        System.out.println(list);








    }
}
