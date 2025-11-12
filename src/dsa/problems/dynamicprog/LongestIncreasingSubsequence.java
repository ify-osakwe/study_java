package dsa.problems.dynamicprog;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence Algorithm
 * <a href="https://gemini.google.com/share/84929e68b00e">Gemini Link</a>
 */
public class LongestIncreasingSubsequence {
    // efficient O(n log n) algorithm.
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 'tails' is an array where tails[i] stores the smallest ending element
        // of an increasing subsequence of length i+1.
        // This array is always guaranteed to be sorted.
        int[] tails = new int[nums.length];

        // 'size' tracks the current length of the 'tails' array,
        // which corresponds to the length of the LIS found so far.
        int size = 0;

        // Iterate through each number in the input array
        for (int num : nums) {
            // Perform a binary search on the 'tails' array (from index 0 to size)
            // We are looking for the "insertion point" for 'num'.
            // This is the first index 'i' where tails[i] >= num.

            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    // 'num' is larger, so it must go in the right half
                    i = m + 1;
                } else {
                    // 'num' is smaller or equal, it might replace tails[m]
                    // or be inserted before it. Look in the left half.
                    j = m;
                }
            }

            // 'i' is now the correct index for 'num'.
            // We place 'num' at this index.
            // - If 'num' is larger than all elements in 'tails' (i == size),
            //   it extends the LIS.
            // - If 'num' is smaller than some element (i < size),
            //   it replaces tails[i] to create a "better" (smaller)
            //   tail for a subsequence of that length.
            tails[i] = num;

            // If i == size, it means 'num' was appended to the end,
            // so the size of our LIS (and 'tails' array) increases.
            if (i == size) {
                size++;
            }
        }

        // The final 'size' is the length of the LIS.
        return size;
    }

    // O(n^2) Dynamic Programming approach.
    public static int lengthOfLIS_DynamicProgramming(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // dp[i] will store the length of the LIS ending at nums[i]
        int[] dp = new int[n];

        // Initialize all LIS lengths to 1 (the element itself)
        Arrays.fill(dp, 1);

        // This will store the overall maximum LIS length found
        int maxLIS = 1;

        // Iterate from the second element
        for (int i = 1; i < n; i++) {
            // Check all elements before 'i'
            for (int j = 0; j < i; j++) {
                // If the current element 'i' is greater than a previous element 'j',
                // it means we can extend the LIS that ended at 'j'.
                if (nums[i] > nums[j]) {
                    // The new LIS length is dp[j] + 1.
                    // We take the max of this new length and the current dp[i].
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // After checking all 'j', dp[i] is finalized.
            // We update our overall max length.
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("O(n log n) Output: " + lengthOfLIS(nums1)); // Output: 4
        System.out.println("O(n^2) Output: " + lengthOfLIS_DynamicProgramming(nums1)); // Output: 4

        System.out.println("---");

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("O(n log n) Output: " + lengthOfLIS(nums2)); // Output: 4
        System.out.println("O(n^2) Output: " + lengthOfLIS_DynamicProgramming(nums2)); // Output: 4

        System.out.println("---");

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("O(n log n) Output: " + lengthOfLIS(nums3)); // Output: 1
        System.out.println("O(n^2) Output: " + lengthOfLIS_DynamicProgramming(nums3)); // Output: 1
    }
}
