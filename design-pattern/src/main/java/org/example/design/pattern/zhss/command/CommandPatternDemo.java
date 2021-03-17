package org.example.design.pattern.zhss.command;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Command commandA = new CommandA();
        Command commandB = new CommandB();

        Invoker invoker = new Invoker();
        invoker.setCommand(commandA);
        invoker.execute();

        invoker.setCommand(commandB);
        invoker.execute();
    }

    interface Command {
        void execute();
    }

    public static class CommandA implements Command {

        @Override
        public void execute() {
            System.out.println("command A");
        }
    }

    public static class CommandB implements Command {

        @Override
        public void execute() {
            System.out.println("command B");
        }
    }

    public static class Invoker {
        private Command command;

        public Command getCommand() {
            return this.command;

        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public void execute() {
            this.command.execute();
        }
    }
}
