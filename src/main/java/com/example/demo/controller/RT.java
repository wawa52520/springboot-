package com.example.demo.controller;

import javax.servlet.http.HttpServlet;
import java.sql.DriverManager;

/**
 * @Author Shinelon
 * @Date 2020/11/19 17:32
 * @Version 1.0
 */
public class RT {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("max:"+maxMemory+","+maxMemory/1024/1024+"MB");
        System.out.println("total:"+totalMemory+","+totalMemory/1024/1024+"MB");
        System.out.println("===========================================");
        System.out.println(Runtime.getRuntime().availableProcessors());
        Thread thread = new Thread();
//        DriverManager
    }
}
