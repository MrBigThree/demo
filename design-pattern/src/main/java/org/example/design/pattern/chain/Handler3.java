package org.example.design.pattern.chain;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/6/28
 */
public class Handler3 extends AbstractHandler {

    @Override
    void handleMessage() {
        System.out.println("Handler3 handleMessage before");
        handleNext();
        System.out.println("Handler3 handleMessage after");
    }
}
