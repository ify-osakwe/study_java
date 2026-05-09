package dsa.grokbook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest substring with same letters after replacement
 * Given a string with lowercase letters only, if you are allowed to replace no more
 * than ‘k’ letters with any letter, find the length of the longest substring having
 * the same letters after replacement.
 */
public class SlideWindow6 {
    public static void main(String[] args) {
        String s1 = "aabccbb", s2 = "abbcb", s3 = "abccde";
        int k1 = 2, k2 = 1, k3 = 1;

        System.out.println("Length of the longest substring: " + findLength(s1, k1));
        //System.out.println("Length of the longest substring: " + findLength(s2, k2));
        //System.out.println("Length of the longest substring: " + findLength(s3, k3));
    }

    // time complexity is O(N)
    // space complexity is O(1)
    private static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFreqMap.put(rightChar, letterFreqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFreqMap.get(rightChar));

            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFreqMap.put(leftChar, letterFreqMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
