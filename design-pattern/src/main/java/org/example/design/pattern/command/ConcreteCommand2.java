package org.example.design.pattern.command;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/29
 */
public class ConcreteCommand2 extends Command {

    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
