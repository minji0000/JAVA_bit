package bitcamp_may_19;

public class fishSeries extends animal{

    int fin;
    float swim;

    public void SetFin(int int1){
        fin = int1;
    }

    public int GetFin( ) {
        return fin;
    }

    public void PutFin( ) {
        System.out.println("나의 지느러미 갯수는 " + fin);
    }

    public void SetSwim(float float1) {
        swim = float1;
    }

    public float GetSwim() {
        return swim; }

    public void PutSwim() {
        System.out.println("나는 " + swim + "의 속도로 헤엄칠 수 있어!");
    }
    //액션
    public void Swimming(int a) {
        Object SwimSpeed;
        System.out.println("헤엄치는 중");
    };

    public void Eating() {
        System.out.println("먹는중");
    };

}
