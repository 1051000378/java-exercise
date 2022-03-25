package com.xiaoqu.demo1;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service is running...");
        userDao.update();
    }

}
