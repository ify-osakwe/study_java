package dsa.problems.dynamicprog;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1" , 'B' -> "2" ... 'Z' -> "26"
 * <p>
 * However, while decoding the message, you realize that there are many different ways you can
 * decode the message because some codes are contained in other codes ("2" and "5" vs "25").
 * <p>
 * For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * <p>
 * "KJF" with the grouping (11 10 6)
 * <p>
 * The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
 * <p>
 * Note: there may be strings that are impossible to decode.
 * Given a string s containing only digits, return the number of ways to decode it.
 * If the entire string cannot be decoded in any valid way, return 0.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * <p>
 * Example 3:
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * <p>
 * s contains only digits and may contain leading zero(s).
 * <p>
 * Decoding Ways: Dynamic Programming Approach
 * <a href="https://gemini.google.com/share/7176869777db">Gemini Link</a>
 */
public class DecodeWays {
    public static int numDecodings(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int len = str.length();
        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = (str.charAt(0) == '0') ? 0 : 1;

        for (int index = 2; index <= len; index++) {
            // --- Case 1: Single-Digit Decode ---
            // We check the last digit: str.charAt(index - 1)
            // If it'str not '0' (index.e., '1' through '9'), it can be decoded as a single character.
            // The number of ways to do this is the number of ways we had to get to
            // the previous state, which is dp[index - 1].
            if (str.charAt(index - 1) != '0') {
                dp[index] += dp[index - 1];
            }

            // --- Case 2: Two-Digit Decode ---
            // We check the last two digits: str.charAt(index - 2) and str.charAt(index - 1)
            // The two-digit number must be between "10" and "26".

            char twoDigitsBack = str.charAt(index - 2);
            char oneDigitBack = str.charAt(index - 1);

            // If the first digit is '1' (forming "10" to "19"), it'str always valid.
            if (twoDigitsBack == '1') {
                // The number of ways to do this is the number of ways we had to
                // get to the state two steps back, which is dp[index - 2].
                dp[index] += dp[index - 2];
            }
            // If the first digit is '2' (forming "20" to "26"), it'str valid
            // only if the second digit is '0' through '6'.
            else if (twoDigitsBack == '2' && (oneDigitBack >= '0' && oneDigitBack <= '6')) {
                // Same as above, we add the ways from two steps back.
                dp[index] += dp[index - 2];
            }

            // Note: If twoDigitsBack is '0' or '3'-'9', it can never form a valid
            // two-digit code, so we don't need to do anything.
        }
        // The final answer is stored in dp[len], which represents the number
        // of ways to decode the entire string of length len.
        return dp[len];
    }

    public static void main(String[] args) {
        // Example 1: "12"
        // Decodes as "AB" (1 2) or "L" (12)
        // Output: 2
        String s1 = "12";
        System.out.println("Ways to decode \"" + s1 + "\": " + numDecodings(s1) + "\n"); // 2

        // Example 2: "226"
        // Decodes as "BBF" (2 2 6), "VF" (22 6), or "BZ" (2 26)
        // Output: 3
        String s2 = "226";
        System.out.println("Ways to decode \"" + s2 + "\": " + numDecodings(s2) + "\n"); // 3

        // Example 3: "06"
        // Invalid: "0" is not a valid start, "06" is not "F"
        // Output: 0
        String s3 = "06";
        System.out.println("Ways to decode \"" + s3 + "\": " + numDecodings(s3) + "\n"); // 0

        // Additional Test Cases:

        // "10" -> "J"
        String s4 = "10";
        System.out.println("Ways to decode \"" + s4 + "\": " + numDecodings(s4) + "\n"); // 1

        // "27" -> "BG" (2 7). "27" is not a valid code.
        String s5 = "27";
        System.out.println("Ways to decode \"" + s5 + "\": " + numDecodings(s5) + "\n"); // 1

        // "11106" -> "AAJF" (1 1 10 6), "KJF" (11 10 6)
        String s6 = "11106";
        System.out.println("Ways to decode \"" + s6 + "\": " + numDecodings(s6) + "\n"); // 2

        // "100" -> Invalid. "10" is "J", but "0" is invalid.
        String s7 = "100";
        System.out.println("Ways to decode \"" + s7 + "\": " + numDecodings(s7) + "\n"); // 0
    }
}
