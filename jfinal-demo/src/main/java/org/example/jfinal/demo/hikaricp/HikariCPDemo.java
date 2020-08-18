package org.example.jfinal.demo.hikaricp;

import com.jfinal.plugin.hikaricp.HikariCpPlugin;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/17
 */
public class HikariCPDemo {

    public static void main(String[] args) {
        //配置文件
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://20.21.1.102/information_schema?serverTimezone=Hongkong");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("zjrc2019");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //创建connection
            conn = ds.getConnection();
            statement = conn.createStatement();

            //执行sql
            rs = statement.executeQuery("select now() as s");

            //取数据
            if (rs.next()) {

                System.out.println(rs.getString("s"));
            }

            //关闭connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

