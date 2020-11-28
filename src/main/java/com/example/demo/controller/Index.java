package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Shinelon
 * @Date 2020/11/23 14:50
 * @Version 1.0
 */
@Controller
public class Index {
    @RequestMapping({"/index.html","/"})
    public String toIndex(Model model){
        return "index";
    }
}
