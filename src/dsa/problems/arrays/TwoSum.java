package dsa.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume that each input would have exactly one
 * solution, and you may not use the same element twice. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15],
 * target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4],
 * target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3],
 * target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^4
 * <p>
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * -10^9 <= target <= 10^9
 * <p>
 * Only one valid answer exists.
 * <p>
 * Two Sum Problem: Efficient Algorithm Strategy
 * <a href="https://gemini.google.com/share/7961abc4eda2">Gemini Link</a>
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 1. Create the HashMap to store (value, index) pairs.
        Map<Integer, Integer> seenNumbers = new HashMap<>();

        // 2. Loop through the array once.
        for (int i = 0; i < nums.length; i++) {

            // 3. Calculate the complement needed to reach the target.
            int complement = target - nums[i];

            // 4. Check if the complement already exists in the map.
            if (seenNumbers.containsKey(complement)) {

                // 5. If it exists, we found our pair!
                // Return the complement's index (from the map) and the current index (i).
                return new int[]{seenNumbers.get(complement), i};
            }

            // 6. If the complement is not found, add the *current* number
            //    and its index to the map for future checks.
            seenNumbers.put(nums[i], i);
        }

        // 7. If the loop finishes without finding a solution (per the
        //    problem constraints, this shouldn't happen, but Java requires it).
        throw new IllegalArgumentException("No two sum solution found");
    }
}
