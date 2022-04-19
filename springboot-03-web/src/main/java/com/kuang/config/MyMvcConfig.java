package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /*//public interface ViewResolver 实现了视图解析器接口的类，我们就可以把它看做是视图解析器

    //ViewResolver实现了视图解析器接口的类，我们就可以把它看做视图解析器
    //把自己定义的视图解析器注册到Bean中，这样spring这个大容器就可以直接调用并进行使用。
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //自定义一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }*/

    //如果我们要扩展springmvc，官方建议我们这样去做！
    /*//视图跳转*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/kuang").setViewName("test");
    }
}
