package com.example.demo.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author Shinelon
 * @Date 2020/11/25 15:05
 * @Version 1.0
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String parameter = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(parameter)){
            String[] strings = parameter.split("_");
            locale = new Locale(strings[0],strings[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
