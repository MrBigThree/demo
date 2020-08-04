package org.springboot.starter.demo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/3
 */
public class Test2 {

    //-54
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/lvxuhong/IdeaProjects/git项目/demo/springboot-demo/target/classes/com/example/springbootdemo/aop/Aop.class");
        byte[] buffer = new byte[1024];
        fileInputStream.read(buffer);
        System.out.println(buffer[0]);
        for (byte b : buffer) {
            long bu = b & 0xff;
            String string = Long.toString(bu, 2);
            System.out.println(string);
        }
    }
}
