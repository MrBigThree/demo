package org.example.design.pattern.templatemethod;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/30
 */
public class ConcreteClass2 extends AbstractClass {
    @Override
    void step1() {
        System.out.println("ConcreteClass2 step1");
    }

    @Override
    void step2() {
        System.out.println("ConcreteClass2 step2");
    }

    @Override
    void step3() {
        System.out.println("ConcreteClass2 step3");
    }
}
