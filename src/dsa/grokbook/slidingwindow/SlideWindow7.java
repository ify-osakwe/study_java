package dsa.grokbook.slidingwindow;

/**
 * Longest Subarray with Ones after Replacement.
 * Given an array containing 0s and 1s, if you are allowed to replace no more
 * than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 */
public class SlideWindow7 {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int[] arr2 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k1 = 2, k2 = 3;

        System.out.println("Length of the longest contiguous subarray: " + findLength(arr1, k1));
        System.out.println("Length of the longest contiguous subarray: " + findLength(arr2, k2));
    }

    // time complexity is O(N)
    // space complexity is O(1)
    private static int findLength(int[] array, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            if (array[windowEnd] == 1) maxOnesCount++;

            // windowEnd - windowStart + 1 : size of the window
            // (windowEnd - windowStart + 1) - maxOnesCount : numbers of 0s in window
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (array[windowStart] == 1) maxOnesCount--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
