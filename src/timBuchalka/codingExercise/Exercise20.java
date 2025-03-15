package timBuchalka.codingExercise;

public class Exercise20 {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71)); // true (last digit 1 is shared)
        System.out.println(hasSameLastDigit(23, 32, 42)); // true (last digit 2 is shared)
        System.out.println(hasSameLastDigit(9, 99, 999)); // false (9 is not within the range)
        System.out.println(hasSameLastDigit(100, 1000, 10000)); // true (last digit 0 is shared)
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false; // Return false if any number is not within the range
        }

        int lastDigit1 = num1 % 10;
        int lastDigit2 = num2 % 10;
        int lastDigit3 = num3 % 10;

        return lastDigit1 == lastDigit2 || lastDigit1 == lastDigit3 || lastDigit2 == lastDigit3;
    }

    // Method to check if a number is within the range of 10 to 1000
    private static boolean isValid(int num) {
        return num >= 10 && num <= 1000;
    }
}
