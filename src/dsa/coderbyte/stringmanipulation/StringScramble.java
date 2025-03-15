package dsa.coderbyte.stringmanipulation;

import java.util.HashMap;

/*
 *             CODERBYTE STRING SCRAMBLE CHALLENGE              *
 *                                                              *
 * Problem Statement                                            *
 * Have the function StringScramble(str1,str2) take both        *
 * parameters being passed and return the string true if a      *
 * portion of str1 characters can be rearranged to match str2,  *
 * otherwise return the string false.                           *
 * For example: if str1 is "rkqodlw" and str2 is "world" the    *
 * output should return true. Punctuation and symbols will not  *
 * be entered with the parameters.                              *
 *                                                              *
 * Examples                                                     *
 * Input 1: "cdore" & "coder"                                   *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: "h3llko" & "hello"                                  *
 * Output 2: false                                              *
 ***************************************************************/
public class StringScramble {
    public static void main(String[] args) {
        System.out.println(stringChallenge("cdore", "coder")); // Output: true
        System.out.println(stringChallenge("h3llko", "hello")); // Output: false
        System.out.println(stringChallenge("rkqodlw", "world")); // Output: true
    }

    public static String stringChallenge(String str1, String str2) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            // If a character in str2 is not present in str1
            // or if there aren't enough occurrences, return "false"
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return "false";
            }
            // Decrease the count of the character as it is being used
            charCount.put(c, charCount.get(c) - 1);
        }

        // If all characters in str2 are matched, return "true"
        return "true";
    }
}
