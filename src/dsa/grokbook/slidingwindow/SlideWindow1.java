package dsa.grokbook.slidingwindow;

import java.util.Arrays;

/**
 * Maximum subarray of size K.
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 */
public class SlideWindow1 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println(Arrays.toString(findAverageBRUTEFORCE(5, arr1)));
        System.out.println();
        System.out.println(Arrays.toString(findAverageSLIDINGWINDOW(5, arr1)));
    }

    private static double[] findAverageSLIDINGWINDOW(int K, int[] array) {
        double[] result = new double[array.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            windowSum += array[windowEnd]; // add the next element
            // slide the window, we don't need to slide
            // if we've not hit the required window size of 'K'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= array[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;
    }

    // Time Complexity: O(N*K); ‘N’ is the number of elements in the input array.
    private static double[] findAverageBRUTEFORCE(int K, int[] array) {
        double[] result = new double[array.length - K + 1];
        for (int i = 0; i <= array.length - K; i++) {
            double sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += array[j];
            }
            result[i] = sum / K;
        }
        return result;
    }
}
