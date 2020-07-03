package org.example.design.pattern.mediator;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
