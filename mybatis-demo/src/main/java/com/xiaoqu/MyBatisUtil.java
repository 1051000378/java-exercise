package com.xiaoqu;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 * 1.创建全局唯一的SqlSessionFactory对象
 * 2.获取SqlSession的方法
 * 3.关闭sqlSession的方法
 */

public class MyBatisUtil {

    private static SqlSessionFactory build = null;

    /**
     * （1）SqlSessionFactory对象设置成了static；然后，SqlSessionFactory的实例化代码也放在了静态代码快中；这保证SqlSessionFactory全局唯一；
     *
     * （2）初始化出问题后，主动【throw new ExceptionInInitializerError(e);】
     */
    static {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
            // 如果出现了异常，除了上面打印异常，还需要将这个异常向上抛，让使用这个类的程序也知道这儿报错了；
            // 这儿主动抛了ExceptionInInitializerError，即在类的初始化过程中产生了错误；即调用者捕获了这个异常，就能够明白，
            // mybatis在初始化的时候产生了错误，
            throw new ExceptionInInitializerError(e);
        }

    }

    /**
     * 获得sqlSession对象
     * 在其他地方调用这个方法获取SqlSession对象后，后续就可以利用SqlSession完成数据库的增删改查了
     * 说明：工具类中的方法，一般使用static进行描述，这样以后通过类就能直接调用了
     * @return
     */
    public static SqlSession openSession(){
        return build.openSession();
    }

    /**
     * 关闭sqlSession
     * @param sqlSession
     */
    public static void closeSession(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
        }
    }


}
