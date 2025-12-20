package dsa.problems.binarybit;

import java.util.Arrays;

/**
 * Count Bits
 * <a href="https://gemini.google.com/share/0faa2f07693d">Gemini Link</a>
 */
public class CountingBits {
    public static int[] countBits(int n) {
        // Create the result array of size n + 1
        int[] ans = new int[n + 1];

        // Base case: 0 has 0 bits (int arrays default to 0, but being explicit helps clarity)
        ans[0] = 0;

        // Iterate from 1 to n to fill the array
        for (int i = 1; i <= n; i++) {
            // ans[i >> 1]: Retrieve count for i/2
            // (i & 1): Add 1 if i is odd, 0 if even
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example 1
        int n1 = 2;
        int[] result1 = countBits(n1);
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + Arrays.toString(result1));
        // Expected: [0, 1, 1]

        System.out.println("-----------------");

        // Example 2
        int n2 = 5;
        int[] result2 = countBits(n2);
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + Arrays.toString(result2));
        // Expected: [0, 1, 1, 2, 1, 2]

        System.out.println("-----------------");

        // Example 3 (Larger number to demonstrate functionality)
        int n3 = 10;
        int[] result3 = countBits(n3);
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + Arrays.toString(result3));
        // Manual check for 10 (1010 binary): Should be 2
    }
}
