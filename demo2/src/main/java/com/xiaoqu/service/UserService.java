package com.xiaoqu.service;

import com.xiaoqu.bean.User;
import com.xiaoqu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserService {


    public void register(User user){
        String resources = "mybatis-config.xml";
        SqlSession sqlSession = null;

        try {

            InputStream inputStream = Resources.getResourceAsStream(resources);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStreamReader);

            sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.add(user);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public User login(String username,String password){
        String resources = "mybatis-config.xml";
        SqlSession sqlSession = null;
        User user = null;

        try {

            InputStream inputStream = Resources.getResourceAsStream(resources);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStreamReader);

            sqlSession = build.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = mapper.selectByName(username,password);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;

    }


}
