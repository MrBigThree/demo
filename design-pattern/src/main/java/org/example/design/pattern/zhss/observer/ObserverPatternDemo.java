package org.example.design.pattern.zhss.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/17
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();

        Subject subject = new Subject();
        subject.addObserver(observerA);
        subject.addObserver(observerB);

        subject.changeState(2);

    }

}


interface Observer {
    void update(Subject subject);
}

class ObserverA implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println("观察者A监听到变化" + subject.getState());
    }
}

class ObserverB implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println("观察者B听到变化" + subject.getState());
    }
}


class Subject {
    List<Observer> observerList = new ArrayList<>();

    private int state = 0;

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void changeState(int state) {
        this.state = state;
        System.out.println("状态改变");
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }

    public int getState() {
        return state;
    }
}




