package timBuchalka.utility;

import timBuchalka.UtilsX;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

public class DateTime01 {
    public static void main(String[] args) {
        LocalDate May5 = LocalDate.parse("2022-05-05");

        May5.datesUntil(May5.plusDays(7))
                .forEach(System.out::println);
        May5.datesUntil(May5.plusYears(1), Period.ofDays(7))
                .forEach(System.out::println);

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        LocalTime sevenAM = LocalTime.of(7, 0);
        System.out.println(sevenAM);

        LocalTime sevenThirty = LocalTime.of(7, 30, 15);
        System.out.println(sevenThirty);
        UtilsX.newLine();

        LocalTime sevenPM = LocalTime.parse("19:00");
        LocalTime sevenThirtyPM = LocalTime.parse("19:30:15.1000");
        System.out.println(sevenPM.get(ChronoField.AMPM_OF_DAY));
        System.out.println(sevenThirtyPM.get(ChronoField.AMPM_OF_DAY));

        System.out.println(sevenThirtyPM.getHour());
        System.out.println(sevenThirtyPM.plusHours(24));

        System.out.println(sevenPM.range(ChronoField.HOUR_OF_DAY));
        System.out.println(sevenPM.range(ChronoField.MINUTE_OF_HOUR));
        System.out.println(sevenPM.range(ChronoField.MINUTE_OF_DAY));
        System.out.println(sevenPM.range(ChronoField.SECOND_OF_MINUTE));
        System.out.println(sevenPM.range(ChronoField.SECOND_OF_DAY));

        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println(todayAndNow);

        LocalDateTime May5Noon = LocalDateTime.of(2022, 5, 5,
                12, 0);

        System.out.printf("%tD %tr %n", May5Noon, May5Noon);
        System.out.printf("%1$tF %1$tT %n", May5Noon);

        System.out.println(todayAndNow.format(DateTimeFormatter.ISO_WEEK_DATE));

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(May5Noon.format(dtf));

        System.out.println(May5Noon.format(DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.MEDIUM)));

        LocalDateTime May6Noon = May5Noon.plusHours(24);
        System.out.println(May6Noon.format(DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.MEDIUM)));
    }
}
