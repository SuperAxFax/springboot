package com.kuang;

import com.kuang.pojo.Dog;
import com.kuang.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    //@Autowired是一种注解，可以对成员变量，方法和构造函数进行标注，来完成自动装配的工作。
    //@Autowired是根据类型进行自动装配的，如果需要按名称进行装配，需要配合@Qualifier使用。
    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        //{name='fax',
        // age=18,
        // happy=true,
        // date=Sat Apr 16 00:00:00 CST 2022,
        // map={k1=v1, k2=v2},
        // lists=[code, music, girl],
        // dog=Dog{name='旺财', age=3}}
        System.out.println(person);
    }

}
