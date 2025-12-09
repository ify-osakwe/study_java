package dsa.problems.sorting;

import java.util.Arrays;

/**
 * Merge Sorted Arrays
 * <a href="https://gemini.google.com/share/67d7ceeabe20">Gemini Link</a>
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;  // pointer for the last valid element in nums1
        int pointer2 = n - 1;  // pointer for the last element in nums2

        // Pointer for the end of the total array (where we write the values)
        int pointer = m + n - 1;

        // While both arrays have elements left to compare
        while (pointer1 >= 0 && pointer2 >= 0) {
            // Compare the tails of both arrays.
            // Put the larger one at the end of nums1.
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[pointer] = nums1[pointer1];
                pointer1--; // Move nums1 pointer left
            } else {
                nums1[pointer] = nums2[pointer2];
                pointer2--; // Move nums2 pointer left
            }
            pointer--; // Move the write pointer left
        }

        // EDGE CASE HANDLING:
        // If nums2 still has elements left (pointer2 >= 0), we need to copy them.
        // This happens if nums1's elements were all larger and moved to the end,
        // leaving the smallest elements of nums2 to be filled in the front.
        while (pointer2 >= 0) {
            nums1[pointer] = nums2[pointer2];
            pointer2--;
            pointer--;
        }

        // Note: We don't need a while(pointer1 >= 0) loop.
        // If nums2 runs out first, the remaining elements in nums1 are
        // already in their correct, sorted positions at the front of the array.
    }

    public static void main(String[] args) {
        // Test Case 1: Standard merge
        System.out.println("Test Case 1:");
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Before: " + Arrays.toString(nums1));
        merge(nums1, m, nums2, n);
        System.out.println("After:  " + Arrays.toString(nums1));
        System.out.println("-----------------------------");

        // Test Case 2: nums1 is empty (conceptually), nums2 has elements
        System.out.println("Test Case 2 (nums1 empty):");
        int[] nums1b = {0}; // length is m + n = 0 + 1
        int mb = 0;
        int[] nums2b = {1};
        int nb = 1;

        System.out.println("Before: " + Arrays.toString(nums1b));
        merge(nums1b, mb, nums2b, nb);
        System.out.println("After:  " + Arrays.toString(nums1b));
        System.out.println("-----------------------------");

        // Test Case 3: nums2 is empty
        System.out.println("Test Case 3 (nums2 empty):");
        int[] nums1c = {1};
        int mc = 1;
        int[] nums2c = {};
        int nc = 0;

        System.out.println("Before: " + Arrays.toString(nums1c));
        merge(nums1c, mc, nums2c, nc);
        System.out.println("After:  " + Arrays.toString(nums1c));
    }
}
