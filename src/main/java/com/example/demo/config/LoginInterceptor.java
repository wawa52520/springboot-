package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Shinelon
 * @Date 2020/11/25 22:37
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username==null){
//            request.setAttribute("msg","请先登录");
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
            return true;
        }
        else
            return true;
    }
}
