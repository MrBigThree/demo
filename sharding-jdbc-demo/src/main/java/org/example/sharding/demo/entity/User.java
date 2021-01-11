package org.example.sharding.demo.entity;

import cn.hutool.core.lang.Snowflake;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/6
 */
public class User {
    public static void main(String[] args) throws InterruptedException {
        Snowflake snowflake = new Snowflake(1, 1);

        for (int i = 0; i < 4096; i++) {
            String nextIdStr = snowflake.nextIdStr();
            System.out.println(nextIdStr);
        }
    }
}
