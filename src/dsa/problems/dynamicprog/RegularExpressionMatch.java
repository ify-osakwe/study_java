package dsa.problems.dynamicprog;

/**
 * Regular Expression Match
 * <a href="https://gemini.google.com/share/22593d6f3e4e">Gemini Link</a>
 */
public class RegularExpressionMatch {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int lenS = s.length();
        int lenP = p.length();

        // dp[i][j] means: Does s.substring(0, i) match p.substring(0, j)?
        // Dimensions are +1 to handle empty string cases (index 0).
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];

        // 1. Base Case: Empty string matches empty pattern.
        dp[0][0] = true;

        // 2. Handle patterns that can match empty strings (e.g., "a*", "a*b*", ".*")
        // We look at the first row (where s is empty).
        for (int j = 1; j <= lenP; j++) {
            if (p.charAt(j - 1) == '*') {
                // If we see '*', we can look 2 steps back.
                // If p[0..j-3] matched empty, then p[0..j-1] matches empty
                // because "char*" can count as empty.
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 3. Fill the DP table
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {

                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);

                // Case A: Direct match or '.'
                if (currentP == currentS || currentP == '.') {
                    // Result depends on the diagonal (previous state of both strings)
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Case B: Wildcard '*'
                else if (currentP == '*') {
                    char charBeforeStar = p.charAt(j - 2);

                    // Option 1: Treat "char*" as empty (0 occurrences).
                    // We simply look 2 columns back.
                    boolean matchZero = dp[i][j - 2];

                    // Option 2: Treat "char*" as 1 or more occurrences.
                    // This is only possible if the current char in 's' matches the char before '*'
                    boolean matchMany = false;
                    if (charBeforeStar == currentS || charBeforeStar == '.') {
                        // We look 1 row up (dp[i-1][j]).
                        // Logic: If s[0...i-2] matched p[0...j-1], and s[i-1] is the recurring char,
                        // we are still valid.
                        matchMany = dp[i - 1][j];
                    }

                    dp[i][j] = matchZero || matchMany;
                } else {
                    // Characters simply don't match
                    dp[i][j] = false;
                }
            }
        }

        // The answer is in the bottom-right corner
        return dp[lenS][lenP];
    }

    public static void main(String[] args) {
        System.out.println("--- Regular Expression Matching Tests ---");

        test("aa", "a", false);         // Ex 1: Partial match
        test("aa", "a*", true);         // Ex 2: Star repeats 'a'
        test("ab", ".*", true);         // Ex 3: .* matches everything
        test("aab", "c*a*b", true);     // 'c*' is zero, 'a*' is two 'a's
        test("mississippi", "mis*is*p*.", false); // Complex mismatch
        test("aaa", "ab*a*c*a", true);  // Complex match with multiple stars
    }

    private static void test(String s, String p, boolean expected) {
        boolean result = isMatch(s, p);
        String status = (result == expected) ? "PASS" : "FAIL";
        System.out.printf("Input: s=\"%s\", p=\"%s\" | Expected: %b | Got: %b -> %s%n",
                s, p, expected, result, status);
    }
}
