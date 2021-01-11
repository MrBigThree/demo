package org.example.sharding.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import org.example.sharding.demo.controller.UserController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private UserController userController;

    @Autowired
    private DataSource dataSource;

    @org.junit.Test
    public void test() throws SQLException {
        userController.test();
    }

    @org.junit.Test
    public void testQuery() throws SQLException {
        userController.test1();
    }

    @org.junit.Test
    public void testAttence() throws SQLException {
        userController.testAttence();
    }


    @org.junit.Test
    public void testAttence1() throws SQLException {
        userController.testAttence8();
    }


    @org.junit.Test
    public void testQ() throws SQLException {
        Connection connection = dataSource.getConnection();

//        DateTime time1 = DateUtil.parse("2020-01-25 08:03:20");
//        DateTime time2 = DateUtil.parse("2020-02-01 08:00:02");
//        DateTime time3 = DateUtil.parse("2020-03-01 08:00:02");
//        DateTime time4 = DateUtil.parse("2020-04-01 08:00:02");
//
//        DateTime time5 = DateUtil.parse("2020-05-25 08:03:20");
//        DateTime time6 = DateUtil.parse("2020-06-01 08:00:02");
//        DateTime time7 = DateUtil.parse("2020-07-01 08:00:02");
//        DateTime time8 = DateUtil.parse("2020-08-01 08:00:02");
//
//        DateTime time9 = DateUtil.parse("2020-09-25 08:03:20");
//        DateTime time10 = DateUtil.parse("2020-10-01 08:00:02");
//        DateTime time11 = DateUtil.parse("2020-11-01 08:00:02");
//        DateTime time12 = DateUtil.parse("2020-12-01 08:00:02");
//
//
//
//        PreparedStatement preparedStatement = connection.prepareStatement(" select * from person_attence where attence_time in (?,?,?,?,?,?,?,?,?,?,?,?)");
//        preparedStatement.setTimestamp(1, new Timestamp(time1.getTime()));
//        preparedStatement.setTimestamp(2, new Timestamp(time2.getTime()));
//        preparedStatement.setTimestamp(3, new Timestamp(time3.getTime()));
//        preparedStatement.setTimestamp(4, new Timestamp(time4.getTime()));
//        preparedStatement.setTimestamp(5, new Timestamp(time5.getTime()));
//        preparedStatement.setTimestamp(6, new Timestamp(time6.getTime()));
//        preparedStatement.setTimestamp(7, new Timestamp(time7.getTime()));
//        preparedStatement.setTimestamp(8, new Timestamp(time8.getTime()));
//        preparedStatement.setTimestamp(9, new Timestamp(time9.getTime()));
//        preparedStatement.setTimestamp(10, new Timestamp(time10.getTime()));
//        preparedStatement.setTimestamp(11, new Timestamp(time11.getTime()));
//        preparedStatement.setTimestamp(12, new Timestamp(time12.getTime()));

        PreparedStatement preparedStatement = connection.prepareStatement("select * from person_attence where device_code = '0f270891c8824551b6d62cb3f9298b84' ");
        long start = System.currentTimeMillis();
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            Object count = resultSet.getObject("person_name");
            System.out.println(count);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        connection.close();
    }
}
