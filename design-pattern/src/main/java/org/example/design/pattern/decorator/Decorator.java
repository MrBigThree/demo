package org.example.design.pattern.decorator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}
