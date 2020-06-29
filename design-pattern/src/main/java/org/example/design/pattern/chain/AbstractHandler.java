package org.example.design.pattern.chain;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/28
 */
public abstract class AbstractHandler {


    protected AbstractHandler next;

    abstract void handleMessage();

    protected void handleNext() {
        if (next != null) {
            next.handleMessage();
        }
    }

    public void setNext(AbstractHandler handler) {
        this.next = handler;
    }
}
