package day0616;

public class Student2 {
    //필드
    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;
    private final int SUBJECT_SIZE = 3;

    //메소드


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSUBJECT_SIZE() {
        return SUBJECT_SIZE;
    }

    private int calculateSum() {
        return korean + english + math;
    }

    private double calculateAverage() {
        return (double)calculateSum() / SUBJECT_SIZE; // 타입캐스팅
    }

    // 생성자
    // 1. 파라미터 있는 생성자
    public Student2(int id, String name, int korean, int english, int math) {

        this.id = id;
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    //2. 파라미터 없는 생성자
    public Student2() {
        id = -1;
        name = "아직 입력 안 됐어요";
        korean = -1;
        english = -1;
        math = -1;
    }

    //3. equals() 오버라이드   - Object가 상속해주는 메소드
    // 클래스를 상속받는 다른 자식 클래스도 파라미터로 쓸 수 있음
    // ** 모든 클래스 객체들이 다 들어올 수 있다

    // 같은 클래스인지 인스턴스인지 확인
    public boolean equals(Object o) {
        // 먼저 파라미터로 들어온 Object 객체가
        // 실체화가 끝난
        // 즉, Student 클래스의 인스턴스인지를
        // instanceof라는 키워드를 통해 체크하여 맞으면 추가적인 코드를 진행한다.
        if(o instanceof Student) { // o가 Student의 인스턴스인지 아닌지 건물이 3층 아파트인지 아닌지 확인
            Student s = (Student) o; //Object에는 int 타입의 id가 없으므로 형변환 해줌 여기는 // 잠시 건물 a라고 부를게여
            return id == s.id; // 두 건물의 아이디값이 같은지 확인 s1.equlas(s2)
        }
        return false;
    }

    //4. 정보 출력용 메소드
    public void printInfo() {
        System.out.printf("번호: %d번 이름: %s\n" , id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점:  %03d점 평균: %06.02f점\n", calculateSum(), calculateAverage());
    }

    public String toString() {
        return "id: " + id +
                ", name: " + name +
                ", korean: " + korean
                + ", english: " + english
                + ",math: " + math;
    }

}
