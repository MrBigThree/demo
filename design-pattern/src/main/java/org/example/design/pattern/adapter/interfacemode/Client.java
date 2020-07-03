package org.example.design.pattern.adapter.interfacemode;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class Client {

    public static void main(String[] args) {
        TargetInterface concreteTargetAdapter = new ConcreteTargetAdapter();
        concreteTargetAdapter.method1();
    }
}
