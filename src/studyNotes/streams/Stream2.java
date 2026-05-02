package studyNotes.streams;

import java.util.ArrayList;
import java.util.Optional;

public class Stream2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        productObj.ifPresent(integer -> System.out.println("Product as Optional: " + integer));

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as int: " + product);
    }
}
