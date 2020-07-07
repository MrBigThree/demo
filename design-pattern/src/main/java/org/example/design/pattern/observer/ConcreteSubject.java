package org.example.design.pattern.observer;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/6
 */
public class ConcreteSubject extends Subject {

    public void doSomething() {
        // doSomething
        notifyAllObservers();
    }
}
