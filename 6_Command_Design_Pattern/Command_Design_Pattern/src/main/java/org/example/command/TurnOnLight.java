package org.example.command;

import org.example.receiver.Light;

public class TurnOnLight implements Command{

    Light light ;

    public TurnOnLight(Light l){
        light = l ;
    }
    @Override
    public void execute() {
        light.on();
    }
}
