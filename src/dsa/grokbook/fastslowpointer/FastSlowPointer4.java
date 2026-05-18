package dsa.grokbook.fastslowpointer;

/**
 * Happy Number (medium).
 * Any number will be called a happy number if, after repeatedly replacing it with
 * a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’.
 * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 */
public class FastSlowPointer4 {
    public static void main(String[] args) {
        int num1 = 23; // output : true
        // 2^2 + 3^2 = 4 + 9 = 13
        // 1^2 + 3^2 = 1 + 9 = 10
        // 1^2 + 0^2 = 1 + 0 = 1
        // a non-happy number will not reduce to 1

        int num2 = 12; // output : false

        System.out.println("Is " + num1 + " a happy number? " + findHappy(num1));
        System.out.println("Is " + num2 + " a happy number? " + findHappy(num2));
    }

    // time complexity O(logN)
    // space complexity O(1)
    private static boolean findHappy(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast); // found the cycle
        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
