package com.kari.Board3.controller;

import com.kari.Board3.model.ReplyDTO;
import com.kari.Board3.model.UserDTO;
import com.kari.Board3.service.ReplyService;
import com.kari.Board3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/write/{id}" , method = RequestMethod.POST)
    public String write(Model model, String content, HttpSession session, @PathVariable int id) {
        System.out.println("실행됨");
        ReplyDTO r = new ReplyDTO();
        //  주의할 점은 반환되는 값이 Object형이기 때문에 반드시 적절한 형변환을 해야한다.
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        r.setContent(content);
        r.setWriterId(logIn.getId());
        r.setBoardId(id);

        replyService.insert(r);

        model.addAttribute("replyList", replyService.selectAll(id));

        return "redirect:/board/showOne/" + id;
    }

    @RequestMapping("/showAll")
    public String showAll(@PathVariable int id, Model model){

        List<ReplyDTO> replyList = replyService.selectAll(id);

        HashMap<Integer, String> nicknameMap = new HashMap<>();
        for (ReplyDTO r : replyList) {
            nicknameMap.put(r.getWriterId(), userService.selectOne(r.getWriterId()).getNickname());
        }

        model.addAttribute("replyList", replyList);
        model.addAttribute("nicknameMap", nicknameMap);

        return "/board/showOne";
    }


}
