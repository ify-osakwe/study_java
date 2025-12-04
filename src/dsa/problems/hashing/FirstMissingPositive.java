package dsa.problems.hashing;

import java.util.Arrays;

/**
 * First Missing Positive
 * <a href="https://gemini.google.com/share/44953db531ef">Gemini Link</a>
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int arrayLength = nums.length;
        int i = 0;

        // Phase 1: Cyclic Sort
        // Place each number X at index X-1 if X is within range [1, arrayLength].
        while (i < arrayLength) {
            // The number we are looking at
            int correctIndex = nums[i] - 1;

            // Conditions to swap:
            // 1. nums[i] > 0: We only care about positive numbers.
            // 2. nums[i] <= arrayLength: We only care about numbers that fit in the array bounds.
            // 3. nums[i] != nums[correctIndex]: The number is not already at its target position
            //    (this also handles duplicates to prevent infinite loops).
            if (nums[i] > 0 && nums[i] <= arrayLength && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
                // Note: We do NOT increment 'i' here. We need to check the
                // new number that was just swapped into position 'i'.
            } else {
                // If the number is negative, out of bounds, or already correct, move on.
                i++;
            }
        }

        // Phase 2: Scan for the first missing number
        // We expect nums[i] to be i + 1.
        for (int index = 0; index < arrayLength; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        // Phase 3: If all numbers 1..arrayLength are present, the missing one is arrayLength + 1.
        return arrayLength + 1;
    }

    // Helper method to swap elements in the array
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {1, 2, 0};
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("First Missing Positive: " + firstMissingPositive(input1));
        // Expected: 3
        System.out.println("----------------------------");

        // Test Case 2
        int[] input2 = {3, 4, -1, 1};
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("First Missing Positive: " + firstMissingPositive(input2));
        // Expected: 2
        System.out.println("----------------------------");

        // Test Case 3
        int[] input3 = {7, 8, 9, 11, 12};
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("First Missing Positive: " + firstMissingPositive(input3));
        // Expected: 1
        System.out.println("----------------------------");

        // Test Case 4 (Edge case: Duplicates)
        int[] input4 = {1, 1};
        System.out.println("Input: " + Arrays.toString(input4));
        System.out.println("First Missing Positive: " + firstMissingPositive(input4));
        // Expected: 2
        System.out.println("----------------------------");

        // Test Case 5 (Edge case: Sorted perfect array)
        int[] input5 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(input5));
        System.out.println("First Missing Positive: " + firstMissingPositive(input5));
        // Expected: 4
    }
}
