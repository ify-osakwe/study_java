package dsa.problems.heap;

import java.util.Arrays;
import java.util.Random;

/**
 * Kth Largest
 * <a href="https://gemini.google.com/share/84a4b1d3a29a">Gemini Link</a>
 */
public class KthLargest {

    /**
     * Finds the kth largest element in an unsorted array.
     * Strategy: QuickSelect (Hoare's selection algorithm).
     * Time Complexity: O(N) average, O(N^2) worst case (rare with randomization).
     * Space Complexity: O(1) iterative (or O(log N) stack recursion).
     */
    private static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int targetIndex = n - k; // the kth largest is at index n - k, in a sorted array

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            // Partition the array around a random pivot
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == targetIndex) {
                // Found the element
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                // The target is in the right half
                left = pivotIndex + 1;
            } else {
                // The target is in the left half
                right = pivotIndex - 1;
            }
        }

        return -1; // Should not reach here given valid constraints
    }

    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();

        // 1. Pick a random pivot index between left and right
        int pivotRandomIndex = left + random.nextInt(right - left + 1);

        // 2. Move the pivot to the end of the array temporarily to get it out of the way
        swap(nums, pivotRandomIndex, right);

        int pivotValue = nums[right];
        int storeIndex = left;

        // 3. Iterate through the range and move smaller elements to the 'storeIndex'
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // 4. Move pivot from the end to its final correct position (storeIndex)
        swap(nums, storeIndex, right);

        return storeIndex;
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int findKthLargestWithSorting(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int kthLargestIndex = nums.length - k;
        return nums[kthLargestIndex];
    }

    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        int result1 = findKthLargest(nums1, k1);
        int result1b = findKthLargestWithSorting(nums1, k1);
        System.out.println("Output: " + result1 + " " + result1b); // Expected: 5
        System.out.println("--------------------------");

        // Example 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        int result2 = findKthLargest(nums2, k2);
        int result2b = findKthLargestWithSorting(nums2, k2);
        System.out.println("Output: " + result2 + " " + result2b); // Expected: 4
        System.out.println("--------------------------");

        // Edge Case: Single element
        int[] nums3 = {1};
        int k3 = 1;
        System.out.println("Test Case 3 (Single Element):");
        System.out.println("Input: " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output: " + findKthLargest(nums3, k3) +
                " " + findKthLargestWithSorting(nums3, k3)); // Expected: 1
    }
}
