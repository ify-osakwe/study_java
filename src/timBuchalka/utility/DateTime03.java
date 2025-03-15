package timBuchalka.utility;

import timBuchalka.UtilsX;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;

public class DateTime03 {
    public static void main(String[] args) {
        UtilsX.newLineSpace();
        ZonedDateTime myLocationTime = ZonedDateTime.now();
        System.out.println("My Location Time " + myLocationTime + "\n");

        Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
        LocalDateTime dob =
                LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, LA time = " + dob.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobSydney = ZonedDateTime.ofInstant(dobInstant,
                ZoneId.of("Australia/Sydney"));
        System.out.println("Your kid's birthdate, Sydney Time = " + dobSydney.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobHere = dobSydney.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, Here Time = " + dobHere.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        UtilsX.newLineSpace();

        ZonedDateTime firstOfMonth = ZonedDateTime.now()
                .with(TemporalAdjusters.firstDayOfNextMonth());
        //System.out.printf("First of next Month = %tD %n", firstOfMonth);
        System.out.println("First of next Month: " + firstOfMonth.format(
                DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("First of next Month: " + firstOfMonth.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println("First of next Month: " + firstOfMonth.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
        System.out.println("First of next Month: " + firstOfMonth.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println("First of next Month: " + firstOfMonth.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

        UtilsX.newLineSpace();
        Period timePast = Period.between(LocalDate.EPOCH, dob.toLocalDate());
        System.out.println(timePast);

        Duration timeSince =
                Duration.between(Instant.EPOCH, dob.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince);
        UtilsX.newLineSpace();

        LocalDateTime dob2 = dob.plusYears(2).plusMonths(4)
                .plusDays(4).plusHours(7).plusMinutes(14)
                .plusSeconds(37);

        System.out.println("Your 2nd kid's birthdate, Here Time = " + dob2.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        Period timePast2 = Period.between(LocalDate.EPOCH, dob2.toLocalDate());
        System.out.println(timePast2);

        Duration timeSince2 =
                Duration.between(Instant.EPOCH, dob2.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince2);
        UtilsX.newLineSpace();
    }
}
