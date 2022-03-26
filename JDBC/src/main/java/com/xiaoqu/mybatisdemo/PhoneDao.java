package com.xiaoqu.mybatisdemo;

import com.xiaoqu.Phone;
import com.xiaoqu.mapper.PhoneMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class PhoneDao {


    @Test
    public void testSelectAll() {

        String recources = "mybatis-config.xml";

        SqlSession sqlSession = null;
        List<Phone> phones = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(recources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession();
            PhoneMapper mapper = sqlSession.getMapper(PhoneMapper.class);
            phones = mapper.selectAll();
            for (Phone phone : phones) {
                System.out.println(phone);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
