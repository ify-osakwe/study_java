package dsa.problems.g4gstrings;

import java.util.HashMap;

/*
Given two non-empty strings s1 and s2, consisting only of lowercase English letters,
determine whether they are anagrams of each other or not. Two strings are considered anagrams
if they contain the same characters with exactly the same frequencies, regardless of their order.

Input: s1 = "geeks" s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.

Input: s1 = "allergy", s2 = "allergyy"
Output: false
Explanation: Although the characters are mostly the same, s2 contains an extra 'y' character.
Since the frequency of characters differs, the strings are not anagrams.

Input: s1 = "listen", s2 = "lists"
Output: false
Explanation: The characters in the two strings are not the same — some are missing or extra.
So, they are not anagrams.
*/
public class AnagramCheck {
    public static void main(String[] args) {
        System.out.println(areAnagrams("geeks", "kseeg"));    // true
        System.out.println(areAnagrams("allergy", "allergyy")); // false
        System.out.println(areAnagrams("listen", "lists") + "\n");    // false

        System.out.println(areAnagrams2("geeks", "kseeg"));    // true
        System.out.println(areAnagrams2("allergy", "allergyy")); // false
        System.out.println(areAnagrams2("listen", "lists"));    // false
    }

    public static boolean areAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[26];

        // One pass: +1 for s1, −1 for s2
        for (int i = 0, n = s1.length(); i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        // Verify all totals are zero
        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static boolean areAnagrams2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
        }

        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
