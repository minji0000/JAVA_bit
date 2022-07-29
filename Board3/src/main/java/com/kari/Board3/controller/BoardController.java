package com.kari.Board3.controller;

import com.kari.Board3.model.BoardDTO;
import com.kari.Board3.model.UserDTO;
import com.kari.Board3.service.BoardService;
import com.kari.Board3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;

    @Autowired
    private ReplyController replyController;


    @RequestMapping("/selectAll")
    private String showFirstPage() {
        return "redirect:/board/showAll/1";
    }

    @RequestMapping("/showAll/{pageNo}")
    private String showAll(Model model, HttpSession session, @PathVariable int pageNo) {

        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        if( logIn == null) {
            return "redirect:/";
        }

        List<BoardDTO> list = boardService.selectAll(pageNo);

        // 작성자 닉네임 보여주려고 쓰는 코드
        HashMap<Integer, String> nicknameMap = new HashMap<>();
        for (BoardDTO b : list) {
            nicknameMap.put(b.getWriterId(), userService.selectOne(b.getWriterId()).getNickname());
        }

        // 중간 매개체 느낌 (디비-뷰 통신 가능)
        // 디비에 매핑 가능, 값 가져오고 넣는 게 가능 !
        model.addAttribute("list", list);
        model.addAttribute("nicknameMap", nicknameMap);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("lastPageNo", boardService.selectLastPage());


        return "/board/showAll";
    }

    @RequestMapping("/empty/{pageNo}")
    private String emptyCheck(@PathVariable int pageNo, Model model) {
        int emptyCheck = boardService.emptyCheck(pageNo);

        if(emptyCheck == 0) {
            model.addAttribute("emptyPage", pageNo);
        } else {
            model.addAttribute("lastPageNo", boardService.selectLastPage());
        }

        return "/board/showAll";
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET)
    private String register() {
        return "/board/write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    private String writeLogic(@RequestParam MultipartFile image,
                              BoardDTO b, HttpSession session) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        if (logIn == null) {
            return "redirect:/";
        }

        String path = "/Applications/Project_Spring/Board3/src/main/webapp/static/img/";

        b.setWriterId(logIn.getId());
        b.setTitle(b.getTitle());
        b.setContent(b.getContent());


        try {
            image.transferTo(new File(path + image.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(image != null) {
            b.setImageFileName(image.getOriginalFilename());
        }

        boardService.insert(b);

        return "redirect:/board/selectAll";

    }

    @RequestMapping("/showOne/{id}")
    public String selectOne(@PathVariable int id, HttpSession session, Model model) {

        // 로그인이 제대로 되어있는지
        if (session.getAttribute("logIn") == null) {
            return "redirect:/";
        }

        // 글도 존재하는 번호인지
        BoardDTO b = boardService.selectOne(id);
        if (b == null) {
            return "redirect:/board/showAll";
        }

        model.addAttribute("b", b);
        model.addAttribute("nickname", userService.selectOne(b.getWriterId()).getNickname());

        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        model.addAttribute("logInId", logIn.getId());

        replyController.showAll(id, model);

        return "board/showOne";
    }



    @RequestMapping("/init")
    public String insertAll() {
        for (int i = 1; i <= 73; i++) {
            BoardDTO b = new BoardDTO();
            b.setWriterId(6);
            b.setTitle("제목" + i);
            b.setContent("내용" + i + "입니다 ! !");
            b.setViews(0);
            b.setGood(0);

            boardService.init(b);
        }
        return "redirect:/";
    }

}
