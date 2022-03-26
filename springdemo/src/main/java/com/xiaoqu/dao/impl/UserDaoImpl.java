package com.xiaoqu.dao.impl;

import com.xiaoqu.dao.UserDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDao save method running......");
    }



    @Test
    public void test1(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        userDao.save();




    }


}
