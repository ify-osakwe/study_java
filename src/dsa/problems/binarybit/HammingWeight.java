package dsa.problems.binarybit;

/**
 * Hamming Weight
 * <a href="https://gemini.google.com/share/e7fee072af12">Gemini Link</a>
 */
public class HammingWeight {

    /**
     * Approach 1: Brian Kernighan's Algorithm
     * Efficiently counts set bits by repeatedly flipping the least significant 1-bit to 0.
     * * Time Complexity: O(k) where k is the number of 1s.
     * Space Complexity: O(1)
     * * @param n The positive integer input
     *
     * @return The number of set bits
     */
    public static int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1); // removes the rightmost set bit
            count++;
        }

        return count;
    }

    // A lookup table to store the bit count for every number from 0 to 255.
    private static final int[] LOOKUP_TABLE = new int[256];

    // Static block to initialize the table when the class is loaded.
    static {
        for (int i = 0; i < 256; i++) {
            // Calculate bits for 8-bit numbers using the standard method
            // or built-in function to populate the table.
            LOOKUP_TABLE[i] = (i & 1) + LOOKUP_TABLE[i / 2];
        }
    }

    /**
     * Approach 2: Lookup Table (Optimization)
     * Splits the 32-bit integer into four 8-bit chunks and sums their pre-computed bit counts.
     * This is ideal if the function is called millions of times.
     * * Time Complexity: O(1) - exactly 4 array accesses and bitwise ops.
     * Space Complexity: O(1) - fixed size array of 256 integers.
     */
    public static int hammingWeightOptimized(int n) {
        // Mask 0xff gets the last 8 bits
        // We assume n is treated as 32-bit.

        return LOOKUP_TABLE[n & 0xff] +
                LOOKUP_TABLE[(n >>> 8) & 0xff] +
                LOOKUP_TABLE[(n >>> 16) & 0xff] +
                LOOKUP_TABLE[(n >>> 24) & 0xff];
    }

    public static void main(String[] args) {
        int[] testCases = {11, 128, 2147483645};

        System.out.println("--- Testing Brian Kernighan's Algorithm ---");
        for (int n : testCases) {
            int result = hammingWeight(n);
            printResult(n, result);
        }

        System.out.println("\n--- Testing Optimized Lookup Table ---");
        for (int n : testCases) {
            int result = hammingWeightOptimized(n);
            printResult(n, result);
        }
    }

    private static void printResult(int n, int result) {
        // Using Integer.toBinaryString to visualize
        System.out.printf("Input: %-12d | Binary: %32s | Set Bits: %d%n",
                n, Integer.toBinaryString(n), result);
    }
}
