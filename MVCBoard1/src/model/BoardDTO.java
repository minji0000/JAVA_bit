package model;
// 모델
// 모델 클래스들은 데이터의 틀을 담당하는 클래스이다.
// 모델 클래스 안에는 어떤 데이터가 저장이 될지(=필드),
// 겟터, 셋터 그리고 java.lang.Object의 오버라이드할 메소드만 들어가게 된다.

// 값을 객체의 형태로 바꿔주는 놈들만 들어간다.

// DTO VS VO
// DTO : Data Transfer Object : 데이터 전송 객체 ->
// 데이터베이스로부터 받은 데이터를 객체에 담아서 사용자에게 보낼줄 때 쓰는 틀
// + 사용자가 입력한 데이터를 객체에 담아서 데이터베이스로 보내줄 때 쓰는 틀

//Value Object :  값 객체 -> 데이터베이스로부터 받은 데이터를 객체에 담아서 사용자에게 보내줄 때 쓰는 틀

public class BoardDTO {
    //필드
    private int id;
    private String title;
    private String content;
    private int writerId;


    //getter / setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    //생성자
    public BoardDTO(){
    }

    public BoardDTO(int id){ //id값만 가지는 생성자
        this.id = id;
    }

    public BoardDTO(BoardDTO origin){ //깊은 복사용 생성자
        this.id = origin.id;
        this.title = origin.title;
        this.writerId = origin.writerId;
        this.content = origin.content;
    }

    //오버라이드
    public boolean equals(Object o){
        if(o instanceof BoardDTO){
            BoardDTO b = (BoardDTO) o;
            return this.id == b.id; //b.id = 힙에서 id의 값을 가져온다.
            // 둘다 힙영역에 있는 id의 실제 데이터를 비교하는 것
            // this.id는 해당 메소드를 실행시키는 주체의 id
        }
        return false;
    }
}
