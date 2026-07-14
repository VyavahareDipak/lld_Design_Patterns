package org.example.command;

import org.example.receiver.Light;

public class TurnOffLight implements Command{

    Light light ;

    public TurnOffLight(Light l){
        light=l;
    }
    @Override
    public void execute() {
        light.off();
    }
}
