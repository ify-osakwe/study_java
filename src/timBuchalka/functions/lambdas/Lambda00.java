package timBuchalka.functions.lambdas;

import timBuchalka.UtilsX;

import java.util.ArrayList;
import java.util.List;

public class Lambda00 {
    public static void main(String[] args) {

        var nameList = new ArrayList<>(List.of("alpha", "bravo", "charlie"));
        // - Lambda
        nameList.forEach((s) -> System.out.println(s));
        UtilsX.newLine();

        nameList.forEach((str) -> {
            char index = str.charAt(0);
            System.out.println(str + " is " + index);
        });
        UtilsX.newLine();

        // - method reference
        nameList.forEach(System.out::println);
        UtilsX.newLine();

        int result = calculator((a, b) -> a + b,5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kraken");

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}

@FunctionalInterface
interface Operation<T> {

    T operate(T value1, T value2);
}
