package org.example;

import org.example.command.Command;
import org.example.command.TurnOffLight;
import org.example.command.TurnOnLight;
import org.example.invoker.RemoteControl;
import org.example.receiver.Light;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Light l = new Light() ;
        Command c = new TurnOnLight(l)  ;

        RemoteControl remote = new RemoteControl() ;
        remote.setCommand(c);

        remote.pressButton();

        c= new TurnOffLight(l);
        remote.setCommand(c);
        remote.pressButton();
    }
}