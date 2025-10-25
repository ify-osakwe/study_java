package dsa.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least
 * twice in the array, and return false if every element is distinct.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation: The element 1 occurs at the indices 0 and 3.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: All elements are distinct.
 * <p>
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        // walk thorugh the array
        // create a hashmap, key is the number, and value is the occurence
        // if you meet a number matching a key, increment the value
        // walk thorugh the map, if any value is greater than 1,
        // there is a duplicate, return true, else return false

        Map<Integer, Integer> fMap = new HashMap<>();
        for (int num : nums) {
            if (fMap.containsKey(num)) {
                fMap.put(num, fMap.get(num) + 1);
            } else {
                fMap.put(num, 1);
            }
        }
        System.out.println("Map: " + fMap);

        for (Integer value : fMap.values()) {
            if (value > 1) {
                return true;
            }
        }
        return false;
    }
}
