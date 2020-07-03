package org.example.design.pattern.decorator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        method();
        super.operate();
    }

    private void method() {

    }


}
