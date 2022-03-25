package com.xiaoqu.annotation;


import org.springframework.stereotype.Component;

@Component
public class BookDao {

    public void addDao(){
        System.out.println("Dao add ......");
    }
}
