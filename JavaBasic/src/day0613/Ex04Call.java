package day0613;
//Call By Value vs Call By Reference
// Call By Value : 값에 의한 호출
// 우리가 메소드의 파라미터로 기본형 데이터 타입을 설정할 경우
// 특정값을 넘겨줄 때 스택 영역에서의 복사가 일어나서 값이 넘겨진다.
// 즉, 실제 값 자체가 복사돼서 넘어가게 되어
// 우리가 해당 메소드에서 값을 바꾸더라도, 원본의 값이 바뀌는 것이 아니라
// 해당 메소드 내부에서만 복사된 값이 변경되므로, 원본은 변경되지 않는다.

// Call By Reference
// 참조에 의한 호출은, 실제 값이 아니라
// 실제 값이 저장된 주소값이 전달된다.
// 따라서, 우리가 새로운 주소값을 부여하지 않는 경우에는
// 해당 메소드에서 변경된 값이 그대로 원본에도 반영이 된다.

public class Ex04Call {
    public static void main(String[] args) {
        int number = 3;
        System.out.println("increaseVal() 실행 전 number의 현재 값: " + number);
        increaseVal(number);
        System.out.println("increaseVal() 실행 후 number의 현재 값: " + number);

        int[] array = new int[3];
        array[0] = 4;
        array[1] = 5;
        array[2] = 6;
        System.out.println("increaseVal() 실행 전 array[0]의 현재 값: " + array[0]);
        increaseVal(array);
        System.out.println("increaseVal() 실행 후 array[0]의 현재 값: " + array[0]);


    }

    public static void increaseVal(int num) {
        num ++;
    }

    public static void increaseVal(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }
}
