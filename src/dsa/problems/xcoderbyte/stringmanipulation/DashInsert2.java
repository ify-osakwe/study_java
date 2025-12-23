package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE DASH INSERT TWO CHALLENGE              *
 *                                                              *
 * Problem Statement                                            *
 * Have the function DashInsertII(str) insert dashes ('-')      *
 * between each two odd numbers and insert asterisks ('*')      *
 * between each two even numbers in str.                        *
 *                                                              *
 * For example: if str is 4546793 the output should be          *
 * 454*67-9-3. Don't count zero as an odd or even number.       *
 *                                                              *
 * Examples                                                     *
 * Input 1: 99946                                               *
 * Output 1: 9-9-94*6                                           *
 *                                                              *
 * Input 2: 56647304                                            *
 * Output 2: 56*6*47-304                                        *
 ***************************************************************/

public class DashInsert2 {
    public static void main(String[] args) {
        System.out.println(dashInsertII("4546793"));  // Output: 454*67-9-3
        System.out.println(dashInsertII("99946"));    // Output: 9-9-94*6
        System.out.println(dashInsertII("56647304")); // Output: 56*6*47-304
        System.out.println(dashInsertII("03443")); // Output: 034*43
    }

    public static String dashInsertII(String str) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < str.length(); index++) {
            result.append(str.charAt(index));

            // Ensure we're not at the last character
            if (index < str.length() - 1) {
                int currentDigit = Character.getNumericValue(str.charAt(index));
                int nextDigit = Character.getNumericValue(str.charAt(index + 1));

                // Insert dash if both are odd numbers
                if (isOdd(currentDigit) && isOdd(nextDigit)) {
                    result.append('-');
                }
                // Insert asterisk if both are even numbers
                else if (isEven(currentDigit) && isEven(nextDigit)) {
                    result.append('*');
                }
            }
        }
        return result.toString();
    }

    // Helper method to check if a number is odd
    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    // Helper method to check if a number is even
    private static boolean isEven(int num) {
        return num % 2 == 0 && num != 0;
    }
}
