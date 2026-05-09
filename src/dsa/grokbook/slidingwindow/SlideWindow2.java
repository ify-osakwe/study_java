package dsa.grokbook.slidingwindow;

/**
 * Smallest subarray with a given sum.
 * Given an array of positive numbers and a positive number ‘S’, find the length of
 * the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 * :: the size of the sliding window is not fixed in this question
 */
public class SlideWindow2 {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 2, 3, 2};
        int[] arr2 = {2, 1, 5, 2, 8};
        int[] arr3 = {3, 4, 1, 1, 6};
        int s1 = 7, s2 = 8, s3 = 8;

        System.out.println("Smallest sub-array: " + findMinSubArray(s1, arr1));
        System.out.println("Smallest sub-array: " + findMinSubArray(s2, arr2));
        System.out.println("Smallest sub-array: " + findMinSubArray(s3, arr3));
    }

    // time complecity is O(N)
    // space complexity is O(1)
    private static int findMinSubArray(int S, int[] array) {
        int windowSum = 0, windowStart = 0, minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd];
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= array[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
