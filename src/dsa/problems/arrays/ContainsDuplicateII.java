package dsa.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct
 * indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p>
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("Example 1: " + containsNearbyDuplicate(nums1, k1));

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Example 2: " + containsNearbyDuplicate(nums2, k2));

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Example 3: " + containsNearbyDuplicate(nums3, k3));
    }

    /**
     * We create a HashMap<Integer, Integer> that will store key-value pairs of (number, index).
     * <p>
     * We loop through the array from left to right (from i = 0 to n-1).
     * <p>
     * For each number nums[i], we ask the HashMap: "Have we seen this number before?"
     * <p>
     * If YES: The map contains the number. This means we've found a duplicate.
     * We get its previous index (prevIndex) from the map. We then check if the distance between
     * the current index (i) and the previous index (prevIndex) is within our limit k.
     * <p>
     * If i - prevIndex <= k, we have found a pair that satisfies both conditions
     * (same value and close-enough indices). We can immediately stop and return true.
     * <p>
     * If NO: This is the first time we're seeing this number (or the previous one was too far away).
     * <p>
     * Crucially, in every iteration (whether we found a match or not), we update the map with
     * the current number and its index: map.put(nums[i], i). This ensures that if we see this
     * number again, we will be comparing it against its closest predecessor, which is all we
     * need to satisfy the condition.
     * <p>
     * If we get all the way through the loop without returning true, it means no such pair
     * exists, so we return false.
     */
    public static boolean containsNearbyDuplicate(int[] numbers, int k) {
        // create a HashMap<Integer, Integer> that will store key-value pairs of (number, index).
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            if (map.containsKey(currentNum)) {
                int prevIndex = map.get(currentNum);
                if (Math.abs(i - prevIndex) <= k) {
                    return true;
                }
            }
            map.put(currentNum, i);
        }

        return false;
    }
}
