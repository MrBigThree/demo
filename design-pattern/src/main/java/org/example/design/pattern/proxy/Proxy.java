package org.example.design.pattern.proxy;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/2
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();

    }

    private void before() {
    }

    private void after() {
    }
}
