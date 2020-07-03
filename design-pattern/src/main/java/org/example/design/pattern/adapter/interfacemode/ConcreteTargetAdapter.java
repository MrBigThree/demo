package org.example.design.pattern.adapter.interfacemode;

/**
 * @description: 继承抽象适配器，只重写你需要的方法，无需关心其他方法
 * @author:lvxuhong
 * @date:2020/7/3
 */
public class ConcreteTargetAdapter extends TargetAdapter {

    @Override
    public void method1() {
        System.out.println("我只重写了 method1,其他方法我都不关心");
    }
}
