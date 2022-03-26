package com.xiaoqu;

import com.xiaoqu.dao.GoodsMapper;
import com.xiaoqu.pojo.Goods;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testMyBatis(){

        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
//            Connection connection = sqlSession.getConnection();
//            System.out.println(connection);
//            方法一：映射文件
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
            List<Goods> goods = mapper.selectAll();
            for (Goods good : goods) {
                System.out.println(good);
            }
//            方法二：直接调用goodsMapper.xml中的id接口
//            这里有个注意点：selectList中填写是“namespace.id”(命名空间.id),如果不映射对象的话可以随意填写namespace,
//            如果要映射GoodsMapper对象的话，就要写明GoodMapper的全路径。结合spring就要做出一些改变，要注意变化点
//            List<Goods> goods = sqlSession.selectList("com.xiaoqu.dao.GoodsMapper.selectAll");
//            for (Goods good : goods) {
//                System.out.println(good);
//            }

        }catch (Exception e){
            throw e;
        } finally {
            /**
             * 测试时，报错 could not initialize class com.xiaoqu.MybatisUtils，提示下面代码报错
             * 排查思路：
             * 1.注释掉下面代码然后运行。 发现仍然报错
             * 2.这时可以从报错信息中知道哪里出现错误了
             *  sql映射文件路径配置不正确 mybatis-config.xml下的mappers
             *  goodsMapper.xml下的namespace命名空间配置不正确。应该是mapper方法全路径
             *  goodsMapper.xml下的增删改查id发生重复等等
             */
            MyBatisUtil.closeSession(sqlSession);
        }


    }



}
