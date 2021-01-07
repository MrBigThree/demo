package org.example.sharding.demo.controller;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/6
 */
@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("test")
    public String test() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement1 = connection.prepareStatement("delete from user");
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user values (?,?,?)");
            for (int i = 0; i < 2500000; i++) {
                preparedStatement.setLong(1, i);
                preparedStatement.setString(2, "city" + i);
                preparedStatement.setString(3, "name" + i);
                preparedStatement.addBatch();
                if (i % 100 == 0) {
                    preparedStatement.executeBatch();
                    connection.commit();
                    preparedStatement.clearBatch();
                }
            }
            connection.commit();
        } finally {
            connection.close();
        }
        return null;
    }


    @GetMapping("test1")
    public String test1() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            long l = System.currentTimeMillis();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name = 'name9999897'");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Map<String, Object>> list = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnName(i), resultSet.getObject(i));
                }
                list.add(map);
            }
            System.out.println(JSONUtil.toJsonStr(list));
            long e = System.currentTimeMillis();
            System.out.println(e - l);
        } finally {
            connection.close();
        }
        return null;
    }
}
