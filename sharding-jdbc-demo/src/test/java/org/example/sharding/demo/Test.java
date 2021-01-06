package org.example.sharding.demo;

import org.example.sharding.demo.controller.UserController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

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

    @org.junit.Test
    public void test() throws SQLException {
        userController.test();
    }

    @org.junit.Test
    public void testQuery() throws SQLException {
        userController.test1();
    }
}
