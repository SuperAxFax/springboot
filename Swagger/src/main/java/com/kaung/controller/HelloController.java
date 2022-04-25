package com.kaung.controller;

import com.kaung.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，它就会被扫描到Swagger中
    @ApiOperation("Hello控制类")
    @PostMapping("/user")
    public User user(){
        return new User();
    }


    @ApiOperation("Hello控制类")
    @PostMapping("/userfax")
    public String hellofax(@ApiParam("用户名") String username){
        return "hello"+ username;
    }
}
