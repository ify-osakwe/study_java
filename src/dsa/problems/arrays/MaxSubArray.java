package dsa.problems.arrays;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * <p>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * <p>
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * <p>
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * <p>
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution
 * using the divide and conquer approach, which is more subtle.
 * <p>
 * Finding Maximum Subarray Sum
 * <a href="https://gemini.google.com/share/c6674d289cfd">Gemini Link</a>
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    // Kadane's Algorithm : O(n) time & O(1) space
    public static int maxSubArray(int[] nums) {
        // 1. Initialize
        // We start by assuming the first element is the largest sum.
        int maxSum = nums[0];
        int currentSum = nums[0];

        // 2. Loop
        // Start from the second element (index 1)
        for (int i = 1; i < nums.length; i++) {

            // 3. The Key Decisions
            int num = nums[i];

            // Decision 1:
            // Should we continue our current subarray (currentSum + num)
            // or start a new one (just num)?
            // We take whichever is larger.
            currentSum = Math.max(num, currentSum + num);

            // Decision 2:
            // Is our new currentSum the new champion?
            // We check it against our overall maxSum.
            maxSum = Math.max(maxSum, currentSum);
        }

        // 4. Return the champion
        return maxSum;
    }

    /**
     * Finds the contiguous subarray with the largest sum and prints it.
     * @param nums The input integer array.
     * @return The sum of the largest subarray.
     */
    public int maxSubArrayAndPrint(int[] nums) {
        // 1. Handle edge case of an empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 2. Initialize all our variables
        int maxSum = nums[0];       // The overall champion sum
        int currentSum = nums[0];   // The sum of the subarray we're currently building

        int maxStart = 0;     // Start index of the champion subarray
        int maxEnd = 0;       // End index of the champion subarray
        int currentStart = 0; // Start index of the *current* subarray

        // 3. Loop (start from the second element, index 1)
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // --- Decision 1: Continue or Restart? ---
            // Check if starting a new subarray (just 'num') is better
            // than adding to our current one (currentSum + num).
            if (num > currentSum + num) {
                // We are restarting.
                currentSum = num;
                currentStart = i; // This is the key: log the start of the new subarray
            } else {
                // We are continuing.
                currentSum = currentSum + num;
                // currentStart does not change
            }

            // --- Decision 2: Do we have a new champion? ---
            // Check if our current subarray's sum beats the overall max.
            if (currentSum > maxSum) {
                maxSum = currentSum;          // Update the champion sum
                maxStart = currentStart;      // Store the start of this new champion
                maxEnd = i;                   // Store the end (our current position)
            }
        }

        // 4. Print the results
        System.out.print("Max Sum: " + maxSum);
        System.out.print(", Subarray: [");
        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.print(nums[i]);
            if (i < maxEnd) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Indices: [" + maxStart + "..." + maxEnd + "]");

        // 5. Return the sum
        return maxSum;
    }
}
