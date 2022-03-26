package com.xiaoqu;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisDemo {

    @Test
    public void testMybatis(){
        SqlSession sqlSession = null;

        try {
//            1.读取mybatis的配置文件，然后根据配置文件的内容去创建SqlSessionFactory对象
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            2. 创建SqlSession对象，SqlSession对象是专用于数据库交互的
            sqlSession = build.openSession();



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }

        }


    }


}
