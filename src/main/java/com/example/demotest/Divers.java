package com.example.demotest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.TimeZone;

public class Divers {

    public static void main(String[] args) {

        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));

        //ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDate d1 = LocalDate.of(2024, 3, 31);
        LocalDate d2 = LocalDate.of(2024, 4, 1);
        Duration duration = Duration.between(d1.atStartOfDay(zoneId).toInstant(), d2.atStartOfDay(zoneId).toInstant());

        System.out.println("************ INSTANT **************");
        System.out.println(d1.atStartOfDay(zoneId).toInstant());
        System.out.println(d2.atStartOfDay(zoneId).toInstant());

        //Date from = Date.from(d1.atStartOfDay(zoneId).toInstant());
        Date from = Date.from(d1.atStartOfDay().atZone(zoneId).toInstant());
        //Date to = Date.from(d2.atStartOfDay(zoneId).toInstant());
        Date to = Date.from(d2.atStartOfDay().atZone(zoneId).toInstant());
        System.out.println("************ FROM **************");
        System.out.println(from);
        System.out.println(to);

        Duration duration2 = Duration.between(from.toInstant(), to.toInstant());

        System.out.println(duration.abs().toDays());
        System.out.println(duration2.abs().toDays());
    }
}
