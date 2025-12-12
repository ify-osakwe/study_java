package dsa.problems.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 * <a href="https://gemini.google.com/share/76c46485dc36">Gemini Link</a>
 */
public class ValidAnagram {

    /**
     * Optimized solution for lowercase English letters using an array.
     * Time Complexity: O(n)
     * Space Complexity: O(1) (fixed size array of 26)
     */
    public static boolean isAnagram(String s, String t) {
        // 1. Fast check: Anagrams must be the same length
        if (s.length() != t.length()) {
            return false;
        }

        // 2. Initialize frequency array for 26 lowercase letters
        int[] counts = new int[26];

        // 3. Iterate through both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            // Increment count for char in s
            counts[s.charAt(i) - 'a']++;
            // Decrement count for char in t
            counts[t.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(counts));

        // 4. Check if all counts are zero
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Follow-up solution for Unicode characters using a HashMap.
     * Time Complexity: O(n)
     * Space Complexity: O(n) (in worst case of all unique chars)
     */
    public static boolean isAnagramUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Update count for s (increment)
            counts.put(charS, counts.getOrDefault(charS, 0) + 1);

            // Update count for t (decrement)
            counts.put(charT, counts.getOrDefault(charT, 0) - 1);
        }

        // If map contains any non-zero value, it's not an anagram
        for (int count : counts.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test 1 (Expected: true): " + isAnagram(s1, t1));
        System.out.println();

        // Test Case 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Test 2 (Expected: false): " + isAnagram(s2, t2));
        System.out.println();

        // Test Case 3: Different lengths
        System.out.println("Test 3 (Expected: false): " + isAnagram("a", "ab"));
        System.out.println();

        // Follow-up Test: Unicode Characters
        // Using Unicode (smiley face vs heart) effectively requires the HashMap approach
        // or a much larger array. Here we test the Unicode method.
        String u1 = "hello🌟";
        String u2 = "🌟olleh";
        System.out.println("Test Unicode (Expected: true): " + isAnagramUnicode(u1, u2));
        System.out.println();
    }
}
