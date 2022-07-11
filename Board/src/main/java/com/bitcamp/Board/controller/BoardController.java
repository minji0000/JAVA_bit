package com.bitcamp.Board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.Board.model.BoardDTO;
import com.bitcamp.Board.model.UserDTO;
import com.bitcamp.Board.service.BoardService;
import com.bitcamp.Board.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	@RequestMapping("/showAll")
	public String showFirstPage() {
		return "redirect:/board/showAll/1";
	}
	
	@RequestMapping("/init")
	public String insertAll() {
		for(int i = 1; i<= 100; i++) {
			BoardDTO b = new BoardDTO();
			b.setWriterId(91);
			b.setTitle("제목" +i);
			b.setContent("내용" + i + "입니다 ! !");
			boardService.insert(b);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/showAll/{pageNo}")
	public String showAll(Model model, HttpSession session, @PathVariable int pageNo) {
		UserDTO logIn = (UserDTO) session.getAttribute("logIn");
		if(logIn == null) {
			return "redirect:/";
		}
		
		
		List<BoardDTO> list = boardService.selectAll(pageNo);
	
		
		// showAll에서 작성자 닉네임 주르륵 띄워주기
		
		HashMap<Integer, String> nicknameMap = new HashMap<>();
		for(BoardDTO b : list) {
			nicknameMap.put(b.getWriterId(),
					userService.selectOne(b.getWriterId()).getNickname());
		}
		
		model.addAttribute("list", list);
		model.addAttribute("nicknameMap", nicknameMap);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("lastPageNo", boardService.selectLastPage());
		
		return "/board/showAll";
	}
	
	@RequestMapping("/selectOne/{id}") 
	public String selectOne(@PathVariable int id, HttpSession session, Model model) {
		
		//로그인이 제대로 되어있는지
		if(session.getAttribute("logIn") == null ) {
			return "redirect:/";
		}
		
		//글도 존재하는 번호인지
		BoardDTO b = boardService.selectOne(id);
		if(b == null) {
			return "redirect:/board/showAll";
		}
		
		model.addAttribute("b", b);
		model.addAttribute("nickname", userService.selectOne(b.getWriterId()).getNickname());
		UserDTO logIn = (UserDTO) session.getAttribute("logIn");
		model.addAttribute("logInId", logIn.getId());
	
		return "board/showOne";
	}
	
	
	
}
