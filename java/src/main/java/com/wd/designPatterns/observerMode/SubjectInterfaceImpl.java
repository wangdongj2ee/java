package com.wd.designPatterns.observerMode;

import java.util.ArrayList;
import java.util.List;

public class SubjectInterfaceImpl implements SubjectInterface{

    private List<ObserverInterface> observerInterfaceList = new ArrayList<>();

    @Override
    public void addObserver(ObserverInterface observerInterface) {
        observerInterfaceList.add(observerInterface);
    }

    @Override
    public void removeObserver(ObserverInterface observerInterface) {
        observerInterfaceList.remove(observerInterface);
    }

    @Override
    public void notice(Object obj) {
        observerInterfaceList.forEach(observer -> {
            observer.notice(obj);
        });
    }
}
