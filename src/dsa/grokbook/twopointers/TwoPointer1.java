package dsa.grokbook.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Pair with Target sum (easy).
 * Given an array of sorted numbers and a target sum,
 * find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair)
 * such that they add up to the given target.
 */
public class TwoPointer1 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6}; // output {1,3}
        int t1 = 6;

        int[] arr2 = {2, 5, 9, 11}; // output {0,2}
        int t2 = 11;

        System.out.println("Pair with target sum: " + Arrays.toString(pairWithTargetSum(arr1, t1)));
        System.out.println("Pair with target sum: " + Arrays.toString(pairWithTargetSum(arr2, t2)));

        System.out.println("Pair with target sum: " + Arrays.toString(pairWithTargetSum2(arr1, t1)));
        System.out.println("Pair with target sum: " + Arrays.toString(pairWithTargetSum2(arr2, t2)));
    }

    // time complexity O(N)
    // space complexity is O(1)
    private static int[] pairWithTargetSum(int[] array, int targetSum) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) {
                return new int[]{left, right};
            }
            if (targetSum > currentSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // time complexity O(N)
    // space complexity is O(N) for worst case scenario
    private static int[] pairWithTargetSum2(int[] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(targetSum - array[i])) {
                return new int[]{map.get(targetSum - array[i]), i};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
