package org.example.observer;

import org.example.observable.Channel;


public interface ISubscriber {

    public void update(Channel channel) ;
}
