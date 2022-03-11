package com.xiaoqu;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidExercise {

    /**
     * 1.先配置druid的maven的依赖和mysql-connector-java依赖
     * 2.配置druid的配置文件druid.properties
     * @param args
     **/
    public static void main(String[] args) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;

//        加载配置文件
        Properties properties = new Properties();
        try {
            //注意properties读取resources下的文件的方法，斜杠/不能取消
            InputStream in = DruidExercise.class.getResourceAsStream("/druid.properties");
            InputStreamReader inputStreamReader = new InputStreamReader(in,"UTF-8");
            properties.load(inputStreamReader);
//            获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//            获取数据库连接
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            String sql = "select * from account where name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"张三");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name= resultSet.getString("name");
                System.out.println("登录成功，用户名："+name);
            }else {
                System.out.println("登录失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习：增删改查
     * 完成商品品牌数据的增删改查操作
     *
     * - 查询：查询所有数据
     * - 添加：添加品牌
     * - 修改：根据id修改
     * - 删除：根据id删除
     *
     *
     *
     */
    @Test
    public void testQuery(){

        Properties properties = new Properties();
        InputStream inputStream = DruidExercise.class.getResourceAsStream("/druid.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            properties.load(inputStreamReader);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();

            String sql = "select * from tb_brand";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //添加到集合中
            List<Brand> brandList = new ArrayList<>();

            while (resultSet.next()){
                String brandName = resultSet.getString("brand_name");
                String companyName = resultSet.getString("company_name");
                String description = resultSet.getString("description");

                //封装Brand
                Brand brand = new Brand();
                brand.setBrandName(brandName);
                brand.setCompanyName(companyName);
                brand.setDescription(description);

                brandList.add(brand);
            }

            System.out.println(brandList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    @Test
    public void testInsert(){

        InputStream inputStream = DruidExercise.class.getResourceAsStream("/druid.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Properties properties = new Properties();
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            properties.load(inputStreamReader);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
            String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            String brandName = "小狗";
            String companyName = "小狗公司";
            int ordered= 60;
            String description = "haha";
            int status = 1;

            preparedStatement.setString(1,brandName);
            preparedStatement.setString(2,companyName);
            preparedStatement.setInt(3,ordered);
            preparedStatement.setString(4,description);
            preparedStatement.setInt(5,status);

            int execute = preparedStatement.executeUpdate();
            System.out.println(execute>0);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    @Test
    public void testUpdate(){

        Properties properties = new Properties();
        InputStream inputStream = DruidExercise.class.getResourceAsStream("/druid.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            properties.load(inputStreamReader);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();

            String sql = "update tb_brand set brand_name=? where company_name=? limit 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"狗不理");
            preparedStatement.setString(2,"小狗公司");

            preparedStatement.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    @Test
    public void testDelete(){
        Properties properties = new Properties();
        InputStream inputStream = DruidExercise.class.getResourceAsStream("/druid.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            properties.load(inputStreamReader);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
            String sql = "delete from tb_brand where brand_name=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"小狗");
            preparedStatement.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }


}
