package com.xiaoqu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void add(User user){
        userDao.insert(user);
    }

    public int updateUser(User user){
        return userDao.update(user);
    }

    public int deleteUser(User user){
        return userDao.delete(user);
    }

    public int countUser(User user){
        return userDao.count(user);
    }

    public List<User> getUserList(User user){
        return userDao.getList(user);
    }

    public User getUser(User user){
        return userDao.getUser(user);
    }

    public void batchAddUser(List<Object[]> batchArgs){
        userDao.batchAddUser(batchArgs);
    }

}
