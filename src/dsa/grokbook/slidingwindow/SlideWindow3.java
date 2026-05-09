package dsa.grokbook.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest substring with K distinct characters.
 * Given a string, find the length of the longest substring
 * in it with no more than K distinct characters.
 */
public class SlideWindow3 {
    public static void main(String[] args) {
        String str1 = "araaci", str2 = "araaci", str3 = "cbbebi";
        int k1 = 2, k2 = 1, k3 = 3;

        System.out.println("Length of the longest substring: " + findLength(k1, str1));
        // The longest substring with no more than '2' distinct characters is "araa".

        System.out.println("Length of the longest substring: " + findLength(k2, str2));
        // The longest substring with no more than '1' distinct characters is "aa".

        System.out.println("Length of the longest substring: " + findLength(k3, str3));
        // The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
    }

    // space complexity O(K+1)
    // time complexity is O(N)
    private static int findLength(int K, String str) {
        if (str == null || str.isEmpty() || str.length() < K) {
            return -1;
        }
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            while (charFreqMap.size() > K) {
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }


}
