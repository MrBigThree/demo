package org.example.design.pattern.zhss.proxy;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject();
        Subject proxySubject = new ProxySubject(concreteSubject);

        proxySubject.request();
    }

}

interface Subject {

    void request();
}

class ConcreteSubject implements Subject {

    @Override
    public void request() {
        System.out.println("原来的执行逻辑");
    }
}


class ProxySubject implements Subject {

    private Subject concreteSubject;

    public ProxySubject(Subject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void request() {
        //可以执行一些其他的逻辑
        System.out.println("代理类执行一些其他的逻辑");
        concreteSubject.request();
    }
}


