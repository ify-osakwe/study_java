package dsa.grokbook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation in a String.
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations: abc, acb, bac, bca, cab, cba.
 * If a string has ‘n’ distinct characters it will have n! permutations.
 */
public class SlideWindow8 {
    public static void main(String[] args) {
        String s1 = "oidbcaf", p1 = "abc"; // output : true
        String s2 = "odicf", p2 = "dc"; // output : false
        String s3 = "bcdxabcdy", p3 = "bcdyabcdx"; // output : true
        String s4 = "aaacb", p4 = "abc"; // output : true

        System.out.println("Permutation exist: " + findPermutation(s1, p1));
        System.out.println("Permutation exist: " + findPermutation(s2, p2));
        System.out.println("Permutation exist: " + findPermutation(s3, p3));
        System.out.println("Permutation exist: " + findPermutation(s4, p4));
    }

    private static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            hashMap.put(chr, hashMap.getOrDefault(chr, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (hashMap.containsKey(rightChar)) {
                hashMap.put(rightChar, hashMap.get(rightChar) - 1);
                if (hashMap.get(rightChar) == 0) matched++;
            }
            if (matched == hashMap.size()) return true;

            // shrink window if it becomes bigger than pattern
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (hashMap.containsKey(leftChar)) {
                    if (hashMap.get(leftChar) == 0) matched--;
                    hashMap.put(leftChar, hashMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
}
