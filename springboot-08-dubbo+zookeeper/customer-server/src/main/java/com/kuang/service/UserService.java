package com.kuang.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //想拿到provider-service提供的票，要去注册中心拿到服务
    @Reference //使用引用，但是我们没有这个接口。解决办法：1：定义路径相同的接口名 2:写pom坐标
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到=》"+ticket);
    }
}
