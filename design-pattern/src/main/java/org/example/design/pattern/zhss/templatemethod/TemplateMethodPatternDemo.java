package org.example.design.pattern.zhss.templatemethod;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class TemplateMethodPatternDemo {

    public static void main(String[] args) {
       AbstractClass abstractClass = new ConcreteClass();
       abstractClass.templateMethod();
    }

}

abstract class AbstractClass {

    public void templateMethod() {
        System.out.println("执行其他处理");
        method1();
        method2();
        method3();

    }

    abstract void method1();

    abstract void method2();

    abstract void method3();

}

class ConcreteClass extends AbstractClass {

    @Override
    void method1() {
        System.out.println("子类实现method1");
    }

    @Override
    void method2() {
        System.out.println("子类实现method2");
    }

    @Override
    void method3() {
        System.out.println("子类实现method3");
    }
}
