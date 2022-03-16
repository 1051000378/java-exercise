package com.xiaoqu.factory;

import com.xiaoqu.dao.UserDao;
import com.xiaoqu.dao.impl.UserDaoImpl;

public class StaticFactoryBean {

    //工厂的静态方法返回bean实例
    public static UserDao createUserDao(){
        return new UserDaoImpl();
    }

}
