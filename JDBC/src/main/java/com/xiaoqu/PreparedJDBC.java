package com.xiaoqu;

import java.sql.*;

public class PreparedJDBC {


    public static void main(String[] args) {
        String url = "jdbc:mysql://123.57.254.88:3306/learn?characterEncoding=utf8"; //这里不带uf8，查询中带中文查询不到结果
        String username = "root";
        String password = "Root!!2022";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String name = "张三";
            int money = 3000;

            String sql = "select * from account where name = ? and money= ?";

            preparedStatement = connection.prepareStatement(sql);
            Thread.sleep(10000);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,money);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}
