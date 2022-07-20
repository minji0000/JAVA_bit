package com.kari.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// url 주소에서 간단하게 치고 들어오려고 만드는 컨트롤러
@Controller
public class IndexController {
    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }
}
