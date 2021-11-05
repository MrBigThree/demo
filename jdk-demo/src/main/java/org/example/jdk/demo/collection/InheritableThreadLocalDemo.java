package org.example.jdk.demo.collection;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/5/7
 */
public class InheritableThreadLocalDemo {

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set("test");
        String s2 = threadLocal.get();
        System.out.println(s2);
        new Thread(() -> {
            threadLocal.set("test");
            String s3 = threadLocal.get();
            System.out.println(s3);
        }).start();
//        inheritableThreadLocal.set("test");
//        String s = inheritableThreadLocal.get();
//        System.out.println(s);
//        System.out.println(Thread.currentThread());
//        new Thread(() -> {
//            System.out.println(Thread.currentThread());
//            String s1 = inheritableThreadLocal.get();
//            System.out.println(s1);
//        }).start() ;
    }

}
