package org.example.design.pattern.adapter;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class Client {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target target1 = new Adapter();
        target1.request();
    }
}
