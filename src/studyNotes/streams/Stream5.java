package studyNotes.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmailClass {
    String name;
    String phonenum;
    String email;

    NamePhoneEmailClass(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhoneClass {
    String name;
    String phonenum;

    NamePhoneClass(String n, String p) {
        name = n;
        phonenum = p;
    }
}

public class Stream5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmailClass> myList = new ArrayList<>();
        myList.add(new NamePhoneEmailClass("Larry", "555-5555",
                "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmailClass("James", "555-4444",
                "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmailClass("Mary", "555-3333",
                "Mary@HerbSchildt.com"));

        // Map just the names and phone numbers to a new stream.
        Stream<NamePhoneClass> nameAndPhone = myList.stream().map(
                (a) -> new NamePhoneClass(a.name, a.phonenum)
        );

        // Use collect to create a List of the names and phone numbers.
        List<NamePhoneClass> npList = nameAndPhone.collect(Collectors.toList());
        System.out.println("Names and phone numbers in a List:");
        for (NamePhoneClass e : npList)
            System.out.println(e.name + ": " + e.phonenum);

        // Obtain another mapping of the names and phone numbers.
        nameAndPhone = myList.stream().map(
                (a) -> new NamePhoneClass(a.name, a.phonenum)
        );

        // Now, create a Set by use of collect().
        Set<NamePhoneClass> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nNames and phone numbers in a Set:");
        for (NamePhoneClass e : npSet)
            System.out.println(e.name + ": " + e.phonenum);
    }
}
