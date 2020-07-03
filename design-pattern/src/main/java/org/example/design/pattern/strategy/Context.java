package org.example.design.pattern.strategy;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything() {
        this.strategy.doSomething();
    }

}
