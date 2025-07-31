package dsa.g4g.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string s, which may contain duplicate characters, your task is to generate
and return an array of all unique permutations of the string.
You can return your answer in any order.

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.

Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS",
"BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB",
"SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.

Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.

Constraints:
1 <= s.size() <= 9
s contains only Uppercase english alphabets
*/
public class PermutateString {
    public static void main(String[] args) {
        System.out.println(findPermutation("ABC") + "\n");
        // → [ABC, ACB, BAC, BCA, CAB, CBA]

        System.out.println(findPermutation("ABSG") + "\n");
        System.out.println(findPermutation("AAA") + "\n");

    }

    public static ArrayList<String> findPermutation(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        boolean[] used = new boolean[n];
        StringBuilder path = new StringBuilder(n);
        ArrayList<String> result = new ArrayList<>();

        backtrack(chars, used, path, result);
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used,
                                  StringBuilder path, List<String> result) {
        if (path.length() == chars.length) {   // leaf reached
            result.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;             // already picked

            // skip duplicates: only use first unused copy at this depth
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            path.append(chars[i]);

            backtrack(chars, used, path, result);   // recurse

            path.deleteCharAt(path.length() - 1);   // undo choice
            used[i] = false;
        }
    }

}
