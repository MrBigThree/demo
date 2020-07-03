package org.example.design.pattern.mediator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void method1() {
        super.mediator.doSomething1();
    }
}
