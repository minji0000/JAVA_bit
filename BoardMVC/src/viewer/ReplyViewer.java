package viewer;

import connector.DBConnerctor;
import controller.ReplyController;
import controller.UserController;
import model.ReplyDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ReplyViewer {
    private Scanner scanner;
    private DBConnerctor connerctor;
    private UserDTO logIn;


    public ReplyViewer(Scanner scanner, DBConnerctor connerctor, UserDTO logIn) {
        this.scanner = scanner;
        this.connerctor = connerctor;
        this.logIn = logIn;
    }

    public void printList(int BoardId) {
        ReplyController replyController = new ReplyController(connerctor);
        ArrayList<ReplyDTO> list = replyController.selectAll(BoardId);

        if(list.isEmpty()) {
            System.out.println("아직 작성된 댓글이 없습니다.");
        } else {
            UserController userController = new UserController(connerctor);
            for(ReplyDTO r : list) {
                System.out.printf("%s: %s\n", userController.seleteOne(r.getWriterId()).getNickname(), r.getContent());
            }
        }
    }

    public void write(int boardId) {
        ReplyDTO r = new ReplyDTO();
        r.setWriterId(logIn.getId());
        r.setBoardId(boardId);
        // ??

        r.setContent(ScannerUtil.nextLine(scanner, "댓글 내용을 입력해주세요."));
        ReplyController controller = new ReplyController(connerctor);
        controller.insert(r);
    }
}
