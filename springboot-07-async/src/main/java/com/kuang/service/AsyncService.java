package com.kuang.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncService {
    //这样的话用户的体验不好。因此要告诉Spring这是一个异步的方法。
    @Async//只要加上它，一运行就会帮我们开启一个线程池
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理。。。");
    }
}
