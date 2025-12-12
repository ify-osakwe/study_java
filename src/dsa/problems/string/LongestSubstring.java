package dsa.problems.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Duplicates
 * <a href="https://gemini.google.com/share/f9672d266b48">Gemini Link</a>
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String str) {
        // Base case: empty string
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        // Iterate through the string with the right pointer
        while (right < str.length()) {
            char currentChar = str.charAt(right);

            if (!window.contains(currentChar)) {
                window.add(currentChar);

                // Update maxLen if current window is larger
                // window.size() is equivalent to (right - left + 1)
                maxLen = Math.max(maxLen, window.size());

                // Move the right window edge forward
                right++;
            } else {
                // If character is already in set, we have a duplicate.
                // We must shrink the window from the left until the duplicate is removed.
                window.remove(str.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s1)); // Expected: 3
        System.out.println();

        // Test Case 2
        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s2)); // Expected: 1
        System.out.println();

        // Test Case 3
        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s3)); // Expected: 3
        System.out.println();

        // Test Case 4: Empty String
        String s4 = "";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s4)); // Expected: 0
        System.out.println();

        // Test Case 5: String with spaces and symbols
        String s5 = "a b!c!b";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s5)); // Expected: 4 ("a b!")
    }
}
