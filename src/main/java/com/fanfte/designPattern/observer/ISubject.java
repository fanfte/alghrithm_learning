package com.fanfte.designPattern.observer;



public interface ISubject {

    void registObserver(Observer o);

    void unregistObserver(Observer o);

    void notifyObservers();
}
