package org.example.design.pattern.command;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/29
 */
public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Command command = new ConcreteCommand1(new ConcreteReceiver1());
        invoker.setCommand(command);
        invoker.action();
    }
}
