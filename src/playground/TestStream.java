package playground;

import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class TestStream {
//    public static void main(String[] args) {
//        final IntStream str = stream();
//        System.out.println(str);
//    }
//
//    public static IntStream stream() {
//        return IntStream.of(2, 3, 5, 7, 11, 13, 17);
//    }
//}

public class TestStream {

    public static void main(String[] args) {
        // Create a stream of numbers
        Stream<Integer> numbers = xander();

        // Print the first 10 numbers in the stream
        numbers.limit(10).forEach(System.out::println);
    }

    static Stream<Integer> xander() {
        // Create an infinite loop
        while (true) {
            // Find the next prime number
            int prime = findNextPrime();

            // If the prime number is found, yield it
            if (prime != -1) {
                //yield prime;
            }
        }
    }

    static int findNextPrime() {
        // Start with the number 2
        int number = 2;

        // Loop until a prime number is found
        while (true) {
            // Check if the number is prime
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            // If the number is prime, return it
            if (isPrime) {
                return number;
            }

            // Otherwise, increment the number and try again
            number++;
        }
    }


}


