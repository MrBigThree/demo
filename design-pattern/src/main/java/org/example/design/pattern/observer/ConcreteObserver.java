package org.example.design.pattern.observer;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/6
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("收到消息并处理");
    }
}
