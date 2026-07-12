package org.example.observer;

import org.example.observable.Channel;
import org.example.observable.IChannel;

public class Subscriber implements ISubscriber{

    String name ;
    public Subscriber(String name){
        this.name = name ;
    }
    @Override
    public void update(Channel channel) {
        System.out.println("new video uploaded by " + channel.name + "watch now : " + channel.latestVideo );
    }
}
