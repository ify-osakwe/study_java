package dsa.problems.xcoderbyte.stringmanipulation;

import java.util.LinkedHashMap;
import java.util.Map;

/****************************************************************
 *              CODERBYTE RUN LENGTH CHALLENGE                  *
 *                                                              *
 * Problem Statement                                            *
 * Have the function RunLength(str) take the str parameter being*
 * passed and return a compressed version of the string using   *
 * the Run-length encoding algorithm. This algorithm works by   *
 * taking the occurrence of each repeating character and        *
 * outputting that number along with a single character of the  *
 * repeating sequence.                                          *
 * For example: "wwwggopp" would return 3w2g1o2p.               *
 * The string will not contain any numbers, punctuation,        *
 * or symbols.                                                  *
 *                                                              *
 * Examples                                                     *
 * Input 1: "aabbcde"                                           *
 * Output 1: 2a2b1c1d1e                                         *
 *                                                              *
 * Input 2: "wwwbbbw"                                           *
 * Output 2: 3w3b1w                                             *
 *                                                              *
 * Solution Efficiency                                          *
 * This user scored higher than 42.4% of users who solved this  *
 * challenge.                                                   *
 ***************************************************************/
public class RunLength {
    public static void main(String[] args) {
        System.out.println(runLength("aabbcde"));  // Output: 2a2b1c1d1e
        System.out.println(runLength("wwwbbbw"));  // Output: 3w3b1w
        System.out.println(runLength("wwwggopp")); // Output: 3w2g1o2p
        System.out.println(runLength(""));         // Output: (empty string)

        System.out.println(runLength2("aabbcde"));  // Output: 2a2b1c1d1e
        System.out.println(runLength2("wwwbbbw"));  // Output: 3w3b1w
        System.out.println(runLength2("wwwggopp")); // Output: 3w2g1o2p
        System.out.println(runLength2(""));         // Output: (empty string)
    }

    public static String runLength2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getValue()).append(entry.getKey());
        }

        return stringBuilder.toString();
    }

    public static String runLength(String str) {
        if (str.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;  // Increment the count for repeating characters
            } else {
                // Append the count and the previous character to the result
                result.append(count).append(str.charAt(i - 1));
                count = 1;  // Reset the count for the new character
            }
        }

        // Append the last character and its count
        result.append(count).append(str.charAt(str.length() - 1));

        return result.toString();
    }
}
