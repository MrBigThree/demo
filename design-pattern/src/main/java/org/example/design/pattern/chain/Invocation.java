package org.example.design.pattern.chain;

import java.util.List;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/28
 */
public class Invocation {

    private List<AbstractHandler> handlers;

    public Invocation(List<AbstractHandler> handlers) {
        this.handlers = handlers;
    }

    public Invocation initHandlerChain() {
        if (!handlers.isEmpty() && handlers.size() > 1) {
            AbstractHandler handler;
            for (int i = 0; i < handlers.size(); i++) {
                if (i < handlers.size() - 1) {
                    handler = handlers.get(i);
                    handler.setNext(handlers.get(i + 1));
                }
            }
        }
        return this;
    }

    public void invoke() {
        if (!handlers.isEmpty()) {
            handlers.get(0).handleMessage();
        }
    }
}
