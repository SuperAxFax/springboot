package com.kaung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    //配置swagger中docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("fax");
    }

    //配置swagger文档信息apiInfo
    private ApiInfo apiInfo(){

        //缺什么就new什么
        //作者信息
        Contact contact = new Contact("fax", "www.superax.top", "165496165@qq.com");
        return new ApiInfo(
                "SuperAx的swagger日志",
                "即使再小的帆也能远航",
                "v1.0",
                "www.superax.top",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fax1");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fax2");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fax3");
    }

}
