package bitcamp_may_19;

public class birdSeries{

    float wingspan;
    float speed;

    public void SetWingSpan(float wingspan){

    }

    public float GetWingSpan( ) {
        return wingspan; }

    public void PutWingSpan( ) {
        System.out.println("나의 날개 길이는 " + wingspan);
    }

    public void SetSpeed() {

    }

    public float GetSpeed(float speed) {
        return speed; }

    public float PutSpeed(float speed) {
        System.out.println("나는 " + speed + "의 속도로 날 수 있어!");
        return speed;
    }

    //액션
    public void Flying() {
        System.out.println("나는 중");
    };

    public void pecking() {
        System.out.println("콕콕콕콕 쪼는 중");
    };

}
