package timBuchalka.codingExercise;

public class Exercise18 {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456)); // Sum of even digits is 2 + 4 + 6 = 12
        System.out.println(getEvenDigitSum(13579)); // No even digits, returns 0
        System.out.println(getEvenDigitSum(24680)); // Sum of even digits is 2 + 4 + 6 + 0 = 12
        System.out.println(getEvenDigitSum(-123456)); // Invalid value, returns -1
        System.out.println(getEvenDigitSum(0)); // Single digit, but even, returns 0
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) return -1;

        int sum = 0;

        while (number > 0) {
            int digit = number % 10; // Extract the last digit
            if (digit % 2 == 0) {
                sum += digit; // Add the even digit to the sum
            }
            number /= 10; // Move to the next digit
        }

        return sum;
    }
}
