package com.kari.store.controller;

import com.kari.store.model.UserDTO;
import com.kari.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping (value = "/register", method = RequestMethod.GET)
    public String register() {
        return "user/register";
    }

    @RequestMapping(value = "/member_register", method = RequestMethod.POST)
    public String member_register(UserDTO u) {
        u.setName(u.getName());
        u.setUsername(u.getUsername());
        u.setPassword(convertSha2(u.getPassword()));
        u.setNumber(u.getNumber());
        u.setAddress(u.getAddress());
        u.setGrade(2);

        userService.register(u);

        return "redirect:/";
    }

    @RequestMapping(value = "/seller_register", method = RequestMethod.POST)
    public String seller_register(UserDTO u ) {
        u.setName(u.getName());
        u.setUsername(u.getUsername());
        u.setPassword(convertSha2(u.getPassword()));
        u.setNumber(u.getNumber());
        u.setAddress(u.getAddress());
        u.setGrade(3);

        userService.register(u);

        return "redirect:/";
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.GET)
    public String logIn() {
        return "user/logIn";
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String logInLogic(String username, String password, HttpSession session) {
        UserDTO u = new UserDTO();
        u.setUsername(username);
        u.setPassword(password);

        u = userService.auth(u);

        if(u != null) {
            session.setAttribute("logIn", u);
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/sample")
    public String sample() {
        return "user/sample";
    }

    @RequestMapping(value = "/plz")
    public String plz() {
        return "user/plz";
    }



    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile image) {

        String path = "/Applications/Project_Spring/Store/src/main/webapp/static/img/";

        try {
            image.transferTo(new File(path + image.getOriginalFilename()));

        } catch (IOException e) {
            throw new RuntimeException(e);
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







}
