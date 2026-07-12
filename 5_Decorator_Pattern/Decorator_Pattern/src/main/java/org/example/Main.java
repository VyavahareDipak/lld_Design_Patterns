package org.example;

import org.example.decorator.GunAbility;
import org.example.decorator.HeightUp;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Character mario = new HeightUp(new GunAbility(new Mario())) ;
        System.out.println(mario.getAbilities()) ;
    }
}