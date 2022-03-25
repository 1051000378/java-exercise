package com.xiaoqu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;

    public void add(){
        System.out.println("Service add......");
        userDao.add();
    }


}
