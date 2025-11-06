package dsa.problems.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [5,7,7,8,8,10],
 * target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * Input: nums = [5,7,7,8,8,10],
 * target = 6
 * Output: [-1,-1]
 * <p>
 * Example 3:
 * Input: nums = [],
 * target = 0
 * Output: [-1,-1]
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * <p>
 * -109 <= nums[i] <= 10^9
 * <p>
 * nums is a non-decreasing array.
 * <p>
 * -10^9 <= target <= 10^9
 * <p>
 * Finding Target Range with Binary Search
 * <a href="https://gemini.google.com/share/b76877906c3e">Gemini Link</a>
 */
public class FirstLastPosition {
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [3, 4]
        System.out.println("--------------------");

        // Example 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [-1, -1]
        System.out.println("--------------------");

        // Example 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = searchRange(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected: [-1, -1]
        System.out.println("--------------------");

        // Additional Test Case: Target at the edges
        int[] nums4 = {8, 8, 8, 8, 8};
        int target4 = 8;
        int[] result4 = searchRange(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4)); // Expected: [0, 4]
        System.out.println("--------------------");
    }

    public static int[] searchRange(int[] nums, int target) {
        // Create an array to store the result
        int[] result = new int[2];

        // Run two separate binary searches:
        // 1. findFirst to get the leftmost index
        // 2. findLast to get the rightmost index
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }

    private static int findFirst(int[] nums, int target) {
        int index = -1; // Default value if not found
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                right = mid - 1; // continue searching to the *left* if earlier occurrence exists.
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    private static int findLast(int[] nums, int target) {
        int index = -1; // Default value if not found
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // We found a match!
                // This *might* be the last one. Store it.
                index = mid;
                // But we must continue searching to the *right*
                // to see if an even later occurrence exists.
                left = mid + 1;

            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
