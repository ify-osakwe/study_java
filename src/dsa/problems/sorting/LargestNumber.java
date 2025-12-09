package dsa.problems.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * <a href="https://gemini.google.com/share/556beb9f18c5">Gemini Link</a>
 */
public class LargestNumber {

    public static String solution(int[] nums) {
        // Step 1: Convert int array to String array
        // We need strings to easily perform concatenation checks (e.g., "3" + "30")
        String[] stringArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringArray[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort the strings using a custom comparator
        // The logic is: given two strings s1 and s2,
        // we compare the result of s1+s2 vs s2+s1.
        // If (s2 + s1) is larger than (s1 + s2), then s2 should come before s1.
        Comparator<String> customComp = (s1, s2) -> {
            String order1 = s1 + s2;
            String order2 = s2 + s1;

            // standard compareTo returns negative if order1 < order2.
            // We want descending order (largest combination first),
            // so we compare order2 to order1.
            return order2.compareTo(order1);
        };

        Arrays.sort(stringArray, customComp);

        // Step 3: Handle the edge case of multiple zeros
        // After sorting, if the largest number is "0", the result is "0".
        // Example: Input [0, 0] -> Sorted ["0", "0"] -> Result should be "0", not "00".
        if (stringArray[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the final string
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {10, 2};
        System.out.println("Input: [10, 2]");
        System.out.println("Output: " + solution(nums1));
        // Expected: "210"

        System.out.println("-----------------");

        // Test Case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Input: [3, 30, 34, 5, 9]");
        System.out.println("Output: " + solution(nums2));
        // Expected: "9534330"

        System.out.println("-----------------");

        // Test Case 3 (Edge Case: Zeros)
        int[] nums3 = {0, 0, 0};
        System.out.println("Input: [0, 0, 0]");
        System.out.println("Output: " + solution(nums3));
        // Expected: "0"

        System.out.println("-----------------");

        // Test Case 4 (Edge Case: Large Numbers)
        int[] nums4 = {999999998, 999999997, 999999999};
        System.out.println("Input: [999999998, 999999997, 999999999]");
        System.out.println("Output: " + solution(nums4));
        // Expected: "999999999999999998999999997"
    }
}
