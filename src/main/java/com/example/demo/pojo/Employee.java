package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Shinelon
 * @Date 2020/11/24 10:38
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    Integer id;
    String lastName;
    String email;
    Integer gender;
    Department department;
    Date date;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.date = new Date();
    }
}
