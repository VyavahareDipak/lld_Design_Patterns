package org.example.decorator;

import org.example.Character;

public class GunAbility extends Decorator{

    public  GunAbility(Character ch){
        super(ch);
    }
    @Override
    public String getAbilities() {
        return ch.getAbilities() + " fire" ;
    }
}
