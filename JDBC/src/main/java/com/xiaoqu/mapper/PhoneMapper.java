package com.xiaoqu.mapper;

import com.xiaoqu.Phone;

import java.util.List;

public interface PhoneMapper {
    //查询所有
    List<Phone> selectAll();
    //根据名称查询
    Phone selectByName();

    //添加手机
    void insert(String name,int price,String color);

    //删除手机
    void delete(String name);



}
