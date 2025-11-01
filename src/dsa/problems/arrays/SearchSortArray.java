package dsa.problems.arrays;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an
 * unknown index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * <p>
 * For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of
 * target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2],
 * target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2],
 * target = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: nums = [1],
 * target = 0
 * Output: -1
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * <p>
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * All values of nums are unique.
 * <p>
 * nums is an ascending array that is possibly rotated.
 * <p>
 * -10^4 <= target <= 10^4
 * <p>
 * Searching Rotated Sorted Array Algorithm
 * <a href="https://gemini.google.com/share/be4ec683ecbd">Gemini Link</a>
 */
public class SearchSortArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 0));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 2. Check if the left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Case 1: Left half is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Case 2: Right half is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
