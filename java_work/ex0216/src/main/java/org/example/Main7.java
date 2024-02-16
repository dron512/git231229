package org.example;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main7 {

    public static void main(String[] args) {

        ZonedDateTime here = ZonedDateTime.now();
        System.out.println(here);

        ZonedDateTime paris = ZonedDateTime
                .of(here.toLocalDateTime(), ZoneId.of("Europe/Paris"));
        System.out.println(paris);

        Duration diff = Duration.between(here, paris);
        System.out.println(diff);

    }

}
