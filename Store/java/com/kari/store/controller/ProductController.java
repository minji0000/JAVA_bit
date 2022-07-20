package com.kari.store.controller;

import com.kari.store.model.ProductDTO;
import com.kari.store.model.UserDTO;
import com.kari.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "product/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerLogic(ProductDTO p, HttpSession session) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        p.setName(p.getName());
        p.setSellerId(logIn.getId());
        p.setKind(p.getKind());
        p.setPrice(p.getPrice());
        p.setContent(p.getContent());

        productService.register(p);

        return "redirect:/user/seller";
    }

    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public String registerLogic2(ProductDTO p, HttpSession session, @RequestParam MultipartFile image) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        if(logIn == null) {
            return "redirect:/";
        }

        String path = "/Applications/Project_Spring/Store/src/main/webapp/static/product/";

        p.setName(p.getName());
        p.setSellerId(logIn.getId());
        p.setKind(p.getKind());
        p.setPrice(p.getPrice());
        p.setContent(p.getContent());

        try {
            image.transferTo(new File(path + image.getOriginalFilename()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //isEmpty 랑은 다른거야//
       if(image != null) {
            p.setImageFileName(image.getOriginalFilename());
        }

        productService.register2(p);

        return "redirect:/user/seller";
    }

    @RequestMapping("/showBeauty")
    public String showBeauty(Model model, HttpSession session) {
        List<ProductDTO> list = productService.selectAll();
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");

        if( logIn == null) {
            return "redirect:/";
        }

        model.addAttribute("list", list);

        return "/store/beauty";
    }





}
