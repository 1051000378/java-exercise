package com.xiaoqu;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void insert(User user);

    int update(User user);

    int delete(User user);

    int count(User user);

    List<User> getList(User user);

    User getUser(User user);

    void batchAddUser(List<Object[]> batchArgs);





}
