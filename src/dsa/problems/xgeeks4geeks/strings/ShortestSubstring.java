package dsa.problems.xgeeks4geeks.strings;

/*
You are given two strings, s1 and s2, where s1 contains distinct lowercase vowels (a, e, i, o, u),
and s2 contains lowercase English letters. Your task is to find the length of the shortest contiguous
substring within s2 that contains all the vowels present in s1 at least once, in any order.
Note: If there is no such substring in s2, return -1.

Input: s1 = "ae", s2 = "acbaudeq"
Output: 4
Explanation: The shortest substring of "acbaudeq" that contains both vowels 'a' and 'e'
from s1 = "ae" is "aude", which has length 4.

Input: s1 = "iou", s2 = "iuixoiu"
Output: 3
Explanation: The shortest substring of "iuixoiu" that contains all vowels 'i', 'o', and 'u'
from s1 = "iou" is "oiu", which has length 3.

Input: s1 = "aeiou", s2 = "uoiee"
Output: -1
Explanation: The string s2 = "uoiee" is missing the vowel 'a' from s1 = "aeiou",
so no substring can contain all required vowels, and the answer is -1.

Constraints:
1 ≤ s1.length() ≤ 5
1 ≤ s2.length() ≤ 10^5
*/
public class ShortestSubstring {
    public static void main(String[] args) {
        System.out.println(substrWithVowels("ae", "acbaudeq")); // 4
        System.out.println(substrWithVowels("iou", "iuixoiu"));  // 3
        System.out.println(substrWithVowels("aeiou", "uoiee"));    // -1
    }

    // Returns length of shortest substring of s2 that contains every vowel in s1
    public static int substrWithVowels(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) return -1;

        // Step 1: mark vowels we must see
        boolean[] need = new boolean[26];
        for (char ch : s1.toCharArray()) {
            need[ch - 'a'] = true;          // only five possible positions ever become true
        }
        int needCount = s1.length();         // distinct vowels in s1 (guaranteed unique)

        int[] window = new int[26];          // frequency inside current window
        int formed = 0;                      // how many required vowels currently present
        int left = 0, minLen = Integer.MAX_VALUE;

        // Step 2: expand / contract sliding window
        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            int idx = c - 'a';

            if (need[idx]) {                 // only track chars we care about
                if (window[idx] == 0) formed++;
                window[idx]++;
            }

            // while window covers all required vowels, try to shrink from left
            while (formed == needCount) {
                minLen = Math.min(minLen, right - left + 1);

                char cl = s2.charAt(left);
                int li = cl - 'a';
                if (need[li]) {
                    window[li]--;
                    if (window[li] == 0) formed--; // lost a required vowel
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
