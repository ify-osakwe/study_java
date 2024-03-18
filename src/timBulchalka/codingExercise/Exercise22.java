package timBulchalka.codingExercise;

public class Exercise22 {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12, 30)); // Should print 6
        System.out.println(getGreatestCommonDivisor(25, 15)); // Should print 5
        System.out.println(getGreatestCommonDivisor(9, 18)); // Should print -1 (one of the parameters is < 10)
        System.out.println(getGreatestCommonDivisor(81, 153)); // Should print 9
        System.out.println(getGreatestCommonDivisor(100, 45)); // Should print 5
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) return -1;

        int min = Math.min(first, second);
        for (int i = min; i >= 1; i--) {
            // Check if both numbers are divisible by the current value of i
            if (first % i == 0 && second % i == 0) {
                return i; // Return the greatest common divisor
            }
        }
        // If no common divisor is found (other than 1), return 1
        return 1;
    }
}

