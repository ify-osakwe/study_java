package dsa.problems.xgeeks4geeks.strings;

/*
You are given a string s consisting of lowercase characters and an integer k,
You have to count all possible substrings that have exactly k distinct characters.

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]

Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]

Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]

Constraints:
1 ≤ s.size() ≤ 10^6
1 ≤ k ≤ 26
*/
public class SubstringsKDistinct {
    public static void main(String[] args) {

    }

    public int countSubstr(String s, int k) {
        if (k <= 0 || s == null || s.isEmpty()) return 0;

        long ans = atMostKLowercase(s, k) - atMostKLowercase(s, k - 1);

        // Theoretical max for n up to 1e6 can exceed int; guard cast.
        if (ans > Integer.MAX_VALUE) {
            throw new ArithmeticException("Count exceeds int range: " + ans);
        }
        return (int) ans;
    }

    private long atMostKLowercase(String s, int k) {
        if (k < 0) return 0L;

        int[] freq = new int[26];
        int distinct = 0;
        int left = 0;
        long total = 0L;

        for (int right = 0; right < s.length(); right++) {
            int idxR = s.charAt(right) - 'a';
            if (freq[idxR]++ == 0) distinct++;

            while (distinct > k) {
                int idxL = s.charAt(left++) - 'a';
                if (--freq[idxL] == 0) distinct--;
            }
            // All substrings ending at 'right' and starting in [left..right] are valid
            total += right - left + 1;
        }
        return total;
    }
}
