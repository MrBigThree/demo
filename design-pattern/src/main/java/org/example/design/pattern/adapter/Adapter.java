package org.example.design.pattern.adapter;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.doSomething();
    }
}
