package org.example.sharding.demo.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
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

    @GetMapping("testAttence")
    public String testAttence() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(true);
            PreparedStatement delete_from_person_attence = connection.prepareStatement("delete from person_attence");
            delete_from_person_attence.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into person_attence (id, person_id, device_code, attence_time, create_by, create_date, update_by,\n" +
                    "                                   update_date, remarks, del_flag, department_id, department_name, person_name,\n" +
                    "                                   person_phone, company_id, company_name)\n" +
                    "VALUES (?,?,?,?,?,now(),?,now(),'xx','0','1234','部门','王大锤','1390909090','uuid','某某公司')");
            Long id = 0L;
            for (int i = 1; i <= 12; i++) {
                String mouth = "";
                if (i >= 10) {
                    mouth = "2020" + i;
                } else {
                    mouth = "20200" + i;
                }
                for (int j = 1; j <= 25; j++) {
                    String day = mouth;
                    if (j >= 10) {
                        day = day + j;
                    } else {
                        day = day + "0" + j;
                    }
                    String time = day + " 08:00:00";
                    DateTime parse = DateUtil.parse(time, "yyyyMMdd HH:mm:ss");
                    Timestamp timestamp = new Timestamp(parse.getTime());
                    for (int k = 0; k < 200; k++) {
                        DateTime dateTime = DateUtil.offsetSecond(timestamp, 1);
                        timestamp = new Timestamp(dateTime.getTime());
                        for (int l = 0; l < 1000; l++) {
                            preparedStatement.setLong(1, id);
                            preparedStatement.setString(2, IdUtil.simpleUUID());
                            preparedStatement.setString(3, IdUtil.simpleUUID());
                            preparedStatement.setTimestamp(4, timestamp);
                            preparedStatement.setString(5, IdUtil.simpleUUID());
                            preparedStatement.setString(6, IdUtil.simpleUUID());
                            preparedStatement.addBatch();
                            id++;
                            System.out.println(id);
                        }
                        preparedStatement.executeBatch();
                        preparedStatement.clearBatch();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return "";
    }


    @GetMapping("testAttence7")
    public String testAttence8() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into person_attence (id, person_id, device_code, attence_time, create_by, create_date, update_by,\n" +
                    "                                   update_date, remarks, del_flag, department_id, department_name, person_name,\n" +
                    "                                   person_phone, company_id, company_name)\n" +
                    "VALUES (?,?,?,?,?,now(),?,now(),'xx','0','1234','部门','王大锤','1390909090','uuid','某某公司')");
            Long id = 50000000L;
            for (int i = 11; i <= 12; i++) {
                String mouth = "";
                if (i >= 10) {
                    mouth = "2020" + i;
                } else {
                    mouth = "20200" + i;
                }
                for (int j = 1; j <= 25; j++) {
                    String day = mouth;
                    if (j >= 10) {
                        day = day + j;
                    } else {
                        day = day + "0" + j;
                    }
                    String time = day + " 08:00:00";
                    DateTime parse = DateUtil.parse(time, "yyyyMMdd HH:mm:ss");
                    Timestamp timestamp = new Timestamp(parse.getTime());
                    for (int k = 0; k < 20; k++) {
                        DateTime dateTime = DateUtil.offsetSecond(timestamp, 1);
                        timestamp = new Timestamp(dateTime.getTime());
                        for (int l = 0; l < 10000; l++) {
                            preparedStatement.setLong(1, id);
                            preparedStatement.setString(2, IdUtil.simpleUUID());
                            preparedStatement.setString(3, IdUtil.simpleUUID());
                            preparedStatement.setTimestamp(4, timestamp);
                            preparedStatement.setString(5, IdUtil.simpleUUID());
                            preparedStatement.setString(6, IdUtil.simpleUUID());
                            preparedStatement.addBatch();
                            id++;
                            System.out.println(id);
                        }
                        preparedStatement.executeBatch();
                        connection.commit();
                        preparedStatement.clearBatch();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return "";
    }
}
