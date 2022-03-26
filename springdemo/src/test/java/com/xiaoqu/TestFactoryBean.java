package com.xiaoqu;

import com.xiaoqu.demo1.Course;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class TestFactoryBean {

    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);


    }

}
