package timBulchalka.codingExercise;

public class Exercise23 {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6)); // Should print true
        System.out.println(isPerfectNumber(28)); // Should print true
        System.out.println(isPerfectNumber(496)); // Should print true
        System.out.println(isPerfectNumber(8128)); // Should print true
        System.out.println(isPerfectNumber(-1)); // Should print false
        System.out.println(isPerfectNumber(10)); // Should print false
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) return false;

        int sum = 0;

        // Iterate from 1 to number/2 to find divisors
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i; // Add divisor to sum
            }
        }

        // Check if the sum of divisors equals the number itself
        return sum == number;
    }
}

