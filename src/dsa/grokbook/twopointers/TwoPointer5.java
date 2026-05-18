package dsa.grokbook.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Triplet Sum to Zero (medium).
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
public class TwoPointer5 {
    public static void main(String[] args) {
        int[] arr1 = {-3, 0, 1, 2, -1, 1, -2};
        // output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]

        int[] arr2 = {-5, 2, -1, -2, 3};
        // output: [[-5, 2, 3], [-2, -1, 3]]

        System.out.println("Triplets: " + searchTriplets(arr1));
        System.out.println("Triplets: " + searchTriplets(arr2));
    }

    private static List<List<Integer>> searchTriplets(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue;
            searchPair(array, -array[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(
            int[] array,
            int targetSum,
            int leftIdx,
            List<List<Integer>> triplets
    ) {
        int rightIdx = array.length - 1;
        while (leftIdx < rightIdx) {
            int currentSum = array[leftIdx] + array[rightIdx];
            if (currentSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, array[leftIdx], array[rightIdx]));
                leftIdx++;
                rightIdx--;
                // skip same elements to avoid duplicate triplets
                while (leftIdx < rightIdx && array[leftIdx] == array[leftIdx - 1]) leftIdx++;
                while (leftIdx < rightIdx && array[rightIdx] == array[rightIdx + 1]) rightIdx--;
            } else if (targetSum > currentSum) {
                leftIdx++; // we need a pair with a bigger sum
            } else {
                rightIdx--; // we need a pair with a smaller sum
            }
        }
    }
}
