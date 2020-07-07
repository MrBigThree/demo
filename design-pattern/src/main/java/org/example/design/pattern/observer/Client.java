package org.example.design.pattern.observer;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/6
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        //添加观察者，可以添加多个观察者
        subject.addObserver(new ConcreteObserver());
        subject.doSomething();
    }
}
