package dsa.coderbyte.stringmanipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *             CODERBYTE DISTINCT CHARACTERS CHALLENGE          *
 *                                                              *
 * Problem Statement                                            *
 * Have the function DistinctCharacters(str) take the str       *
 * parameter being passed and determine if it contains at least *
 * 10 distinct characters, if so, then your program should      *
 * return the string true, otherwise it should return the string*
 * false. For example: if str is "abc123kkmmmm?" then your      *
 * program should return the string false because this string   *
 * contains only                                                *
 * 9 distinct characters: a, b, c, 1, 2, 3, k, m, ? adds up to 9*
 *                                                              *
 * Examples                                                     *
 * Input 1: 12334bbmma:=6                                       *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: eeeemmmmmmmmm1000                                   *
 * Output 2: false                                              *
 ***************************************************************/
public class DistinctCharacter {
    public static void main(String[] args) {
        System.out.println(distinctCharacters("abc123kkmmmm?"));  // Output: false
        System.out.println(distinctCharacters("12334bbmma:=6"));  // Output: true
        System.out.println(distinctCharacters("eeeemmmmmmmmm1000") + "\n"); // Output: false

        System.out.println(distinctCharacters2("abc123kkmmmm?"));  // Output: false
        System.out.println(distinctCharacters2("12334bbmma:=6"));  // Output: true
        System.out.println(distinctCharacters2("eeeemmmmmmmmm1000")); // Output: false
    }

    public static String distinctCharacters(String str) {
        // Use a HashSet to store distinct characters
        Set<Character> distinctChars = new HashSet<>();

        // Iterate through the string and add characters to the set
        for (char c : str.toCharArray()) {
            distinctChars.add(c);
            // If we have 10 distinct characters, return "true"
            if (distinctChars.size() >= 10) {
                return "true";
            }
        }

        // If less than 10 distinct characters are found, return "false"
        return "false";
    }

    public static String distinctCharacters2(String str) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
            if (characterMap.size() >= 10) {
                return "true";
            }
        }
        return "false";
    }
}
