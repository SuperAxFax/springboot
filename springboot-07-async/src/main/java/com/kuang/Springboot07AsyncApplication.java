package com.kuang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync//开启异步注解功能
@EnableScheduling//开启定时功能的注解
@SpringBootApplication
public class Springboot07AsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot07AsyncApplication.class, args);
    }

}
