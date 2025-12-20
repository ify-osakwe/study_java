package dsa.problems.binarybit;

/**
 * Sum of two integers
 * <a href="https://gemini.google.com/share/b1c0c5c5bb32">Gemini Link</a>
 */
public class SumofTwoIntegers {
    private static int getSum(int a, int b) {
        // Iterate until there is no carry left
        while (b != 0) {
            // Calculate the carry.
            // The AND operator (&) finds bits where both a and b are 1.
            // The left shift (<< 1) moves the carry to the next significant position.
            int carry = (a & b) << 1;

            // Calculate the sum without carry.
            // The XOR operator (^) adds bits where 1+0=1 or 0+1=1, but 1+1=0.
            a = a ^ b;

            // Update b to be the carry, so we can add it in the next iteration.
            b = carry;
        }

        // When b becomes 0, all carries have been processed, and a holds the total sum.
        return a;
    }

    public static void main(String[] args) {
        // Test Case 1
        int a1 = 1;
        int b1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: a = " + a1 + ", b = " + b1);
        System.out.println("Output: " + getSum(a1, b1)); // Expected: 3
        System.out.println();

        // Test Case 2
        int a2 = 2;
        int b2 = 3;
        System.out.println("Test Case 2:");
        System.out.println("Input: a = " + a2 + ", b = " + b2);
        System.out.println("Output: " + getSum(a2, b2)); // Expected: 5
        System.out.println();

        // Test Case 3: Negative numbers
        int a3 = -2;
        int b3 = 3;
        System.out.println("Test Case 3 (Negative + Positive):");
        System.out.println("Input: a = " + a3 + ", b = " + b3);
        System.out.println("Output: " + getSum(a3, b3)); // Expected: 1
        System.out.println();

        // Test Case 4: Larger numbers
        int a4 = 1000;
        int b4 = 1000;
        System.out.println("Test Case 4 (Edge Constraints):");
        System.out.println("Input: a = " + a4 + ", b = " + b4);
        System.out.println("Output: " + getSum(a4, b4)); // Expected: 2000
    }
}
