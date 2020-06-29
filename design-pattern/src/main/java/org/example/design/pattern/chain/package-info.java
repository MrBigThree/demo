/**
 * Avoid coupling the sender of a request to its receiver by giving more than one object
 * a chance to handle the request.
 * Chain the receiving objects and pass the request along the chain until an object handles it.
 *
 * <p>
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系，将这些对象连成一条链，
 * 并沿着这条链传递该请求，传递过程中可以决定是否传递给下一节点，可以一直传递到最后一个节点，也可以在其中某个节点中断。
 * </p>
 * <p>
 * JavaEE 中 Filter 就是使用的责任链模式,很多框架也都使用了责任链框架，如 Mybatis 中的 plugin,JFinal 中的 handler 和 interceptor 等
 * </p>
 */
package org.example.design.pattern.chain;