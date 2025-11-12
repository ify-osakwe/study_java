package dsa.problems.arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * <p>
 * nums2.length == n
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 1 <= m + n <= 2000
 * <p>
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * <p>
 * Median of Two Sorted Arrays Algorithm
 * <a href="https://gemini.google.com/share/c81efae6e43b">Gemini Link</a>
 */
public class MedianSortedArray {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] array1, int[] array2) {
        // Get lengths of both arrays
        int m = array1.length;
        int n = array2.length;

        // Ensure array1 is the smaller array.
        // We want to run the binary search on the smaller array for efficiency.
        if (m > n) {
            // If array1 is larger, swap the arrays and call the function again.
            return findMedianSortedArrays(array2, array1);
        }

        // Total length of the combined "merged" array
        int totalLength = m + n;
        // The size of the combined "left half" of the partitioned arrays.
        // The +1 handles both odd and even total lengths correctly.
        int halfLength = (totalLength + 1) / 2;

        // Binary search boundaries for partitioning the smaller array (array1)
        int low = 0;
        int high = m; // m is the length of array1

        while (low <= high) {
            // Calculate the partition point for array1
            // This 'partitionX' is the count of elements in the left half from array1
            int partitionX = (low + high) / 2;

            // Calculate the corresponding partition point for array2
            // 'partitionY' is the count of elements in the left half from array2
            int partitionY = halfLength - partitionX;

            // --- Determine the four "edge" elements ---
            // We use MIN_VALUE and MAX_VALUE to handle edge cases where
            // a partition is at the very beginning (0) or end (m or n) of an array.

            // maxLeftX: The largest element on the left side of the array1 partition
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : array1[partitionX - 1];
            // minRightX: The smallest element on the right side of the array1 partition
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : array1[partitionX];

            // maxLeftY: The largest element on the left side of the array2 partition
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : array2[partitionY - 1];
            // minRightY: The smallest element on the right side of the array2 partition
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : array2[partitionY];

            // --- Check if this is the correct partition ---
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have found the correct partition.
                // Now, we calculate the median based on the total length.

                if (totalLength % 2 == 0) {
                    // Even total length:
                    // The median is the average of the largest element in the combined left half
                    // and the smallest element in the combined right half.
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // Odd total length:
                    // The median is just the largest element in the combined left half.
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // Our partitionX is too large. The 'maxLeftX' is "spilling over" into
                // the right half of the combined array. We need to move the
                // array1 partition to the left.
                high = partitionX - 1;
            } else {
                // maxLeftY > minRightX
                // Our partitionX is too small. The 'maxLeftY' is "spilling over".
                // We need to move the array1 partition to the right to include
                // more (and larger) elements from array1 in the left half.
                low = partitionX + 1;
            }
        }

        // If the loop finishes without returning, the input arrays were not sorted.
        // Based on the problem constraints, this should not be reachable.
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
