package dsa.problems.arrays;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * <p>
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
 * results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * <p>
 * Example 3:
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * <p>
 * Constraints:
 * n == nums.length
 * <p>
 * 1 <= n <= 5000
 * <p>
 * -5000 <= nums[i] <= 5000
 * <p>
 * All the integers of nums are unique.
 * <p>
 * nums is sorted and rotated between 1 and n times.
 * <p>
 * Finding Minimum in Rotated Sorted Array
 * <a href="https://gemini.google.com/share/def5ad7d263e">Gemini Link</a>
 */
public class FindMinRotatedSortArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Our loop continues as long as the search space
        // has more than one element.
        while (low < high) {
            int middle = low + (high - low) / 2;

            if (nums[middle] > nums[high]) {
                // Case 1: Middle is in the "high" part.
                // The minimum MUST be to its right.
                low = middle + 1;
            } else {
                // Case 2: Middle is in the "low" part.
                // The minimum is either 'middle' itself or to its left.
                high = middle;
            }
        }

        // When low == high, the loop stops, and they
        // are both pointing at the minimum element.
        return nums[low];
    }
}
