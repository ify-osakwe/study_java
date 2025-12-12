package dsa.problems.string;

/**
 * Minimum Window Substring
 * <a href="https://gemini.google.com/share/8cafe744b5aa">Gemini Link</a>
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // Edge case checks
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        // Frequency array for characters in t
        // ASCII size 128 covers standard English letters
        int[] mapArray = new int[128];

        // Fill the mapArray with counts of characters in t
        for (char c : t.toCharArray()) {
            mapArray[c]++;
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // 'count' tracks how many characters from 't' we have currently matched
        // in our window. When count == t.length(), the window is valid.
        int count = 0;

        char[] sChars = s.toCharArray();

        // Expand the window with the 'right' pointer
        while (right < sChars.length) {
            char rChar = sChars[right];

            // If mapArray[rChar] > 0, it means this character is part of 't'
            // and we still need to match it.
            if (mapArray[rChar] > 0) {
                count++;
            }

            // We decrement the count in the mapArray.
            // Note: Characters not in 't' will go into negative values.
            // Characters in 't' but found in excess will also go negative (or 0).
            mapArray[rChar]--;

            // When count equals t.length(), we have a valid window containing all chars of t
            while (count == t.length()) {
                // Check if this is the smallest window found so far
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                // Try to shrink the window from the left
                char lChar = sChars[left];

                // We are removing lChar from the window, so we put it back in the mapArray
                mapArray[lChar]++;

                // If mapArray[lChar] becomes > 0, it means we just removed a character
                // that was required to satisfy the condition (it wasn't an excess char).
                // Therefore, our window is no longer valid.
                if (mapArray[lChar] > 0) {
                    count--;
                }

                left++;
            }

            // Move right pointer forward to expand
            right++;
        }

        // If minLen never changed, no valid window was found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Test 1 Input: s = " + s1 + ", t = " + t1);
        System.out.println("Test 1 Output: " + minWindow(s1, t1)); // Expected: "BANC"
        System.out.println();

        // Example 2
        String s2 = "a";
        String t2 = "a";
        System.out.println("Test 2 Input: s = " + s2 + ", t = " + t2);
        System.out.println("Test 2 Output: " + minWindow(s2, t2)); // Expected: "a"
        System.out.println();

        // Example 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Test 3 Input: s = " + s3 + ", t = " + t3);
        System.out.println("Test 3 Output: \"" + minWindow(s3, t3) + "\""); // Expected: ""
        System.out.println();

        // Additional Test Case: Duplicates in t
        String s4 = "AAACBBB";
        String t4 = "ABC";
        System.out.println("Test 4 Input: s = " + s4 + ", t = " + t4);
        System.out.println("Test 4 Output: " + minWindow(s4, t4)); // Expected: "ACB"
    }
}
