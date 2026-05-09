package dsa.grokbook.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * String Anagrams.
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * Anagram is actually a Permutation of a string.
 * For example, “abc” has the following six anagrams: abc, acb, bac, bca, cab, cba
 * Write a function to return a list of starting indices of the anagrams of
 * the pattern in the given string.
 */
public class SlideWindow9 {
    public static void main(String[] args) {
        String s1 = "ppqp", p1 = "pq"; // Output: [1, 2] : "pq", "qp"
        String s2 = "abbcabc", p2 = "abc"; // Output: [2, 3, 4] : "bca", "cab", "abc"

        System.out.println("Anagrams: " + findStringAnagrams(s1, p1));
        System.out.println("Anagrams: " + findStringAnagrams(s2, p2));
    }

    private static List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            hashMap.put(chr, hashMap.getOrDefault(chr, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (hashMap.containsKey(rightChar)) {
                hashMap.put(rightChar, hashMap.get(rightChar) - 1);
                if (hashMap.get(rightChar) == 0) matched++;
            }
            if (matched == hashMap.size()) resultIndices.add(windowStart);

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (hashMap.containsKey(leftChar)) {
                    if (hashMap.get(leftChar) == 0) matched--;
                    hashMap.put(leftChar, hashMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }
}
