/**
 * <p>
 * Encapsulate a request as an object, thereby allowing
 * for the parameterization of clients with different requests,
 * and the queuing or logging of requests. It also allows for the support of undoable operations
 * </p>
 *
 * <p>
 * 将一个请求封装成一个对象，然后用不同的请求，队列或日志来参数化对象，同时也支持可撤销的操作。
 * 重点在于对于"请求（command）"的封装,执行器不关系command的具体逻辑，只关心自己对命令的调度逻辑
 * </p>
 *
 * <p>
 * java 中的线程池就是这种封装，将线程要执行的动作封装成 {@link java.lang.Runnable} 对象,
 * 执行器 {@link java.util.concurrent.Executor} 的 execute 方法传入 runnable 对象，
 * executor 无需关心 runnable 的实现逻辑，只需要关注线程的调度即可
 * </p>
 */
package org.example.design.pattern.command;