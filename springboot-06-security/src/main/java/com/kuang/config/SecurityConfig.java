package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只能对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //配置一下没有权限就默认跳到登录页面,需要开启登录的页面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login").usernameParameter("user").passwordParameter("pwd");//定制登陆页：loginPage("/toLogin")

        //开启注销功能
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能。cookie,默认保存两周
        http.rememberMe().rememberMeParameter("remember");//接收前端传来的参数
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据原本是应该从数据库中读取的，现在从内存中读
        auth.inMemoryAuthentication().passwordEncoder(new Pbkdf2PasswordEncoder())
                .withUser("kuangshen").password(new Pbkdf2PasswordEncoder().encode("123456")).roles("vip1", "vip3")
                .and()
                .withUser("root").password(new Pbkdf2PasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("guest").password(new Pbkdf2PasswordEncoder().encode("123456")).roles("vip1");
    }
}
