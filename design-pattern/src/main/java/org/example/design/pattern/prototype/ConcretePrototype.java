package org.example.design.pattern.prototype;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class ConcretePrototype implements Cloneable {

    public ConcretePrototype() {
    }

    @Override
    protected ConcretePrototype clone() throws CloneNotSupportedException {
        ConcretePrototype clone = (ConcretePrototype) super.clone();
        return clone;
    }
}
