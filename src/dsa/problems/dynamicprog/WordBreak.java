package dsa.problems.dynamicprog;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Dynamic Programming for Word Break
 * <a href="https://gemini.google.com/share/0c13c59736c4">Gemini Link</a>
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        // 3. Base Case: An empty string (s.substring(0, 0)) is always "breakable".
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                // The DP Transition Logic:
                // Check two things:
                // a) Is the prefix (s.substring(0, j)) already known to be breakable?
                //    (This is what dp[j] == true means)
                // b) Is the remaining suffix (s.substring(j, i)) a valid word in our dictionary?

                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // If both are true, we've found a valid segmentation for s.substring(0, i).
                    dp[i] = true;
                    System.out.println(Arrays.toString(dp));
                    break;
                }
            }
            // If the inner loop finishes without finding a match, dp[i] remains false.
        }

        // 6. The final answer is in dp[s.length()], which tells us if the *entire*
        // string can be segmented.
        return dp[s.length()];
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Input: s = \"" + s1 + "\", dict = " + dict1);
        System.out.println("Output: " + wordBreak(s1, dict1)); // true
        System.out.println("--------------------");

        // Example 2:
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Input: s = \"" + s2 + "\", dict = " + dict2);
        System.out.println("Output: " + wordBreak(s2, dict2)); // true
        System.out.println("--------------------");

        // Example 3:
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Input: s = \"" + s3 + "\", dict = " + dict3);
        System.out.println("Output: " + wordBreak(s3, dict3)); // false
        System.out.println("--------------------");

        // Additional Test Case 1:
        String s4 = "aaaaaaa";
        List<String> dict4 = Arrays.asList("aaa", "aaaa");
        System.out.println("Input: s = \"" + s4 + "\", dict = " + dict4);
        System.out.println("Output: " + wordBreak(s4, dict4)); // true
        System.out.println("--------------------");

        // Additional Test Case 2:
        String s5 = "aaaaaaa";
        List<String> dict5 = Arrays.asList("aa", "aaaa");
        System.out.println("Input: s = \"" + s5 + "\", dict = " + dict5);
        System.out.println("Output: " + wordBreak(s5, dict5)); // false
        System.out.println("--------------------");
    }
}
