package org.example.observable;

import org.example.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Channel implements IChannel{

    List<ISubscriber> subscribers ;

    public String name ;
    public String latestVideo ;

    public Channel(String name,String latestVideo){
        this.name= name ;
        this.latestVideo = latestVideo ;
    }
    @Override
    public void subscribe(ISubscriber subscriber) {
        if(this.subscribers ==null){
            this.subscribers = new ArrayList<>() ;
        }
        this.subscribers.add(subscriber) ;
    }

    @Override
    public void unSibscibe(ISubscriber subscriber) {
        this.subscribers = this.subscribers.stream().filter(subscriber1 -> !subscriber1.equals(subscriber)).toList();
    }

    @Override
    public void notifysubscribers() {
        this.subscribers.forEach(subscriber -> {
            subscriber.update( this ) ;
        });
    }
}
