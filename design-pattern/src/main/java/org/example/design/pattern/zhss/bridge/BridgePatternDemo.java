package org.example.design.pattern.zhss.bridge;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new RefineAbstraction(implementor);
        abstraction.execute();

       // abstraction 要调用implementor 的接口，调用的时候，实际上是面向implementor的接口去编程和调用的

        //abstraction调用implementor就是基于一个桥去地啊耦哦那个的
        //不是说abstraction直接面向implementor的实现类去编程的，面向implementor接口去编程的
        // 所有abstraction和implementor之间的桥，就是implementor接口
        //这个一个代码组件面向另外一个代码组件的接口来编程，就是将接口作为一个桥
        //使用桥接的设计模式来进行编程（也就是说，当我们面向接口编程的时候，我们就使用了桥接模式）
    }


    public interface Implementor {
        void execute();
    }

    public static class ConcreteImplementor implements Implementor {

        @Override
        public void execute() {
            System.out.println("执行了功能逻辑");
        }
    }

    public static abstract class Abstraction {
        protected Implementor implementor;

        public Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void execute();

    }

    public static class RefineAbstraction extends Abstraction {

        public RefineAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void execute() {
            implementor.execute();
        }
    }

}


