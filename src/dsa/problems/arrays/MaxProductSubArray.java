package dsa.problems.arrays;

/**
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product. The test cases are generated so that the answer will fit
 * in a 32-bit integer. Note that the product of an array with a single element
 * is the value of that element.
 * <p>
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 10^4
 * <p>
 * -10 <= nums[i] <= 10
 * <p>
 * The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * Maximum Product Subarray Algorithm Explained
 * <a href="https://gemini.google.com/share/b1ce06641daf">Gemini Link</a>
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        // Handle the edge case of an empty array.
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize our three tracking variables
        // to the first element in the array.
        int globalMax = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        // Start the loop from the second element (index 1)
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            // We must store the *previous* maxSoFar in a temporary variable.
            // If we don't, we'll use the *new* maxSoFar when calculating minSoFar,
            // which would be incorrect.
            int tempMax = maxSoFar;

            maxSoFar = Math.max(n, Math.max(n * tempMax, n * minSoFar));
            minSoFar = Math.min(n, Math.min(n * tempMax, n * minSoFar));

            // Update the globalMax if our new maxSoFar is the largest we've seen
            globalMax = Math.max(globalMax, maxSoFar);
        }

        return globalMax;
    }
}
