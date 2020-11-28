package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author Shinelon
 * @Date 2020/11/25 15:58
 * @Version 1.0
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String loginIn(@RequestParam("username") String name, @RequestParam("password") String pwd, HttpSession session, Model model) {
        if ("admin".equals(name) && "admin".equals(pwd)) {
            session.setAttribute("username", name);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码不正确！");
            return "index";
        }
    }

}
