package dsa.grokbook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * No-repeat substring.
 * Given a string, find the length of the longest substring which has no repeating characters.
 */
public class SlideWindow5 {
    public static void main(String[] args) {
        String s1 = "aabccbb", s2 = "abbbb", s3 = "abccde";

        System.out.println("Length of the longest substring: " + findLength(s1));
        System.out.println("Length of the longest substring: " + findLength(s2));
        System.out.println("Length of the longest substring: " + findLength(s3));
    }

    // time complexity of the algorithm will be
    // O(N) where ‘N’ is the number of characters in the input string.
    // space complexity of the algorithm will be
    // O(K) where K is the number of distinct characters in the input string
    private static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
