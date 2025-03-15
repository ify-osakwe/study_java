package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE DASH INSERT CHALLENGE                  *
 *                                                              *
 * Problem Statement                                            *
 * Have the function DashInsert(str) insert dashes ('-')        *
 * between each two odd numbers in str. For example: if str is  *
 * 454793 the output should be 4547-9-3. Don't count zero as an *
 * odd number.                                                  *
 *                                                              *
 * Examples                                                     *
 * Input 1: 99946                                               *
 * Output 1: 9-9-946                                            *
 *                                                              *
 * Input 2: 56730                                               *
 * Output 2: 567-30                                             *
 ***************************************************************/
public class DashInsert {

    public static void main(String[] args) {
        System.out.println(dashInsert("454793")); // Output: 4547-9-3
        System.out.println(dashInsert("99946"));  // Output: 9-9-946
        System.out.println(dashInsert("56730"));  // Output: 567-30
    }


    public static String dashInsert(String str) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < str.length(); index++) {
            result.append(str.charAt(index));

            // Check if both the current and next characters are odd numbers
            if (index < str.length() - 1) {
                int currentDigit = Character.getNumericValue(str.charAt(index));
                int nextDigit = Character.getNumericValue(str.charAt(index + 1));

                if (isOdd(currentDigit) && isOdd(nextDigit)) {
                    result.append('-');
                }
            }
        }
        return result.toString();
    }

    // Helper method to check if a number is odd
    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
