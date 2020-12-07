package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author Shinelon
 * @Date 2020/12/7 15:19
 * @Version 1.0
 */
@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

//    查询
    @RequestMapping("/bookList")
    public List<Map<String,Object>> bookList(){
        String sql = "select * from books";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

//    删除
    @RequestMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable int id){
        String sql = "delete from books where bookID=?";
        jdbcTemplate.update(sql,id);
        return "delete OK!";
    }

//    修改
    @RequestMapping("/updateBook/{id}")
    public String updateBookById(@PathVariable int id){
        String sql = "update books set bookName = ?,detail = ? where bookID="+id;
        Object[] objects = new Object[2];
        objects[0]="核心技术123";
        objects[1]="卷2";
        jdbcTemplate.update(sql,objects);
        return "delete OK!";
    }

//    增加
    @RequestMapping("/addBook")
    public String addBook(){
        String sql = "insert into books(bookID,bookName,bookCounts,detail) values (5,'Java核心技术',19,'卷一')";
        jdbcTemplate.update(sql);
        return "addBook OK!";
    }
}
