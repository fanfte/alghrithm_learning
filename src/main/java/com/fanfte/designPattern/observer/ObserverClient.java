package com.fanfte.designPattern.observer;

import javax.security.auth.Subject;

public class ObserverClient {

    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();
        Observer o1 = new ConcreteObserver("John");
        Observer o2 = new ConcreteObserver("Mary");
        Observer o3 = new ConcreteObserver("peter");

        subject.registObserver(o1);
        subject.registObserver(o2);
        subject.registObserver(o3);

        subject.notifyObservers();

        subject.unregistObserver(o2);
        subject.notifyObservers();
    }
}
