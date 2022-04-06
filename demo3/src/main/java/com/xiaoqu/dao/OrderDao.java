package com.xiaoqu.dao;

import com.xiaoqu.entity.Order;

public interface OrderDao {

    int createOrder(Order order);

    void updateOrderStatus(String orderId, Integer status);

}
