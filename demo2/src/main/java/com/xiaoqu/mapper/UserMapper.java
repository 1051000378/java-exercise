package com.xiaoqu.mapper;

import com.xiaoqu.bean.User;

import java.util.List;

public interface UserMapper {

//    增加
    int add(User user);

//    查询
    List<User> selectAll();
//    按名称查询
    User selectByName(String name,String password);
//    删除
    int delectByName(String name);
//    更新
    int update(String name);

}
