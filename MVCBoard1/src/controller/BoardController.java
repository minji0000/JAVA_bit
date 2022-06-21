package controller;

import model.BoardDTO;

import java.util.ArrayList;

// 컨트롤러는 데이터베이스로부터 값을 받아서 뷰어에 뿌려줄 값을 객체의 형태로 보내주거나
// 아니면 뷰어에서 입력받은 값을 객체의 형태로 받아서 데이터베이스로 보내주는 일종의 중간다리 역할을 맞는 클래스이다.

// 단, 현재 데이터베이스가 없으므로 유사 데이터베이스 역할 해줄 ArrayList<BoardDTO>를 필드로 하나 가지게 된다.
public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController(){
        list = new ArrayList<>();
        nextId = 1;
    }

    // 뷰어에서 보낸 BoardDTO 객체에 id를 추가한 후에
    // list에 저장하는 insert()
    public void insert(BoardDTO b){
        b.setId(nextId++);
        list.add(b);
    }

    // 뷰어에 출력할 게시글 리스트를 원본에서 딥 카피한 버전을 보내줄
    // selectAll()
    public ArrayList<BoardDTO> sellectAll() {
        ArrayList<BoardDTO> temp = new ArrayList<>();

        for(BoardDTO b : list) {
            temp.add(new BoardDTO(b));
            //깊은 복사된 b객체를 temp에 추가해라
        }
        //그 추가한 temp를 return해
        return temp;
    }

    // 특정 id 값을 가진
    // BoardDTO 객체를 리턴하는 selectOne()
    // 단, 해당 id값이 존재하지 않는다면 null이 리턴된다.

    public BoardDTO selectOne(int id) {

        for(BoardDTO b : list) {
            if(b.getId() == id) {
                return new BoardDTO(b);
                // b와 필드값이 똑같은 새로운 보드디티오 객체가 가지고 있는 주소값을 리턴한다.
            }
        }
        return null;
    }

    // 리스트의 특정 객체를 수정하는
    // update()
    public void update(BoardDTO b) {
        int index = list.indexOf(b);
        list.set(index, b);
    }

    // 리스트의 특정 객체를 삭제하는
    // delete
    public void delete(int id) {
        list.remove(new BoardDTO(id));
    }

    //리스트의 특정 회원의 글을 삭제하는
    //deleteByWriterId()
    public void deleteByWriterId(int writerId) {
        for(int i = 0; i < list.size(); i++) {
            BoardDTO b = list.get(i);
            if(b.getWriterId() == writerId) {
                list.remove(b);
                i = -1;
                //for문을 다시 처음부터 하려고 i를 -1로 만듦 ---> 다음 i++ 돼서 i = 0;
            }
        }
    }

}









