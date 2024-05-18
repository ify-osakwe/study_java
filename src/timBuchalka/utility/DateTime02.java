package timBuchalka.utility;

import timBuchalka.UtilsX;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class DateTime02 {
    public static void main(String[] args) {
        //System.setProperty("user.timezone", "America/Los_Angeles");
        System.out.println(ZoneId.systemDefault());
        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        UtilsX.newLine();

        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("US"))
                .sorted()
                .map(ZoneId::of)
                .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));
        UtilsX.newLine();

        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldWay = new HashSet<>(Set.of(alternate));

        oldWay.removeAll(jdk8Zones);
        System.out.println("oldWay: " + oldWay);
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println("BET: " + bet);
        UtilsX.newLine();

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant instantNow = Instant.now();
        System.out.println(instantNow);
        UtilsX.newLine();

        for (ZoneId z : List.of(
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Europe/Paris"),
                ZoneId.of("America/New_York"))) {
            DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("z:zzzz");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(zoneFormat));
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));
        }

    }
}
