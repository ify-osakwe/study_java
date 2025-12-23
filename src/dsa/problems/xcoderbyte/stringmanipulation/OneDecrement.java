package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE ONE DECREMENTED CHALLENGE              *
 *                                                              *
 * Problem Statement                                            *
 * Have the function OneDecremented(str) count how many times a *
 * digit appears that is exactly one less than the previous     *
 * digit. For example: if str is "5655984" then your program    *
 * should return 2 because 5 appears directly after 6 and 8     *
 * appears directly after 9. The input will always contain at   *
 * least 1 digit.	                                        *
 *                                                              *
 * Examples                                                     *
 * Input 1: "56"                                                *
 * Output 1: 0                                                  *
 *                                                              *
 * Input 2: "9876541110"                                        *
 * Output 2: 6                                                  *
 *                                                              *
 ***************************************************************/
public class OneDecrement {
    public static void main(String[] args) {
        System.out.println(oneDecremented("56")); // Output: 0
        System.out.println(oneDecremented("9876541110")); // Output: 6
        System.out.println(oneDecremented("5655984")); // Output: 2
    }

    public static int oneDecremented(String str) {
        int count = 0;

        for (int i = 1; i < str.length(); i++) {
            int currentDigit = Character.getNumericValue(str.charAt(i));
            int previousDigit = Character.getNumericValue(str.charAt(i - 1));

            if (currentDigit == previousDigit - 1) {
                count++;
            }
        }
        return count;
    }
}
