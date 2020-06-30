package org.example.design.pattern.templatemethod;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/30
 */
public abstract class AbstractClass {

    abstract void step1();

    abstract void step2();

    abstract void step3();

    public final void templateMethod() {
        step1();
        step2();
        step3();
    }
}
