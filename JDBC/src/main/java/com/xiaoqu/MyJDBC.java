package com.xiaoqu;

import java.sql.*;

public class MyJDBC {

    public static void main(String[] args) {


//        String url = "jdbc:mysql://123.57.254.88:3306/learn?useSSL=false&characterEncoding=utf8";
        String url = "jdbc:mysql://123.57.254.88:3306/learn";
        String username = "root";
        String password = "Root!!2022";

        Connection connection=null;
        Statement statement=null;

        try {
            //1.注册驱动
//            Class.forName("com.mysql.jdbc.Driver"); //MySQL 5之后的驱动包，可以省略注册驱动的步骤
//            2.获取连接
            connection = DriverManager.getConnection(url, username, password);
//            3.定义sql
            String sql = "select * from user;";
//            4.获取sql的对象statement
            statement = connection.createStatement();//不安全，sql注入
//            5.执行sql
            /**
             * 查询语句
             */
            // ResultSet 结果集对象
            ResultSet resultSet = statement.executeQuery(sql);
            // 光标向下移动一行，并且判断当前行是否有数据
            while (resultSet.next()){
                String name = resultSet.getString("user_name");//获取字段，注意要跟数据库中字段匹配
                System.out.println(name+" 密码："+resultSet.getInt("user_pwd"));

            }
            //注意：执行query不需要commit,但是要close

            /**
             * 插入
             */

            String sql5 = "insert into account(name,money)valuses()";

            /**
             * 事务和更新语句
             */
//            //======开启事务=======
//            connection.setAutoCommit(false);
////            5. 执行sql
//            String sql1 = "update user set user_name='xiaing' limit 1";
//            statement.executeUpdate(sql1);
//
//            String sql2 = "update user set user_name=lixiao limit 5";
//            int i = 1/0;
//            statement.executeUpdate(sql2);
//            // ============提交事务==========
//            //程序运行到此处，说明没有出现任何问题，则需求提交事务
//            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
//                6.释放资源
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}
