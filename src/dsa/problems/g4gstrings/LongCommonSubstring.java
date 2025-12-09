package dsa.problems.g4gstrings;

/*
You are given two strings s1 and s2. Your task is to find the length of the longest
common substring among the given strings.

Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4.

Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: The longest common substrings are "a", "b", "c" all having length 1.

Input: s1 = "YZ", s2 = "yz"
Output: 0

Constraints:
1 <= s1.size(), s2.size() <= 10^3
Both strings may contain upper and lower case alphabets.
*/
public class LongCommonSubstring {
    public static void main(String[] args) {

    }

    // uses Dynamic Programming to solve
    public int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int maxLen = 0;

        // dp[i][j] means the length of common substring ending at s1[i-1] and s2[j-1]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}
