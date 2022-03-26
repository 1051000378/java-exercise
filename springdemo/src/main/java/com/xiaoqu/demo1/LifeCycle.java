package com.xiaoqu.demo1;

public class LifeCycle {

    private String name;

    public LifeCycle(){
        System.out.println("第一步，创建无参数的对象");
    }


    public void setName(String name){
        this.name = name;
        System.out.println("第二步，属性的注入");
    }

    public void initMethod(){
        System.out.println("第三步，初始化方法");
    }

    public void destroyMethod(){
        System.out.println("第五步，容器关闭，调用销毁方法");
    }


}
