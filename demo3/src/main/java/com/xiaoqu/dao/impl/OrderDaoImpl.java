package com.xiaoqu.dao.impl;

import com.xiaoqu.dao.OrderDao;
import com.xiaoqu.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createOrder(Order order) {
        String sql = "insert into `order`(order_id,user_id,product_id,count,money,status) values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, order.getOrderId(), order.getUserId(), order.getProductId(), order.getCount(), order.getMoney(),order.getStatus());
        return update;
    }

    @Override
    public void updateOrderStatus(String orderId, Integer status) {
        String sql = "update `order` set status=1 where order_id=? and status=?";
        jdbcTemplate.update(sql,orderId,status);
    }
}
