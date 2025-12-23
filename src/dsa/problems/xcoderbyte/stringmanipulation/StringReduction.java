package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE STRING REDUCTION CHALLENGE             *
 *                                                              *
 * Problem Statement                                            *
 * Have the function StringReduction(str) take the str parameter*
 * being passed and return the smallest number you can get      *
 * through the following reduction method.                      *
 * The method is: Only the letters a, b, and c will be given in *
 * str and you must take two different adjacent characters and  *
 * replace it with the third. For example "ac" can be replaced  *
 * with "b" but "aa" cannot be replaced with anything.          *
 * This method is done repeatedly until the string cannot be    *
 * further reduced, and the length of the resulting string is   *
 * to be outputted.                                             *
 *                                                              *
 * For example: if str is "cab", "ca" can be reduced to "b"     *
 * and you get "bb" (you can also reduce it to "cc").           *
 * The reduction is done so the output should be 2.             *
 *                                                              *
 * If str is "bcab", "bc" reduces to "a", so you have "aab",    *
 * then "ab" reduces to "c", and the final string "ac" is       *
 * reduced to "b" so the output should be 1.                    *
 *                                                              *
 * Examples                                                     *
 * Input 1: "abcabc"                                            *
 * Output 1: 2                                                  *
 *                                                              *
 * Input 2: cccc                                                *
 * Output 2: 4                                                  *
 ***************************************************************/
public class StringReduction {
    public static void main(String[] args) {
        System.out.println(stringReduction("abcabc"));  // Output: 2
        System.out.println(stringReduction("bcab"));    // Output: 1
        System.out.println(stringReduction("cccc"));    // Output: 4
    }

    public static int stringReduction(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean reduced = true;

        // Keep reducing as long as there are valid pairs to reduce
        while (reduced) {
            reduced = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                char a = sb.charAt(i);
                char b = sb.charAt(i + 1);

                // If adjacent characters are different, reduce them
                if (a != b) {
                    char newChar = reducePair(a, b);
                    // Replace the two characters with the new one
                    sb.replace(i, i + 2, String.valueOf(newChar));
                    reduced = true;  // Continue the reduction process
                    break;  // Start over after making a reduction
                }
            }
        }

        return sb.length();  // Return the final length of the reduced string
    }

    // Helper function to determine the result of reducing two adjacent different characters
    private static char reducePair(char a, char b) {
        if ((a == 'a' && b == 'b') || (a == 'b' && b == 'a')) {
            return 'c';
        } else if ((a == 'b' && b == 'c') || (a == 'c' && b == 'b')) {
            return 'a';
        } else {
            return 'b';  // Case: 'a' and 'c'
        }
    }
}
