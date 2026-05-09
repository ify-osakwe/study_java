package dsa.grokbook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Smallest Window containing Substring.
 * Given a string and a pattern, find the smallest substring
 * in the given string which has all the characters of the given pattern.
 *
 */
public class SlideWindow10 {
    public static void main(String[] args) {
        String s1 = "aabdec", p1 = "abc"; // Output: "abdec"
        String s2 = "abdabca", p2 = "abc";  // Output: "abc"
        String s3 = "adcad", p3 = "abc"; // Output: ""

        // the required substring can have some additional characters
        // and doesn’t need to be a permutation of the pattern
        System.out.println("Smallest substring: " + findSubstring(s1, p1));
        System.out.println("Smallest substring: " + findSubstring(s2, p2));
    }

    private static String findSubstring(String str, String pattern) {
        int windowStart = 0, matched = 0;
        int minLength = str.length() + 1, subStrStart = 0;

        Map<Character, Integer> hashMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            hashMap.put(chr, hashMap.getOrDefault(chr, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (hashMap.containsKey(rightChar)) {
                hashMap.put(rightChar, hashMap.get(rightChar) - 1);
                if (hashMap.get(rightChar) >= 0) matched++;
            }

            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }
                char leftChar = str.charAt(windowStart++);
                if (hashMap.containsKey(leftChar)) {
                    if (hashMap.get(leftChar) == 0) matched--;
                    hashMap.put(leftChar, hashMap.get(leftChar) + 1);
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }
}
