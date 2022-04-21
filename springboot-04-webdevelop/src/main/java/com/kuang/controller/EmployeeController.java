package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emplo",employees);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门的名称以供选择框使用
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emps/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        System.out.println("save=>"+employee);
        employeeDao.add(employee);//调用底层业务方法保存员工信息
        return "redirect:/emps";
    }

 /*   //去员工的修改页面
    @RequestMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        //查出来的数据
        System.out.println("进入该方法");
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        return "emps/update";
    }*/
    /*@GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }*/
}
