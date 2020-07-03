package org.example.design.pattern.strategy;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("策略2的运算规则");
    }
}
