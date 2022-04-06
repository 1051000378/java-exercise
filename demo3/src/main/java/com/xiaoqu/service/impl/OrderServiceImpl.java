package com.xiaoqu.service.impl;

import com.xiaoqu.dao.AccountDao;
import com.xiaoqu.dao.OrderDao;
import com.xiaoqu.dao.StorageDao;
import com.xiaoqu.entity.Account;
import com.xiaoqu.entity.Order;
import com.xiaoqu.entity.Storage;
import com.xiaoqu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,timeout = 10,readOnly = false)
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private StorageDao storageDao;


    @Override
    public void createOrder(Order order) {
//        自动生成订单id
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = df.format(new Date());

        String orderId = order.getUserId()+order.getProductId()+format;
        System.out.println("自动生成订单id为："+orderId);
        order.setOrderId(orderId);
        System.out.println("开始创建订单数据，订单号为："+orderId);
        //创建订单数据
        orderDao.createOrder(order);
        System.out.println("订单数据创建完成，订单号为："+orderId);

        System.out.println("开始查询商品库存，商品id为："+order.getProductId());
        Storage storage = storageDao.selectByProductId(order.getProductId());
        if (storage!=null && storage.getResidue().intValue() >= order.getCount().intValue()){
            System.out.println("商品库存充足，正在扣减商品库存");
            storage.setUsed(storage.getUsed()+order.getCount());
            storage.setResidue(storage.getTotal().intValue()-storage.getUsed());
            int decrease = storageDao.decrease(storage);
            System.out.println("商品库存扣减完成");
        } else {
            System.out.println("警告：商品库存不足，正在执行回滚操作！");
            throw new RuntimeException("库存不足");
        }

        System.out.println("开始查询用户的账户金额");
        Account account = accountDao.selectByUserId(order.getUserId());
        if (account!=null && account.getResidue().intValue() >= order.getMoney().intValue()){
            System.out.println("账户金额充足，正在扣减账户金额");
            accountDao.decrease(order.getUserId(),order.getMoney());
            System.out.println("账户金额扣减完成");
        } else {
            System.out.println("警告：账号余额不足，正在执行回滚操作！");
            throw new RuntimeException("账户余额不足！");
        }

        System.out.println("开始修改订单状态，未完成》》》已完成");
        orderDao.updateOrderStatus(order.getOrderId(),0);
        System.out.println("修改订单状态完成");
    }


}
