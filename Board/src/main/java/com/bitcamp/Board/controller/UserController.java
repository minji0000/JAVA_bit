package com.bitcamp.Board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.Board.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/selectAll")
	public String selectAll(Model model) {
		model.addAttribute("list", userService.selectAll());
		
		return "user/showAll";
	}
	
	@RequestMapping(value = "/logIn", method = RequestMethod.POST)	
	//포스트 방식으로 받아올 
	public String logIn(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		
		return "";
	}
	
	@RequestMapping("/selectOne/{id}")
	public String selectOne(@PathVariable int id) {
		System.out.println(id);
		
		return "/index.html";	
	}

	
}
