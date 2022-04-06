package com.xiaoqu.dao;

import com.xiaoqu.entity.Storage;

public interface StorageDao {

    Storage selectByProductId(String productId);

    int decrease(Storage record);

}
