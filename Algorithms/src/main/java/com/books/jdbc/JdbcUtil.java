package com.books.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 原生 JDBC
 * 
 * Created by books on 2017/12/15.
 */
public class JdbcUtil {
    
    private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);

    private static final String DEFAULT_URL = "jdbc:mysql://127.0.0.1:3306/maven-web";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "root";
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("加载驱动失败", e);
            throw new RuntimeException("加载驱动失败");
        }
    }

    public static Connection getConnection() {
        return getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }
    
    public static Connection getConnection(String url, String username, String password) {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.error("获取链接失败", e);
            throw new RuntimeException("获取链接失败");
        }
    }
    
    public static void printResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            System.out.println("没有查询到结果");
            return ;
        }

        try {
            while (resultSet.next()) {
                System.out.print("user: id = " + resultSet.getLong(1));
                System.out.print(", agentName = " + resultSet.getString(2));
                System.out.print(", age = " + resultSet.getInt(3));
                System.out.println();
            }
        } catch (SQLException e) {
            logger.error("解析结果集失败", e);
            throw new RuntimeException("解析结果集失败");
        }
    }
    
    public static void close() {
        
    }
    
}