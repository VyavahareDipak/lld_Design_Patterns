package org.example.decorator;

import org.example.Character;

public abstract class Decorator implements Character {

    Character ch ;

    public Decorator(Character ch){
        this.ch = ch ;
    }

}
