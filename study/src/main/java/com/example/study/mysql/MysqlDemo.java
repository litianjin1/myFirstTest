package com.example.study.mysql;

import java.sql.*;

public class MysqlDemo {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/my_test";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "zj123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs =null;
        try {
            //1、注册jdbc驱动
            Class.forName(JDBC_DRIVER);

            //2、建立连接
            conn = DriverManager.getConnection(DB_URL);

            //3、执行查询
            String sql = "select * from websites";
            stat = conn.createStatement();
             rs = stat.executeQuery(sql);


            //4、展开结果集，通过字段检索
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                System.out.print(id+","+name+","+url);
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //如果有异常抛出，最后要关闭资源
            //5、关闭资源
            try {
               if(rs!=null) rs.close();
                if(stat!=null)stat.close();
                if(conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("say goodbye!!!");
    }
}
