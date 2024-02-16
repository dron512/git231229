package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Main5 {

    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.of(2020,4,25,11,20);
        LocalDateTime flight1 = LocalDateTime.of(2020,5,25,11,40);
        LocalDateTime flight2 = LocalDateTime.of(2020,5,30,11,20);

        LocalDateTime myFlight;
        if(flight1.isBefore(flight2))
            myFlight = flight1;
        else
            myFlight = flight2;

        System.out.println(myFlight);

        Period period = Period.between(today.toLocalDate(),myFlight.toLocalDate());
        System.out.println(period);

        Duration duration = Duration.between(today.toLocalTime(),myFlight.toLocalTime());
        System.out.println(duration);
    }
}
