package playground;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestStream2 {
    public static IntStream stream() {
        // TODO: make this stream endless
        //return IntStream.of(2, 3, 5, 7, 11, 13, 17);
        return IntStream.iterate(2, TestStream2::nextPrime);
    }

    private static int nextPrime(int current) {
        int next = current + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestStream2.stream()
                .limit(20)  // Limit the stream to the first 20 prime numbers
                .forEach(System.out::println);
    }
}

