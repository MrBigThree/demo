package org.example.sharding.demo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import org.example.sharding.demo.controller.UserController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Random;

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
        //1千万数据，
        try {
            connection.setAutoCommit(true);
//            PreparedStatement delete_from_person_attence = connection.prepareStatement("delete from tb_person_attence");
//            delete_from_person_attence.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tb_person_attence (id, person_id, device_code, attence_time, create_by, create_date, update_by,\n" +
                    "                                   update_date, remarks, del_flag, department_id, department_name, person_name,\n" +
                    "                                   person_phone, company_id, company_name)" +
                    "VALUES (?,?,?,?,?,now(),?,now(),'xx','0','1234','部门','王大锤','1390909090','uuid','某某公司')");
            Long id = 8806210L;
            for (int i = 12; i <= 12; i++) {
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
                    for (int k = 0; k < 33; k++) {
                        DateTime dateTime = DateUtil.offsetSecond(timestamp, 1);
                        timestamp = new Timestamp(dateTime.getTime());
                        for (int l = 0; l < 1000; l++) {
                            preparedStatement.setLong(1, id);
                            preparedStatement.setString(2, generateId());
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

    }

    public String generateId() {
        //员工id 1 - 1000000
        int i = RandomUtil.randomInt(1000000);
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            String s = new Test().generateId();
            System.out.println(s);
        }
    }

}
