package dsa.problems.arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array
 * [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 * Your solution must use only constant extra space.
 * <p>
 * Example 1:
 * Input: numbers = [2,7,11,15],
 * target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9.
 * Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Example 2:
 * Input: numbers = [2,3,4],
 * target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6.
 * Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Example 3:
 * Input: numbers = [-1,0],
 * target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Constraints:
 * <p>
 * 2 <= numbers.length <= 3 * 10^4
 * <p>
 * -1000 <= numbers[i] <= 1000
 * <p>
 * numbers is sorted in non-decreasing order.
 * <p>
 * -1000 <= target <= 1000
 * <p>
 * Two Pointers for Sorted Array Sum
 * <a href="https://gemini.google.com/share/027aa98aae79">Gemini Link</a>
 */
public class TwoSumII {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // We will loop as long as the left pointer is to the left of the right pointer.
        // Once they cross or meet, we've checked all possible pairs.
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            // --- The Core Logic ---

            // Case 1: We found the solution!
            if (currentSum == target) {
                // The problem asks for 1-based indices, so we add 1 to our 0-based indices.
                return new int[] { left + 1, right + 1 };
            }

            // Case 2: The sum is too small.
            else if (currentSum < target) {
                // Since the array is sorted, the only way to get a larger sum
                // is to move the 'left' pointer to the right, to a larger number.
                left++;
            }

            // Case 3: The sum is too big.
            else { // currentSum > target
                // Since the array is sorted, the only way to get a smaller sum
                // is to move the 'right' pointer to the left, to a smaller number.
                right--;
            }
        }

        // The problem guarantees exactly one solution exists, so the loop will
        // always return from within. This is just a fallback.
        // In a real-world scenario without that guarantee, you might return null
        // or throw an exception.
        return new int[] {};
    }
}
