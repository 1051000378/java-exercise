package com.xiaoqu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert(User user) {
        String sql = "insert into user(user_name,user_pwd,user_realname,user_img) values (?,?,?,?)";
        Object[] args = {user.getUserName(),user.getUsePwd(),user.getUserRealname(),user.getUserImg()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);


    }

    @Override
    public int update(User user) {
        String sql = "update user set user_realname=? where user_name=?";
        int update = jdbcTemplate.update(sql, user.getUserRealname(), user.getUserName());

        return update;
    }

    @Override
    public int delete(User user) {
        String sql = "delete from user where user_name=?";
        int update = jdbcTemplate.update(sql, user.getUserName());
        return update;
    }

    @Override
    public int count(User user) {
        String sql = "select count(*) from user where user_name=?";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, user.getUserName());
        return integer;
    }

    @Override
    public List<User> getList(User user) {
        String sql = "select * from user where user_name=?";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getUserName());

        return query;
    }

    @Override
    public User getUser(User user) {
        String sql = "select * from user where user_name=?";
        User user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUserName());

        return user1;
    }

    @Override
    public void batchAddUser(List<Object[]> batchArgs) {
        String sql = "insert into user(user_name,user_pwd,user_realname,user_img) values(?,?,?,?)";
        jdbcTemplate.batchUpdate(sql,batchArgs);


    }
}
