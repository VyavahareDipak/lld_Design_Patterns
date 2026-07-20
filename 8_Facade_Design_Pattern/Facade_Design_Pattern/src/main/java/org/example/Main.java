package org.example;

import org.example.facade.HomeTheaterFacade;
import org.example.participants.DVD;
import org.example.participants.SoundSystem;
import org.example.participants.TV;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       TV tv = new TV() ;
       SoundSystem sound = new SoundSystem() ;
       DVD dvd = new DVD() ;

        HomeTheaterFacade htf = new HomeTheaterFacade(
                tv,
                dvd,
                sound
        ) ;
        htf.watchMovie("Avengers");
    }
}