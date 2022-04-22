package com.kuang.controller;

import com.kuang.mapper.UsersMapper;
import com.kuang.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UsersMapper usersMapper;
    @RequestMapping("/queryUserList")
    public List<Users> queryUserList(){
        List<Users> usersList = usersMapper.queryUserList();
        for (Users users : usersList) {
            System.out.println(users);
        }
        return usersList;
    }

    //添加一个用户
    @RequestMapping("/addUser")
    public String addUser(){
        usersMapper.addUser(new Users(4,"fax","123456","1151654646@qq.com",new Date()));
        return "OK";
    }
    //修改一个用户
    @RequestMapping("/updateUser")
    public String updateUser(){
        usersMapper.updateUser(new Users(4,"fax","12345678","1151654646@qq.com",new Date()));
        return "OK";
    }

    //删除一个用户
    @RequestMapping("/deleteUser")
    public String deleteUser(){
        usersMapper.deleteUser(4);
        return "ok";
    }
}
