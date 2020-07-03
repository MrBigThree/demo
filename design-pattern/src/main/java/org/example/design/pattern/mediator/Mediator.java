package org.example.design.pattern.mediator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public abstract class Mediator {
    protected ConcreteColleague colleague1;

    protected ConcreteColleague2 colleague2;


    public void setColleague1(ConcreteColleague colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public abstract void doSomething1();

    public abstract void doSomething2();
}
