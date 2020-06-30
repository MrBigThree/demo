package org.example.design.pattern.templatemethod;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/30
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass1();
        abstractClass.templateMethod();

        System.out.println();
        AbstractClass abstractClass1 = new ConcreteClass2();
        abstractClass1.templateMethod();
    }
}
