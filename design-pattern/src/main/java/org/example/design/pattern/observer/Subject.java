package org.example.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 被观察者
 * @author:lvxuhong
 * @date:2020/7/6
 */
public abstract class Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    protected void notifyAllObservers() {
        for (Observer observer : this.observerList) {
            observer.update();
        }
    }
}

