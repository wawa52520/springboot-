package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Shinelon
 * @Date 2020/11/24 10:42
 * @Version 1.0
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","AA@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","BB@qq.com",1,new Department(102,"督查部")));
        employees.put(1003,new Employee(1003,"CC","CC@qq.com",0,new Department(103,"财务部")));
        employees.put(1004,new Employee(1004,"DD","DD@qq.com",1,new Department(104,"管理部")));
    }

    private static Integer initId =1005;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employee.setDate(new Date());
        employees.put(employee.getId(),employee);
    }

    public void deleteById(Integer id){
        employees.remove(id);
    }

    public Collection<Employee> queryEmployee() {
        return employees.values();
    }
    public Employee queryEmployeeById(Integer id){
        return employees.get(id);
    }

}
