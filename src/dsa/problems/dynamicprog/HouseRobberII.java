package dsa.problems.dynamicprog;

/**
 * Robbing Circular Houses Strategy Explained
 * <a href="https://gemini.google.com/share/1b29779d16aa">Gemini Link</a>
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        // Case 1: Rob houses 0 to n-2 (exclude the last house)
        int max1 = robLinear(nums, 0, n - 2);

        // Case 2: Rob houses 1 to n-1 (exclude the first house)
        int max2 = robLinear(nums, 1, n - 1);

        // The answer is the maximum of the two cases.
        return Math.max(max1, max2);
    }

    private static int robLinear(int[] nums, int start, int end) {
        int robPrev = 0; // -> max money robbing up to i-1
        int robPrevPrev = 0; // max money robbing up to i-2

        for (int i = start; i <= end; i++) {
            // At house i, we have two choices:
            // 1. Rob house i: This means we add nums[i] to the max we had at i-2 (robPrevPrev).
            // 2. Don't rob house i: This means we just take the max we had at i-1 (robPrev).
            int currentMax = Math.max(robPrev, robPrevPrev + nums[i]);

            // Shift the pointers for the next iteration
            robPrevPrev = robPrev;
            robPrev = currentMax;
        }

        // After the loop, robPrev holds the max money for the entire range.
        return robPrev;
    }

    public static void main(String[] args) {
        // Example 1: nums = [2,3,2]
        int[] nums1 = {2, 3, 2};
        int result1 = rob(nums1);
        System.out.println("Input: [2, 3, 2]");
        System.out.println("Output: " + result1); // Expected: 3

        System.out.println("--------------------");

        // Example 2: nums = [1,2,3,1]
        int[] nums2 = {1, 2, 3, 1};
        int result2 = rob(nums2);
        System.out.println("Input: [1, 2, 3, 1]");
        System.out.println("Output: " + result2); // Expected: 4

        System.out.println("--------------------");

        // Example 3: nums = [1,2,3]
        int[] nums3 = {1, 2, 3};
        int result3 = rob(nums3);
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + result3); // Expected: 3

        System.out.println("--------------------");

        // Edge Case: nums = [1]
        int[] nums4 = {1};
        int result4 = rob(nums4);
        System.out.println("Input: [1]");
        System.out.println("Output: " + result4); // Expected: 1
    }
}
