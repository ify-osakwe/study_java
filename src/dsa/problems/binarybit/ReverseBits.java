package dsa.problems.binarybit;

/**
 * Reverse Bits
 * <a href="https://gemini.google.com/share/2816f5674ba1">Gemini Link</a>
 */
public class ReverseBits {

    private static int reverseBits(int n) {
        int result = 0;

        // We iterate exactly 32 times because the input is a 32-bit integer.
        for (int i = 0; i < 32; i++) {

            // 1. Shift the result to the left to make room for the new bit.
            //    Note: On the first iteration, this shifts 0, which remains 0.
            result = result << 1;

            // 2. Get the Least Significant Bit (LSB) of n.
            //    If (n & 1) is 1, the last bit is 1. If 0, it's 0.
            if ((n & 1) == 1) {
                result++; // or result = result | 1;
            }

            // 3. Shift n to the right to process the next bit in the next iteration.
            //    We use >> (signed shift), but >>> (logical shift) works too
            //    since we only care about the bits moving down.
            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int n1 = 43261596;
        int result1 = reverseBits(n1);

        System.out.println("Example 1:");
        System.out.println("Input:  " + n1);
        System.out.println("Binary Input:  " + String.format("%32s", Integer.toBinaryString(n1)).replace(' ', '0'));
        System.out.println("Output: " + result1);
        System.out.println("Binary Output: " + String.format("%32s", Integer.toBinaryString(result1)).replace(' ', '0'));
        System.out.println("Matches 964176192? " + (result1 == 964176192));
        System.out.println();

        // Example 2
        int n2 = 2147483644;
        int result2 = reverseBits(n2);

        System.out.println("Example 2:");
        System.out.println("Input:  " + n2);
        System.out.println("Binary Input:  " + String.format("%32s", Integer.toBinaryString(n2)).replace(' ', '0'));
        System.out.println("Output: " + result2);
        System.out.println("Binary Output: " + String.format("%32s", Integer.toBinaryString(result2)).replace(' ', '0'));
        System.out.println("Matches 1073741822? " + (result2 == 1073741822));
    }
}
