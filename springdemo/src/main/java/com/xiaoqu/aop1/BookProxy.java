package com.xiaoqu.aop1;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect  //生成代理对象
@Order(1) //多个增强类用同一个方法进行增强，设置增强类的优先级，值越小优先级越高
public class BookProxy {
//    前置通知
//    @Before(value = "execution(* com.xiaoqu.aop1.Book.add(..))")
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before......");
    }
//    后置通知
//    @AfterReturning(value = "execution(* com.xiaoqu.aop1.Book.add(..))")
    @AfterReturning(value = "pointDemo()")
    public void afterReturning(){
        System.out.println("afterRunning......");
    }
//    最终通知
//    @After(value = "execution(* com.xiaoqu.aop1.Book.add(..))")
    @After(value = "pointDemo()")
    public void after(){
        System.out.println("after......");
    }
//    异常通知
//    @AfterThrowing(value = "execution(* com.xiaoqu.aop1.Book.add(..))")
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing(){
        System.out.println("AfterThrowing......");
    }
//    环绕通知 在被增强的方法前后执行
//    @Around(value = "execution(* com.xiaoqu.aop1.Book.add(..))")
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("around之前......");
        //被增强的方法执行
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around之后......");
    }

    //发现我要增强的地方都一样，每个增强方法上都添加被增强的类太麻烦，抽取出来
    @Pointcut(value = "execution(* com.xiaoqu.aop1.Book.add())")
    public void pointDemo(){

    }


}
