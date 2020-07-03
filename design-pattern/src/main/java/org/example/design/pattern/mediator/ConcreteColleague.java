package org.example.design.pattern.mediator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod1() {

    }

    public void depMethod1() {
        //自己不能处理的业务委托给中介者处理
        super.mediator.doSomething1();
    }
}
