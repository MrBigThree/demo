package org.example.hystrix.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/9/8
 */
public class Demo {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                HelloWorldHystrixCommand command = new HelloWorldHystrixCommand("xxx");
                String result = command.execute();
                System.out.println(result);
            }).start();
        }
    }
}
