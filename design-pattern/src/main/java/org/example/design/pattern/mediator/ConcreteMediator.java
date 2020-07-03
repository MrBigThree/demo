package org.example.design.pattern.mediator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void doSomething1() {
        super.colleague1.selfMethod1();
        super.colleague2.method1();
    }

    @Override
    public void doSomething2() {
        super.colleague1.selfMethod1();
        super.colleague2.method1();
    }
}
