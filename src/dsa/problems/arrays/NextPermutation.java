package dsa.problems.arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are all the permutations of
 * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * <p>
 * The next permutation of an array of integers is the next lexicographically greater permutation
 * of its integer. More formally, if all the permutations of the array are sorted in one container
 * according to their lexicographical order, then the next permutation of that array is the
 * permutation that follows it in the sorted container. If such arrangement is not possible,
 * the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
 * lexicographical larger rearrangement.
 * <p>
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * <p>
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * <p>
 * 0 <= nums[i] <= 100
 * <p>
 * Next Permutation Algorithm Explained
 * <a href="https://gemini.google.com/share/1f924714f166">Gemini Link</a>
 */
public class NextPermutation {
    public static void main(String[] args) {
        // Example 1: [1, 2, 3] -> [1, 3, 2]
        int[] nums1 = {1, 2, 3};
        System.out.println("Original: " + java.util.Arrays.toString(nums1));
        nextPermutation(nums1);
        System.out.println("Next:     " + java.util.Arrays.toString(nums1));
        System.out.println("---");

        // Example 2: [3, 2, 1] -> [1, 2, 3]
        int[] nums2 = {3, 2, 1};
        System.out.println("Original: " + java.util.Arrays.toString(nums2));
        nextPermutation(nums2);
        System.out.println("Next:     " + java.util.Arrays.toString(nums2));
        System.out.println("---");

        // Example 3: [1, 1, 5] -> [1, 5, 1]
        int[] nums3 = {1, 1, 5};
        System.out.println("Original: " + java.util.Arrays.toString(nums3));
        nextPermutation(nums3);
        System.out.println("Next:     " + java.util.Arrays.toString(nums3));
        System.out.println("---");

        // Example 4: [1, 3, 2] -> [2, 1, 3]
        int[] nums4 = {1, 3, 2};
        System.out.println("Original: " + java.util.Arrays.toString(nums4));
        nextPermutation(nums4);
        System.out.println("Next:     " + java.util.Arrays.toString(nums4));
        System.out.println("---");

        // Example 5 (from explanation): [1, 5, 8, 4, 7, 6, 5, 3, 1] -> [1, 5, 8, 5, 1, 3, 4, 6, 7]
        int[] nums5 = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        System.out.println("Original: " + java.util.Arrays.toString(nums5));
        nextPermutation(nums5);
        System.out.println("Next:     " + java.util.Arrays.toString(nums5));
        System.out.println("---");
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int arrayLength = nums.length;

        // --- Step 1: Find the "pivot" ---
        // Find the largest index i such that nums[i] < nums[i+1]
        // We scan from right-to-left.
        int i = arrayLength - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        // At this point, i is the index of our "pivot" element.
        // The subarray to its right (nums[i+1]...nums[n-1]) is in descending order.

        // --- Step 2: Find swap target and swap (if pivot exists) ---
        if (i >= 0) {
            // Find the largest index j (where j > i) such that nums[j] > nums[i]
            // We scan from right-to-left.
            int j = arrayLength - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }

            // Swap the pivot (nums[i]) with the swap target (nums[j])
            swap(nums, i, j);
        }

        // --- Step 3: Reverse the suffix ---
        // If i < 0 (no pivot found), the whole array is in descending order.
        // We reverse the whole array to get the smallest permutation.
        //
        // If i >= 0 (pivot was found), we reverse the subarray to the right of the
        // original pivot position (i+1) to make that suffix as small as possible.
        reverse(nums, i + 1, arrayLength - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
