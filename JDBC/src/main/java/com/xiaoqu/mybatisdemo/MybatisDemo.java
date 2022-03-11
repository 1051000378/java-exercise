package com.xiaoqu.mybatisdemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * 1.配置文件pom依赖
 * 2.编写mybatis核心配置文件 --》替换连接信息 解决硬编码问题
 * 3.
 *
 *
 */
public class MybatisDemo {

    @Test
    public void testMybatisDemo(){
        SqlSession sqlSession = null;

        String resource = "mybatis-config.xml";
        try {
            //1.加载mybatis的核心配置文件，获取SqlSessionFactory
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

//            2.获取SqlSession对象，用它来执行sql
            sqlSession = build.openSession();
//            3.执行sql
            List<User> users = sqlSession.selectList("test.selectAll");//参数是一个字符串，该字符串必须是映射配置文件的namespace.id
//            System.out.println("------------"+users);
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()){
                User next = iterator.next();
                System.out.println(next);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

}
