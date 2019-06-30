package com.wd.designPatterns.observerMode;

public interface SubjectInterface {

    void addObserver(ObserverInterface observerInterface);

    void removeObserver(ObserverInterface observerInterface);

    void notice(Object obj);
}
