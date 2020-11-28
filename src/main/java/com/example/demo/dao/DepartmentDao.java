package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Shinelon
 * @Date 2020/11/24 10:41
 * @Version 1.0
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> deprecatedMap = null;
    static {
        deprecatedMap = new HashMap<>();
        deprecatedMap.put(101,new Department(101,"教学部"));
        deprecatedMap.put(102,new Department(102,"督查部"));
        deprecatedMap.put(103,new Department(103,"财务部"));
        deprecatedMap.put(104,new Department(104,"管理部"));
    }

    public Collection<Department> getDepartments(){
        return deprecatedMap.values();
    }

    public Department getDepartmentById(Integer id){
        return deprecatedMap.get(id);
    }
}
