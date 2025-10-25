package dsa.problems.backtracking;

import java.util.ArrayList;

public class SumSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 8};
        int target = 9;

        System.out.println("Finding subsets for target: " + target);
        // We start the process at index 0, with a sum of 0, and an empty list.
        findSubsets(arr, target, 0, 0, new ArrayList<Integer>());
    }

    /**
     * The main recursive backtracking function.
     * @param arr The original array of numbers.
     * @param targetSum The sum we are trying to find.
     * @param index The current index in the array we are considering.
     * @param currentSum The sum of the subset we've built so far.
     * @param currentSubset The list of numbers in our current subset.
     */
    public static void findSubsets(int[] arr, int targetSum, int index,
                                   int currentSum, ArrayList<Integer> currentSubset
    ) {

        // --- BASE CASES (The "Dead Ends") ---

        // 1. SUCCESS: We found a solution!
        if (currentSum == targetSum) {
            System.out.println("Solution found: " + currentSubset);
            // We return here. If we wanted *all* solutions, we'd print
            // and then continue, but for this, we'll stop at the first.
            // Or, to find all, we just remove the 'return' and let it keep searching.
            // For this example, let's just print and return.
            return;
        }

        // 2. DEAD END: We've run out of numbers to check.
        if (index == arr.length) {
            return;
        }

        // 3. DEAD END (Optimization): Our sum is already too big.
        if (currentSum > targetSum) {
            return;
        }

        // --- RECURSIVE STEPS (The "Two Choices") ---

        // CHOICE 1: "Include" the number at arr[index]
        // We add the number to our list...
        currentSubset.add(arr[index]);
        // ...and recurse, moving to the next index and adding to the sum.
        findSubsets(arr, targetSum, index + 1, currentSum + arr[index], currentSubset);


        // CHOICE 2: "Ignore" the number at arr[index]
        // *** This is the "Backtrack" step! ***
        // We must remove the number we just added to explore the *other* path.
        currentSubset.removeLast(); // currentSubset.remove(currentSubset.size() - 1);

        // ...and recurse, moving to the next index but *not* adding to the sum.
        findSubsets(arr, targetSum, index + 1, currentSum, currentSubset);
    }
}
