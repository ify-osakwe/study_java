package dsa.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000.
 * <p>
 * -10^5 <= nums[i] <= 10^5.
 * <p>
 * Solving 3Sum with Sort and Two Pointers
 * <a href="https://gemini.google.com/share/a3ae1eb5a828">Gemini Link</a>
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }

        // 2. Sort the array. This is the most crucial step.
        // It allows us to use the two-pointer technique and
        // easily skip duplicate numbers.
        // Time complexity of sort is O(n log n).
        Arrays.sort(nums);

        for (int index = 0; index < nums.length - 2; index++) {

            // 4. Optimization: If the smallest number (nums[i]) is already
            // positive, we can stop. Since the array is sorted,
            // any number after it will also be positive, and their
            // sum can never be 0.
            if (nums[index] > 0) {
                break;
            }

            // 5. Crucial: Skip duplicate `i` values.
            // If the current number is the same as the previous one,
            // we have already processed it as the first element.
            // Continuing would just create duplicate triplets.
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            int left = index + 1;
            int right = nums.length - 1;

            // 7. The two-pointer "search" loop.
            // This loop runs in O(n) time for each `i`.
            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];

                if (sum == 0) {
                    results.add(Arrays.asList(nums[index], nums[left], nums[right]));

                    // 9. Crucial: Skip duplicates for `left` and `right`.
                    // We move the left pointer forward as long as it's
                    // pointing to the same number, to avoid adding
                    // duplicate triplets like [-1, 0, 1] and [-1, 0, 1].
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Do the same for the right pointer, moving backward.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 10. Move both pointers inward to find the next
                    // potential pair.
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results;
    }
}
