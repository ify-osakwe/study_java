package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE BINARY REVERSAL CHALLENGE              *
 *                                                              *
 * Problem Statement                                            *
 * Have the function BinaryReversal(str) take the str parameter *
 * being passed, which will be a positive integer, take its     *
 * binary representation (padded to the nearest N * 8 bits),    *
 * reverse that string of bits, and then finally return the new *
 * reversed string in decimal form. For example: if str is "47" *
 * then the binary version of this integer is 101111 but we pad *
 * it to be 00101111. Your program should reverse this binary   *
 * string which then becomes: 11110100 and then finally return  *
 * the decimal version of this string, which is 244.            *
 *                                                              *
 * Examples                                                     *
 * Input 1: "213"                                               *
 * Output 1: 171                                                *
 *                                                              *
 * Input 2: "4567"                                              *
 * Output 2: 60296                                              *
 ***************************************************************/
public class BinaryReversal {

    public static void main(String[] args) {
        System.out.println(binaryReversal("47"));   // Output: 244
        System.out.println(binaryReversal("213"));  // Output: 171
        System.out.println(binaryReversal("4567")); // Output: 60296
    }

    public static int binaryReversal(String str) {
        // Parse the string to an integer
        int num = Integer.parseInt(str);

        // Convert the number to a binary string
        String binaryString = Integer.toBinaryString(num);

        // Pad the binary string to the nearest 8 bits
        int paddingLength = 8 - (binaryString.length() % 8);
        if (paddingLength != 8) {
            binaryString = "0".repeat(paddingLength) + binaryString;
        }

        // Reverse the binary string
        String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();

        // Convert the reversed binary string back to an integer
        return Integer.parseInt(reversedBinaryString, 2);
    }
}
