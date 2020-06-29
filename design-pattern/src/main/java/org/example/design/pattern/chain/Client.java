package org.example.design.pattern.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/28
 */
public class Client {

    public static void main(String[] args) {
        AbstractHandler handler1 = new Handler1();
        AbstractHandler handler2 = new Handler2();
        AbstractHandler handler3 = new Handler3();
        List<AbstractHandler> handlers = new ArrayList<>();
        handlers.add(handler1);
        handlers.add(handler2);
        handlers.add(handler3);
        new Invocation(handlers).initHandlerChain().invoke();
    }

}
