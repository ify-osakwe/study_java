package studyNotes.streams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
        System.out.println("Original list: " + myList);

        // Obtain a Stream to the array list.
        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer ->
                System.out.println("Minimum value: " + integer));


        // Sort the stream by use of sorted().
        Stream<Integer> sortedStream = myList.stream().sorted();
        // Display the sorted stream by use of forEach().
        System.out.print("Sorted stream: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // Display only the odd values by use of filter().
        Stream<Integer> oddVals = myList.stream().sorted()
                .filter(n -> (n % 2) == 1);
        System.out.print("Odd values: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        oddVals = myList.stream()
                .filter(n -> (n % 2) == 1)
                .filter(n -> n > 5);
        System.out.print("Odd values greater than 5: ");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();

    }
}
