package dsa.problems.dynamicprog;

/**
 * Longest Common Subsequence with Dynamic Programming
 * <a href="https://gemini.google.com/share/9c98e304ea83">Gemini Link</a>
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String s1, String s2) {
        // Get the lengths of both strings.
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        // We use [lenS1+1][lenS2+1] size so we can have a 0-th row and 0-th column
        // which act as our base cases (LCS of an empty string and another string is 0).
        int[][] dp = new int[lenS1 + 1][lenS2 + 1];

        // Fill the DP table, starting from index 1 (since 0-indices are base cases).
        for (int i = 1; i <= lenS1; i++) {
            for (int j = 1; j <= lenS2; j++) {

                char char1 = s1.charAt(i - 1);
                char char2 = s2.charAt(j - 1);

                // Case 1: The characters match.
                if (char1 == char2) {
                    // The LCS is 1 (for this character) + the LCS of the strings
                    // *before* this character (found at dp[i-1][j-1]).
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // Case 2: The characters do not match.
                else {
                    // The LCS is the *maximum* length we could get by either:
                    // 1. Ignoring the current char from s1 (dp[i-1][j])
                    // 2. Ignoring the current char from s2 (dp[i][j-1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The answer to the whole problem is in the bottom-right cell,
        // which represents the LCS for all of s1 and all of s2.
        return dp[lenS1][lenS2];
    }

    public static void main(String[] args) {
        // Example 1:
        String text1_1 = "abcde";
        String text2_1 = "ace";
        int result1 = longestCommonSubsequence(text1_1, text2_1);
        System.out.println("Input: text1 = \"" + text1_1 + "\", text2 = \"" + text2_1 + "\"");
        System.out.println("Output: " + result1); // Expected: 3
        System.out.println("--------------------");

        // Example 2:
        String text1_2 = "abc";
        String text2_2 = "abc";
        int result2 = longestCommonSubsequence(text1_2, text2_2);
        System.out.println("Input: text1 = \"" + text1_2 + "\", text2 = \"" + text2_2 + "\"");
        System.out.println("Output: " + result2); // Expected: 3
        System.out.println("--------------------");

        // Example 3:
        String text1_3 = "abc";
        String text2_3 = "def";
        int result3 = longestCommonSubsequence(text1_3, text2_3);
        System.out.println("Input: text1 = \"" + text1_3 + "\", text2 = \"" + text2_3 + "\"");
        System.out.println("Output: " + result3); // Expected: 0
        System.out.println("--------------------");

        // Additional Test Case:
        String text1_4 = "AGGTAB";
        String text2_4 = "GXTXAYB";
        int result4 = longestCommonSubsequence(text1_4, text2_4);
        System.out.println("Input: text1 = \"" + text1_4 + "\", text2 = \"" + text2_4 + "\"");
        System.out.println("Output: " + result4); // Expected: 4 (LCS is "GTAB")
        System.out.println("--------------------");
    }
}
