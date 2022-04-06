package com.xiaoqu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextApplication.xml");
        Student stu = (Student) context.getBean("student");
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getGender());


    }
}
