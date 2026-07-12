package org.example.decorator;

import org.example.Character;

public class HeightUp extends Decorator{
    public HeightUp(Character ch){
        super(ch);
    }
    @Override
    public String getAbilities() {
        return this.ch.getAbilities() + " height up" ;
    }
}
