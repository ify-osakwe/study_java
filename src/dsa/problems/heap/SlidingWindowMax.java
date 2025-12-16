package dsa.problems.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Sliding Windows Max
 * <a href="https://gemini.google.com/share/3fc8abd68970">Gemini Link</a>
 */
public class SlidingWindowMax {
    private static int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case handling
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        // The result array size is n - k + 1
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // Deque to store INDICES of array elements
        // Using ArrayDeque is generally faster than LinkedList for queue operations
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Clean from the Back:
            // Remove indices of elements that are smaller than the current element nums[i].
            // If nums[i] is bigger, the smaller elements to its left are useless
            // because they will never be the maximum of a window that includes nums[i].
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 2. Add Current:
            // Add the current index to the back of the Deque
            deque.offerLast(i);

            // 3. Clean from the Front:
            // Remove the index at the front if it falls outside the current window.
            // The current window range is [i - k + 1, i].
            // If the front index is <= i - k, it is outdated.
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 4. Add to Result:
            // Once we have processed at least k elements (i >= k - 1),
            // the front of the deque is the maximum for the current window.
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println("Example 1 Input: " + Arrays.toString(nums1) + ", k=" + k1);
        int[] output1 = maxSlidingWindow(nums1, k1);
        System.out.println("Example 1 Output: " + Arrays.toString(output1));

        System.out.println("--------------------------");

        // Example 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Example 2 Input: " + Arrays.toString(nums2) + ", k=" + k2);
        int[] output2 = maxSlidingWindow(nums2, k2);
        System.out.println("Example 2 Output: " + Arrays.toString(output2));

        System.out.println("--------------------------");

        // Example 3: Decreasing sequence
        int[] nums3 = {9, 8, 7, 6, 5, 4};
        int k3 = 3;
        System.out.println("Example 3 Input: " + Arrays.toString(nums3) + ", k=" + k3);
        int[] output3 = maxSlidingWindow(nums3, k3);
        System.out.println("Example 3 Output: " + Arrays.toString(output3));
    }
}
