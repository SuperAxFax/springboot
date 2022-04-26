package com.kuang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //cron表达式意思： 秒 分 时 日 月 周几
    @Scheduled(cron = "0 33 22 * * ?")
    public void hello(){
        System.out.println("hello,你被执行了！");
    }
}
