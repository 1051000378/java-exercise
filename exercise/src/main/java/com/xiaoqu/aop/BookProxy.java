package com.xiaoqu.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookProxy {

    @Before(value = "point()")
    public void before(){
        System.out.println("在方法执行前执行....");
    }

    @After(value = "point()")
    public void after(){
        System.out.println("在方法执行后执行......");
    }

    @Pointcut(value = "execution(* com.xiaoqu.aop.Book.add(..))")
    public void point(){

    }

}
