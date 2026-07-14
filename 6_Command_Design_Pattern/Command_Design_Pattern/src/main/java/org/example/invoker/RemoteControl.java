package org.example.invoker;

import org.example.command.Command;

public class RemoteControl {

    Command c ;

    public void setCommand(Command c){
        this.c = c ;

    }

    public void pressButton(){
        c.execute();
    }
}
