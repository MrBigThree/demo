package org.example.design.pattern.strategy;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class Client {

    public static void main(String[] args) {
        {
            Strategy strategy = new ConcreteStrategy1();
            Context context = new Context(strategy);
            context.doAnything();
        }
        System.out.println();
        {
            Strategy strategy = new ConcreteStrategy2();
            Context context = new Context(strategy);
            context.doAnything();
        }
    }
}
