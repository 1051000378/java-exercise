package com.xiaoqu.factory;

import com.xiaoqu.dao.UserDao;
import com.xiaoqu.dao.impl.UserDaoImpl;

public class DynamicFactoryBean {

    public UserDao createUserDao(){
        return new UserDaoImpl();
    }

}
