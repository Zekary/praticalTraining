package com.Test;

import com.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //1、获取Ioc容0器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //2、在IOC容器中获取Javabean【对象】
        User user = (User) context.getBean("nowUser");
        //
        System.out.println(user);
    }
}