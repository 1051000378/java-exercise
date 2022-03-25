package com.xiaoqu;

import com.xiaoqu.demo1.LifeCycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class TestLifeCycle {

    @Test
    public void testLifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LifeCycle lifeCycle = context.getBean("lifeCycle", LifeCycle.class);
        System.out.println("第四部 获取创建bean的实例对象");
        System.out.println(lifeCycle);
//        手动让bean实例销毁
        context.close();
    }

}
