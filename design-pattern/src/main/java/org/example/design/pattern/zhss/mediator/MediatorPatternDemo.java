package org.example.design.pattern.zhss.mediator;

/**
 * @description: 中介者模式
 * 用一个中介者对象来封装各个对象之间的交互，中介者使各个对象之间不需要显式的引用彼此，从而达到松耦合的目的。
 * 最好的例子式，MQ消息中间件，
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {

        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        Mediator mediator = new Mediator(sender, receiver);
        sender.setMediator(mediator);
        receiver.setMediator(mediator);

        sender.sendMsg("hello world");
    }

}


/**
 * 中介者
 */
class Mediator {

    private Sender sender;

    private Receiver receiver;

    public Mediator(Sender sender, Receiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public void sendMessage(String message) {
        System.out.println("中介者接收到了消息" + message);
        receiver.receiveMsg(message);
    }
}

class Sender {

    public Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMsg(String message) {
        System.out.println("发送消息 ：  " + message);
        mediator.sendMessage(message);
    }
}

class Receiver {

    public Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void receiveMsg(String message) {
        System.out.println("接收消息 ：  " + message);
    }
}
