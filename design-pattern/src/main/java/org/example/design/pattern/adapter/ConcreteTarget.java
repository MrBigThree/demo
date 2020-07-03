package org.example.design.pattern.adapter;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("if you need any help ,please call me !");
    }
}
