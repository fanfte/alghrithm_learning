package com.fanfte.designPattern.observer;

import java.util.HashSet;
import java.util.Set;

public class ConcreteSubject implements ISubject{

    private Set<Observer> observers = new HashSet<>();

    @Override
    public void registObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregistObserver(Observer o) {
        if(o != null && observers != null) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(o.getClass().getName() + "receive message");
        }
    }
}
