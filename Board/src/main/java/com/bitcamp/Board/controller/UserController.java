package com.bitcamp.Board.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.Board.model.UserDTO;
import com.bitcamp.Board.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// 이거 왜 쓰는 거더라 ..?
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/selectAll")
	public String selectAll(Model model) {
		model.addAttribute("list", userService.selectAll());
		
		return "user/showAll";
	}
	
	@RequestMapping(value = "/logIn", method = RequestMethod.POST)	
	//포스트 방식으로 받아올 
	public String logIn(String username, String password, HttpSession session) {
		UserDTO u = new UserDTO();
		u.setUsername(username);
		u.setPassword(convertSha2(password));
		
		u = userService.auth(u);
		
		if(u != null) {
			session.setAttribute("logIn", u);
			return "redirect:/board/showAll";
		}
		
		System.out.println(u);
		//특정 경로(url)로 이동 시 redirect 사용, 특정 페이지(파일)를 로딩해야한다 그러면 안 써도 돼 안 쓰고 싶으면 index 라고 써주면 돼(근데 경로 다 써줘야함)
		
		return "redirect:/";
	}
	
	@RequestMapping("/selectOne/{id}")
	public String selectOne(@PathVariable int id) {
		System.out.println(id);
		
		return "/index.html";	
	}
	
	private String convertSha2(String password) {
		String converted = null;
        StringBuilder builder = null;
		
		try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // 암호화해주는 클래스
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            builder = new StringBuilder();

            for(int i = 0; i <hash.length; i++) {
                builder.append(String.format("%02x", 255 & hash[i]));
            }

            converted = builder.toString();

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    return converted;

	}
	
	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
		
	}
	
	
	// 필드명이랑 input 안에 이름이 같으면 알아서 들어감
	@RequestMapping (value = "/register", method = RequestMethod.POST)
	//객체를 파라미터로 넣어주면 스프링이 알아서 해줘
	public String registerLogic(UserDTO u) {
		u.setPassword(convertSha2(u.getPassword()));
		userService.register(u);
		
		return "redirect:/";
	}
	
	

	
}
