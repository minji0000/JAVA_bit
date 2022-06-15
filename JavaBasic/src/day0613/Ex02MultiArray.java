package day0613;
// 다중배열
// 배열도 하나의 데이터 타입이기 때문에 다른 배열 안에 포함될 수 있다.

public class Ex02MultiArray {
    public static void main (String [] args) {
        // 다중 배열의 경우, 해당 배열이 총 몇 개의 배열이 모여있는지 반드시 *** 적어주어야 한다.\! ***

        // 만약 3칸짜리 int 배열이 4개 모여있는 2차원 배열이면 다음과 같이 적어준다.
        int[][] array = new int[4][3];

        // array의 1번째 배열의 2번째 칸에 30을 넣으려면 다음과 같이 적는다.
        array[1][2] = 30;

        // 위에처럼 각 1차원 배열의 크기가 고정된 것이 아니라
        // 서로 다른 길이의 1차원 1차원 배열이 모여있을 때는
        // 다음과 같이 초기화를 거쳐야 한다.

        // 1. 1차원 배열이 총 몇 개 모여있는지를 결정하여 초기화 해준다.

        array = new int[4][];

        // 해당 2차원 배열의 0번째 배열부터 차례대로 몇 칸짜리 1차원 배열인지 적어준다.
        array[0] = new int[3];
        array[1] = new int[4];
        array[2] = new int[2];
        array[3] = new int[6];

        System.out.println("array.length: " + array.length);
        System.out.println("array[0].length: " + array[0].length);
        System.out.println("array[0].length: " + array[1].length);
        System.out.println("array[0].length: " + array[2].length);
        System.out.println("array[0].length: " + array[3].length);

    }
}
