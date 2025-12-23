package dsa.problems.xgeeks4geeks.strings;

import java.util.HashMap;
import java.util.Map;

/*

*/
public class LongSubstring {
    public static void main(String[] args) {

    }

    public int longestKSubstr(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) return -1;

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, maxLen = -1;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // shrink until we have at most k distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(left++);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
            }

            // if exactly k distinct, update max length
            if (freq.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
