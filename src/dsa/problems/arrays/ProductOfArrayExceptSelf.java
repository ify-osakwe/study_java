package dsa.problems.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the
 * product of all the elements of nums except nums[i]. The product of any prefix or suffix
 * of nums is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in
 * O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^5
 * <p>
 * -30 <= nums[i] <= 30
 * <p>
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array
 * does not count as extra space for space complexity analysis.)
 * <p>
 * Product Except Self Algorithm Explained
 * <a href="https://gemini.google.com/share/54d42120df27">Gemini Link</a>
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));

        System.out.println("=====");
        System.out.println(Arrays.toString(productExceptSelfV2(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelfV2(new int[]{-1,1,0,-3,3})));
    }

    // O(n) time and O(1) space
    public static int[] productExceptSelf(int[] nums) {
        int arraylen = nums.length;
        int[] answer = new int[arraylen];

        int leftProduct = 1;
        for (int i = 0; i < arraylen; i++) {
            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;
        for (int i = arraylen - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    // O(n) time and O(n) space
    public static int[] productExceptSelfV2(int[] nums) {
        int arraylen = nums.length;
        int[] leftProducts = new int[arraylen];
        int[] rightProducts = new int[arraylen];
        int[] answer = new int[arraylen]; // This is our final output array

        leftProducts[0] = 1;
        for (int i = 1; i < arraylen; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[arraylen - 1] = 1;
        for (int i = arraylen - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < arraylen; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }
        return answer;
    }
}
