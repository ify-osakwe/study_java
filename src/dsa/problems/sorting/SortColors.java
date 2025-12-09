package dsa.problems.sorting;

import java.util.Arrays;

/**
 * Sort Colors : Dutch National Flag
 * <a href="https://gemini.google.com/share/7ff64d98b844">Gemini Link</a>
 */
public class SortColors {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // low: Tracks the boundary where the next 0 should go.
        // mid: The current element we are inspecting (our iterator).
        // high: Tracks the boundary where the next 2 should go.
        int low = 0;                // Pointer for the end of the 0s section
        int high = nums.length - 1; // Pointer for the start of the 2s section
        int mid = 0;                // Current iterator

        // Continue until the mid pointer crosses the high pointer
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Found a 0. Swap it to the 'low' boundary. Move boundaries forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Found a 1. It's in the correct relative middle position. move to the next element
                mid++;
            } else {
                // Found a 2. Swap it to the 'high' boundary. Shrink the 'high' boundary
                swap(nums, mid, high);
                high--;

                // IMPORTANT: Do NOT increment mid here.
                // The value swapped from 'high' into 'mid' is unknown.
                // We must process nums[mid] again in the next iteration.
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {2, 0, 2, 1, 1, 0};
        System.out.println("Test Case 1:");
        System.out.println("Input:  " + Arrays.toString(input1));
        sortColors(input1);
        System.out.println("Output: " + Arrays.toString(input1));
        System.out.println();

        // Test Case 2
        int[] input2 = {2, 0, 1};
        System.out.println("Test Case 2:");
        System.out.println("Input:  " + Arrays.toString(input2));
        sortColors(input2);
        System.out.println("Output: " + Arrays.toString(input2));
        System.out.println();

        // Test Case 3 (Edge case: already sorted)
        int[] input3 = {0, 1, 2};
        System.out.println("Test Case 3 (Already Sorted):");
        System.out.println("Input:  " + Arrays.toString(input3));
        sortColors(input3);
        System.out.println("Output: " + Arrays.toString(input3));
    }
}
