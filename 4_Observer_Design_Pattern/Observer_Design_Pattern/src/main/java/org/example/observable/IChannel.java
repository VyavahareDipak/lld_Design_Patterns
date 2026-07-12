package org.example.observable;

import org.example.observer.ISubscriber;

import java.util.List;

public interface IChannel {

    public void subscribe(ISubscriber subscriber) ;
    public void unSibscibe(ISubscriber subscriber);
    public void notifysubscribers();

}
