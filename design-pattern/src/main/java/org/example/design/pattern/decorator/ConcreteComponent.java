package org.example.design.pattern.decorator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("do something");
    }
}
