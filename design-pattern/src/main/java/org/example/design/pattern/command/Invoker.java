package org.example.design.pattern.command;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/29
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
