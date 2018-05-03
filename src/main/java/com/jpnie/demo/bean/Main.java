package com.jpnie.demo.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by njp on 18/5/3.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
        User user = (User) ac.getBean("test");
        System.out.println(user.toString());
    }
}
