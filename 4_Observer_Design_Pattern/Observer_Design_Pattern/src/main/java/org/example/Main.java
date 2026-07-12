package org.example;

import org.example.observable.Channel;
import org.example.observable.IChannel;
import org.example.observer.ISubscriber;
import org.example.observer.Subscriber;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IChannel ch1 = new Channel("CodeWithHarry","claude tutorials") ;

        ISubscriber sub1 = new Subscriber("John") ;
        ISubscriber sub2 = new Subscriber("Robert") ;

        ch1.subscribe(sub1);
        ch1.subscribe(sub2);

        ch1.notifysubscribers();
        ch1.unSibscibe(sub1);
        ch1.notifysubscribers();

    }
}