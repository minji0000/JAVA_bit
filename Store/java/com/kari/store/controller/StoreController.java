package com.kari.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @RequestMapping("/selectAll")
    public String selectAll() {
        return "/store/store";
    }

    @RequestMapping("/beauty")
    public String showBeauty() {
        return "/store/beauty";
    }

}
