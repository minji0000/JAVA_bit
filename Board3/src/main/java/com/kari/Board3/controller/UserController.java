package com.kari.Board3.controller;

import com.kari.Board3.model.UserDTO;
import com.kari.Board3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String logIn(String username, String password, HttpSession session) {
        UserDTO u = new UserDTO();
        u.setUsername(username);
        u.setPassword(convertSha2(password));

        u = userService.auth(u);

        if(u != null) {
            session.setAttribute("logIn", u);

            return "redirect:/board/selectAll";
        }

        return "redirect:/";
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

    @RequestMapping("/register")
    private String register() {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private String registerLogic(UserDTO u) {
        u.setPassword(convertSha2(u.getPassword()));
        userService.register(u);

        return "redirect:/";
    }



}
