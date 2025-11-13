package dsa.problems.dynamicprog;

/**
 * Combination Sum Java Solution
 * <a href="https://gemini.google.com/share/1acda1cedbb2">Gemini Link</a>
 */
public class CombinationSum {
    public static int combinationSum(int[] nums, int target) {

        // dp[i] will store the number of combinations that sum up to i.
        // We use int because the problem guarantees the *final answer* fits in a 32-bit integer.
        // The size is target + 1 to account for sums from 0 to target.
        int[] dp = new int[target + 1];

        // Base case: There is 1 way to make a sum of 0 (by using no numbers).
        dp[0] = 1;

        // Outer loop: Iterate through all target sums from 1 to target.
        // We are building our solution from the bottom up.
        for (int i = 1; i <= target; i++) {

            // Inner loop: Iterate through each number in nums.
            for (int num : nums) {

                // If the current sum 'i' is greater than or equal to the number 'num',
                // it means we can use 'num' to help form the sum 'i'.
                if (i >= num) {

                    // The number of ways to form 'i' is increased by the number of ways
                    // we could form the remaining sum 'i - num'.
                    // For example, ways to get 4 = (ways to get 3) + (ways to get 2) + (ways to get 1)
                    // if nums = [1, 2, 3].
                    dp[i] += dp[i - num];
                }
            }
        }

        // The final answer is the number of ways to make the target sum.
        return dp[target];
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        int result1 = combinationSum(nums1, target1);
        System.out.println("Nums: [1, 2, 3], Target: 4");
        System.out.println("Expected: 7");
        System.out.println("Actual:   " + result1);
        System.out.println("--------------------");

        // Example 2
        int[] nums2 = {9};
        int target2 = 3;
        int result2 = combinationSum(nums2, target2);
        System.out.println("Nums: [9], Target: 3");
        System.out.println("Expected: 0");
        System.out.println("Actual:   " + result2);
        System.out.println("--------------------");

        // Additional Test Case
        int[] nums3 = {1, 2, 5};
        int target3 = 5;
        int result3 = combinationSum(nums3, target3);
        System.out.println("Nums: [1, 2, 5], Target: 5");
        System.out.println("Expected: 9");
        System.out.println("Actual:   " + result3);
        System.out.println("--------------------");
    }
}
