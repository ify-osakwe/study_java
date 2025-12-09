package dsa.problems.g4gstrings;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a string s consisting of lowercase English Letters. Return the first non-repeating character in s.
If there is no non-repeating character, return '$'.
Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: '$'
Explanation: All the characters in the given string are repeating.
Constraints:
1 ≤ s.size() ≤ 10^5
*/
public class NonRepeatingChar {
    public static void main(String[] args) {
//        System.out.println(nonRepeatingChar("aabbccc"));
//        System.out.println(nonRepeatingChar("geeksforgeeks"));
//        System.out.println(nonRepeatingChar("racecar" + "\n"));

        System.out.println(nonRepeatingChar2("aabbccc"));
        System.out.println(nonRepeatingChar2("geeksforgeeks"));
        System.out.println(nonRepeatingChar2("racecar"));
    }

    public static char nonRepeatingChar(String s) {
        final int ALPHABET = 26;
        int[] freq = new int[ALPHABET];

        for (int i = 0, n = s.length(); i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0, n = s.length(); i < n; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return '$';
    }

    public static char nonRepeatingChar2(String s) {
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        for (char character : s.toCharArray()) {
            hashMap.merge(character, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> e : hashMap.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return '$';
    }
}
