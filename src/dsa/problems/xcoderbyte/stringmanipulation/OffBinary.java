package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *               CODERBYTE OFF BINARY CHALLENGE                 *
 *                                                              *
 * Problem Statement                                            *
 * Have the function OffBinary(strArr) read the array of strings*
 * stored in strArr, which will contain two elements, the first *
 * will be a positive decimal number and the second element will*
 * be a binary number. Your goal is to determine how many digits*
 * in the binary number need to be changed to represent the     *
 * decimal number correctly (either 0 change to 1 or vice versa)*
 *                                                              *
 * For example: if strArr is ["56", "011000"] then your program *
 * should return 1 because only 1 digit needs to change in the  *
 * binary number (the first zero needs to become a 1) to        *
 * correctly represent 56 in binary.                            *
 *                                                              *
 * Examples                                                     *
 * Input 1: ["5624", "0010111111001"]                           *
 * Output 1: 2                                                  *
 *                                                              *
 * Input 2: ["44", "111111"]                                    *
 * Output 2: 3                                                  *
 *                                                              *
 ***************************************************************/
public class OffBinary {
    public static void main(String[] args) {
        System.out.println(offBinary(new String[] {"5624", "0010111111001"})); // Output: 2
        System.out.println(offBinary(new String[] {"44", "111111"})); // Output: 3
    }

    public static int offBinary(String[] strArr) {
        // Convert the first element (decimal number) to an integer
        int decimalNumber = Integer.parseInt(strArr[0]);

        // Convert the decimal number to its binary string representation
        String decimalInBase2 = Integer.toBinaryString(decimalNumber);

        // The second element is the provided binary string
        String givenBinary = strArr[1];

        // If the provided binary string is shorter, pad it with leading zeros
        while (decimalInBase2.length() > givenBinary.length()) {
            givenBinary = "0" + givenBinary;
        }

        // If the provided binary string is longer, pad the correct binary with leading zeros
        while (givenBinary.length() > decimalInBase2.length()) {
            decimalInBase2 = "0" + decimalInBase2;
        }

        // Count the number of differing digits
        int changesNeeded = 0;
        for (int i = 0; i < decimalInBase2.length(); i++) {
            if (decimalInBase2.charAt(i) != givenBinary.charAt(i)) {
                changesNeeded++;
            }
        }

        return changesNeeded;
    }

    public static int offBinary2(String[] strArr) {
        int decimalNumber = Integer.parseInt(strArr[0]);
        StringBuilder decimalInBase2 = new StringBuilder(Integer.toBinaryString(decimalNumber));
        StringBuilder givenBinary = new StringBuilder(strArr[1]);

        // If the provided binary string is shorter, pad it with leading zeros
        while (decimalInBase2.length() > givenBinary.length()) {
            givenBinary.insert(0, "0");
        }

        // If the provided binary string is longer, pad the correct binary with leading zeros
        while (givenBinary.length() > decimalInBase2.length()) {
            decimalInBase2.insert(0, "0");
        }

        // Count the number of differing digits
        int changesNeeded = 0;
        for (int i = 0; i < decimalInBase2.length(); i++) {
            if (decimalInBase2.charAt(i) != givenBinary.charAt(i)) {
                changesNeeded++;
            }
        }

        return changesNeeded;
    }
}
