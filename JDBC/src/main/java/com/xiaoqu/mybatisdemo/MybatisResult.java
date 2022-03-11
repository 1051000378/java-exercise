package com.xiaoqu.mybatisdemo;

import com.xiaoqu.Brand;
import com.xiaoqu.mapper.BrandMapper;
import com.xiaoqu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisResult {

    @Test
    public void testQuery() {
        String resources = "mybatis-config.xml";
        SqlSession sqlSession = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = build.openSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            List<Brand> brands = mapper.selectAll();
            System.out.println(brands);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }

    @Test
    public void testQueryById() {

        String resources = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = build.openSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            Brand brand = mapper.selectById(1);
            System.out.println(brand);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //    多条件查询
    @Test
    public void testSelectByCondition() {
        String resources = "mybatis-config.xml";
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = build.openSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//            多条件查询：方法一
//            List<Brand> brands = mapper.selectByCondition1(status, companyName, brandName);
//            System.out.println(brands);
//            方法二
//            Brand brand = new Brand();
//            brand.setStatus(status);
//            brand.setCompanyName(companyName);
//            brand.setBrandName(brandName);
//            List<Brand> brands = mapper.selectByCondition2(brand);
//            System.out.println(brands);
//            方法三
//            Map map = new HashMap<>();
//            map.put("status",status);
//            map.put("companyName",companyName);
//            map.put("brandName",brandName);
//            List<Brand> brands = mapper.selectByCondition3(map);
//            System.out.println(brands);

//            条件下拉框选择单一条件
            Brand brand = new Brand();
            brand.setStatus(status);
            brand.setCompanyName(companyName);
            List<Brand> brands = mapper.selectByConditionSingle(brand);
            System.out.println(brands);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        String resources = "mybatis-config.xml";
        int status = 1;
        String companyName = "小趣科技有限公司";
        String brandName = "小趣";
        int ordered = 20;
        String description ="蓝思科技弗兰克";
        SqlSession sqlSession = null;

        try {
//            1.获取SqlSessionFactory
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //2.获取SqlSession对象
            sqlSession = build.openSession();
//            sqlSession = build.openSession(true);//设置自动提交事务，这种情况不需要手动提交事务
            //3.获取Mapper接口的代理对象
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

            Brand brand = new Brand();
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
//            //4.执行方法
//            mapper.add(brand);
//           4. 执行成功返回主键
            Integer i = mapper.addKey(brand);//返回记录数，添加一个就是1

            //提交事务
            sqlSession.commit();

            System.out.println("---------"+i);
            System.out.println(brand.getId());//返回主键

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate(){
        String description = "jlksllllll";
        String brandName = "小米";

        int ordered = 99;

        int id = 7;

        String resources = "mybatis-config.xml";
        SqlSession sqlSession = null;


        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession();

            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
            Brand brand = new Brand();
            brand.setDescription(description);
            brand.setBrandName(brandName);
            brand.setId(id);
            brand.setOrdered(ordered);


//            mapper.update(brand);
            mapper.update1(brand);//只更新不为空的字段

            sqlSession.commit();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDelete(){
        String resources = "mybatis-config.xml";
        SqlSession sqlSession = null;

        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession();
            BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

            Brand brand = new Brand();

//            brand.setId(1);
//            mapper.delete(brand);
//            mapper.deleteById(8);

            //批量删除
            int[] ids = {6,7};
            mapper.deleteByIds(ids);


            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
