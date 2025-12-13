package dsa.problems.string;

/**
 * Palindromic Substrings
 * <a href="https://gemini.google.com/share/2258f3282629">Gemini Link</a>
 */
public class PalindromicSubstrings {

    private static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // 1. Expand around a single character center (Odd length palindromes)
            // Example: "aba" -> center is 'b' at index i
            count += countAndExpand(s, i, i);

            // 2. Expand around a two-character center (Even length palindromes)
            // Example: "abba" -> center is between 'b' and 'b' at i and i+1
            count += countAndExpand(s, i, i + 1);
        }

        return count;
    }

    private static int countAndExpand(String s, int left, int right) {
        int found = 0;

        // Loop while pointers are in bounds and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            found++; // Found a palindrome
            left--;  // Move left pointer outward
            right++; // Move right pointer outward
        }

        return found;
    }

    public static void main(String[] args) {
        // Test Case 1
        String input1 = "abc";
        int result1 = countSubstrings(input1);
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 3"); // "a", "b", "c"
        System.out.println("-------------------");

        // Test Case 2
        String input2 = "aaa";
        int result2 = countSubstrings(input2);
        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 6"); // "a", "a", "a", "aa", "aa", "aaa"
        System.out.println("-------------------");

        // Test Case 3 (Mixed)
        String input3 = "abccba";
        int result3 = countSubstrings(input3);
        System.out.println("Input: \"" + input3 + "\"");
        System.out.println("Output: " + result3);
        // Expected: a, b, c, c, b, a, cc, bccb, abccba = 9
    }
}
