package org.example.design.pattern.zhss.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: // 一个类产生了一些数据，这些数据可能会变化，但是需要将这些中间数据保存起来，给后面不同的操作使用这些中间数据或者初始数据
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();

        CareTaker careTaker = new CareTaker();
        originator.setState("state #1");
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());

    }

}

/**
 * 保存中间状态的对象
 */
class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}

/**
 * 需要执行的操作和原始对象
 */
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

/**
 * 备忘录容器
 */
class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}



