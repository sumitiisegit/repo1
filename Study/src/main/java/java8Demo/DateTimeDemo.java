package java8Demo;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class DateTimeDemo {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        localDate = LocalDate.of(2001,8,31);
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        localTime = LocalTime.of(2,4,6,7);
        System.out.println(localTime);

        localTime = LocalTime.now(ZoneId.of("GMT"));
        System.out.println(localTime);

        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }
}

