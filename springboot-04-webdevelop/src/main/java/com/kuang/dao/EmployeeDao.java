package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工所属部门
    @Autowired//可以自动跳转到DepartmentDao
    private DepartmentDao departmentDao;

    static {
        //创建一个部门表
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"AA","21212214@qq.com",0,new Department(101,"后勤部")));
        employees.put(1002,new Employee(1002,"BB","45449846566@qq.com",1,new Department(102,"安保部")));
        employees.put(1003,new Employee(1003,"CC","54813545@qq.com",0,new Department(103,"市场部")));
        employees.put(1004,new Employee(1004,"DD","65412216513@qq.com",1,new Department(104,"调研部")));
        employees.put(1005,new Employee(1005,"EE","6546115466@qq.com",0,new Department(105,"后勤部")));
    }

    //增加一个员工
    //实现主键自增
    private static Integer  initId = 1006;
    public void add(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentsById(employee.getDepartment().getId()));
        /*employee.setBirth(new Date());*/
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public  Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
