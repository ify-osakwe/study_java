package dsa.problems.xgeeks4geeks.strings;

/*
Given a string s, your task is to find the longest palindromic substring within s.
A substring is a contiguous sequence of characters within a string,
defined as s[i...j] where 0 ≤ i ≤ j < len(s).
A palindrome is a string that reads the same forward and backward.
More formally, s is a palindrome if reverse(s) == s.
Note: If there are multiple palindromic substrings with the same length,
return the first occurrence of the longest palindromic substring from left to right.

Input: s = “forgeeksskeegfor”
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc.
But the substring “geeksskeeg” is the longest among all.

Input: s = “Geeks”
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks".

Input: s = “abc”
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length.
So, the first occurrence is returned.

Constraints:
1 ≤ s.size() ≤ 10^3
s consist of only lowercase English letters.
*/
public class LongestPalindrome {
    public static void main(String[] args) {
        assert longestPalindrome("forgeeksskeegfor").equals("geeksskeeg");
        assert longestPalindrome("Geeks").equals("ee");
        assert longestPalindrome("abc").equals("a");
        assert longestPalindrome("aaaa").equals("aaaa");
        assert longestPalindrome("abccba").equals("abccba");
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int start = 0, maxLen = 1;
        for (int center = 0; center < s.length(); center++) {
            int[] odd = expand(s, center, center); // odd-length palindromes (single-char center)
            int[] even = expand(s, center, center + 1); // even-length palindromes (two-char center)

            int[] longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
            int len = longer[1] - longer[0] + 1;
            if (len > maxLen) {
                start = longer[0];
                maxLen = len;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int[] expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[] { l + 1, r - 1 };
    }
}
