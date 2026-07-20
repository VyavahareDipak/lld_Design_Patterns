package org.example.facade;

import org.example.participants.DVD;
import org.example.participants.SoundSystem;
import org.example.participants.TV;

public class HomeTheaterFacade {

    private TV tv ;
    private DVD dvd ;
    private SoundSystem sound ;

    public HomeTheaterFacade(
            TV tv ,
            DVD dvd ,
            SoundSystem sound
    ){

        this.tv = tv ;
        this.dvd = dvd ;
        this.sound = sound ;


    }

    public void watchMovie(String movie){
        this.tv.on();
        this.sound.on();
        this.dvd.on();

        this.tv.setInput();

        this.sound.setSurroundMode();

        this.dvd.play(movie);
    }
}
