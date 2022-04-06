package com.xiaoqu.dao.impl;

import com.xiaoqu.dao.AccountDao;
import com.xiaoqu.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByUserId(String userId) {

        String sql = "select * from account where user_id=?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), userId);
        return account;
    }

    @Override
    public int decrease(String userId, BigDecimal money) {
        String sql = "update account set residue=residue-?, used=used+? where user_id=?";
        int update = jdbcTemplate.update(sql, money, money, userId);
        return update;
    }
}
