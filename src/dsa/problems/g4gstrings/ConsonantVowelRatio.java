package dsa.problems.g4gstrings;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets.
You need to find the number of balanced strings in arr[] which can be formed by concatinating one
or more contiguous strings of arr[]. A balanced string contains the equal number of vowels and consonants.

Input: arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
Output: 4
Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced substrings with
equal consonants and vowels.

Input: arr[] = ["ab", "be"]
Output: 3
Explanation: arr[0..0], arr[0..1], arr[1..1] are the balanced substrings with equal consonants and vowels.

Input: arr[] = ["tz", "gfg", "ae"]
Output: 0
Explanation: There is no such balanced substring present in arr[] with equal consonants and vowels.

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i].size() ≤ 10^5
Total number of lowercase english characters in arr[] is lesser than 10^5.
*/
public class ConsonantVowelRatio {
    public static void main(String[] args) {
        System.out.println(countBalanced(new String[]{"aeio", "aa", "bc", "ot", "cdbd"})); // 4
        System.out.println(countBalanced(new String[]{"ab", "be"}));                       // 3
        System.out.println(countBalanced(new String[]{"tz", "gfg", "ae"}));
    }

    private static final boolean[] IS_VOWEL = new boolean[26];
    static {
        for (char v : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            IS_VOWEL[v - 'a'] = true;
        }
    }

    public static long countBalanced(String[] arr) {
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L); // empty prefix
        int prefix = 0; // running vowels-minus-consonants
        long answer = 0;

        for (String s : arr) {
            int diff = 0;
            for (int i = 0, n = s.length(); i < n; i++) {
                char c = s.charAt(i);
                diff += IS_VOWEL[c - 'a'] ? 1 : -1;
            }

            prefix += diff;
            long seen = freq.getOrDefault(prefix, 0L);
            answer += seen;
            freq.put(prefix, seen + 1);
        }

        return answer;
    }
}
