package dsa.problems.xcoderbyte.stringmanipulation;

import java.util.HashMap;

/*
 *         CODERBYTE MINIMUM WINDOW SUBSTRING CHALLENGE         *
 *                                                              *
 * Problem Statement                                            *
 * Have the function MinWindowSubstring(strArr) take the array  *
 * of strings stored in strArr, which will contain only two     *
 * strings, the first parameter being the string N and the      *
 * second parameter being a string K of some characters, and    *
 * your goal is to determine the smallest substring of N that   *
 * contains all the characters in K.                            *
 *                                                              *
 * For example: if strArr is ["aaabaaddae", "aed"] then the     *
 * smallest substring of N that contains the characters         *
 * a, e, and d is "dae" located at the end of the string.       *
 * So for this example your program should return the string    *
 *                                                              *
 * Another example: if strArr is ["aabdccdbcacd", "aad"] then   *
 * the smallest substring of N that contains all of the         *
 * characters in K is "aabd" which is located at the beginning  *
 * of the string. Both parameters will be strings ranging in    *
 * length from 1 to 50 characters and all of K's characters will*
 * exist somewhere in the string N. Both strings will only      *
 * contains lowercase alphabetic characters.                    *
 *                                                              *
 * Examples                                                     *
 * Input 1: ["ahffaksfajeeubsne", "jefaa"]                      *
 * Output 1: aksfaje                                            *
 *                                                              *
 * Input 2: ["aaffhkksemckelloe", "fhea"]                       *
 * Output 2: affhkkse                                           *
 *                                                              *
 ***************************************************************/
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindowSubstring(new String[]{"aaabaaddae", "aed"}));  // Output: dae
        System.out.println(minWindowSubstring(new String[]{"aabdccdbcacd", "aad"}));  // Output: aabd
        System.out.println(minWindowSubstring(new String[]{"ahffaksfajeeubsne", "jefaa"}));  // Output: aksfaje
        System.out.println(minWindowSubstring(new String[]{"aaffhkksemckelloe", "fhea"}));  // Output: affhkkse
    }

    public static String minWindowSubstring(String[] strArr) {
        String N = strArr[0];  // The main string
        String K = strArr[1];  // The characters to be contained

        // Map to count the frequency of characters in K
        HashMap<Character, Integer> requiredMap = new HashMap<>();
        for (char c : K.toCharArray()) {
            requiredMap.put(c, requiredMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track the window and the result
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int matchedChars = 0;

        // Map to count the frequency of characters in the current window
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // Expand the window by moving 'right'
        while (right < N.length()) {
            char rightChar = N.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Check if the current character is required and is fully matched
            if (requiredMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() == requiredMap.get(rightChar).intValue()) {
                matchedChars++;
            }

            // When all characters in K are matched, try shrinking the window
            while (matchedChars == requiredMap.size()) {
                // Update the result if this window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                // Shrink the window by moving 'left'
                char leftChar = N.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (requiredMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < requiredMap.get(leftChar).intValue()) {
                    matchedChars--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : N.substring(startIndex, startIndex + minLength);
    }
}
