package dsa.problems.string;

/**
 * Longest Palindrome
 * <a href="https://gemini.google.com/share/d876656b6f53">Gemini Link</a>
 */
public class LongestPalindrome {

    public static String longestPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            // Case 1: Odd length palindrome (center is character i)
            // e.g., "aba" centered at 'b'
            int len1 = expandAroundCenter(str, i, i);

            // Case 2: Even length palindrome (center is between i and i+1)
            // e.g., "abba" centered between 'b' and 'b'
            int len2 = expandAroundCenter(str, i, i + 1);

            int len = Math.max(len1, len2);

            // If we found a palindrome longer than our current best, update boundaries
            if (len > end - start) {
                // Calculate new start index
                // For "aba" (len 3, i=1): start = 1 - (2)/2 = 0
                // For "abba" (len 4, i=1): start = 1 - (3)/2 = 0
                start = i - (len - 1) / 2;

                // Calculate new end index
                // For "aba" (len 3, i=1): end = 1 + 3/2 = 2
                // For "abba" (len 4, i=1): end = 1 + 4/2 = 3
                end = i + len / 2;
            }
        }

        // Return the substring found.
        // substring(start, end) in Java is exclusive of end, so we use end + 1
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        // Expand while indices are valid and characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return length.
        // Note: The loop breaks when boundaries are crossed or characters don't match.
        // The valid range is (left + 1) to (right - 1).
        // Length formula: (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        // Test Case 1
        String input1 = "babad";
        String output1 = longestPalindrome(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + output1);
        // Expected: "bab" or "aba"

        System.out.println("-----------------");

        // Test Case 2
        String input2 = "cbbd";
        String output2 = longestPalindrome(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + output2);
        // Expected: "bb"

        System.out.println("-----------------");

        // Test Case 3 (Single char)
        String input3 = "a";
        String output3 = longestPalindrome(input3);
        System.out.println("Input: " + input3);
        System.out.println("Output: " + output3);
        // Expected: "a"

        System.out.println("-----------------");

        // Test Case 4 (Full string palindrome)
        String input4 = "racecar";
        String output4 = longestPalindrome(input4);
        System.out.println("Input: " + input4);
        System.out.println("Output: " + output4);
        // Expected: "racecar"
    }
}
