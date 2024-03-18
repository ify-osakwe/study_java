package timBulchalka.codingExercise;

public class Exercise26 {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(21)); // Should print 7
        System.out.println(getLargestPrime(45)); // Should print 5
        System.out.println(getLargestPrime(217)); // Should print 31
        System.out.println(getLargestPrime(0)); // Should print -1
        System.out.println(getLargestPrime(1)); // Should print -1
        System.out.println(getLargestPrime(-1)); // Should print -1
    }

    public static int getLargestPrime(int number) {
        if (number <= 1) {
            return -1;
        }

        int largestPrime = -1;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    largestPrime = i;
                }
            }
        }

        return largestPrime;
    }
}

