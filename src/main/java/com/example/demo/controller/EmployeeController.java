package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Author Shinelon
 * @Date 2020/11/26 16:45
 * @Version 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

//    员工页面
    @RequestMapping("/employee")
    public String getEmployeeList(Model model) {
        Collection<Employee> employees = employeeDao.queryEmployee();
        model.addAttribute("emps", employees);
        return "employeeList";
    }

//    请求添加员工页面
    @RequestMapping("/addEmployee")
    public String addEmployee(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "addEmployee";
    }

//    添加员工
    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

//    修改员工
    @RequestMapping("/toQueryPage")
    public String getEmployeeById(Integer id,Model model){
        System.out.println("id："+id);
        Employee employee = employeeDao.queryEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("employee",employee);
        return "editEmployee";
    }
}
