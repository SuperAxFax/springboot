package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot07AsyncApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("小狂神你好呀~");
        mailMessage.setText("谢谢你的狂神说java系列课程");

        mailMessage.setTo("axiangfeng2021@163.com");
        mailMessage.setFrom("axiangfeng2021@163.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("小狂神你好呀~");
        helper.setText("<p style='color:red'>谢谢你的狂神说java系列课程</p>",true);

        //附件
        helper.addAttachment("1.png",new File("H:\\Picture\\风景\\church-6853164.jpg"));

        helper.setTo("axiangfeng2021@163.com");
        helper.setFrom("axiangfeng2021@163.com");

        mailSender.send(mimeMessage);
    }

    //将邮件发送封装成方法，以后见到这些封装好的表示某一具体功能的方法可以直接收集起来

    /**
     *
     * @param html ：true的话表示开启html支持
     * @param subject ：要发送的标题
     * @param text：要发送的正文
     * @throws MessagingException
     */
    public void sendMail(Boolean html,String subject,String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        //正文
        helper.setSubject(subject);
        helper.setText(text,true);

        //附件
        helper.addAttachment("1.png",new File("H:\\Picture\\风景\\church-6853164.jpg"));

        helper.setTo("axiangfeng2021@163.com");
        helper.setFrom("axiangfeng2021@163.com");

        mailSender.send(mimeMessage);
    }

}
