package dsa.problems.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Step 1: Sort the intervals by their end time (ascending).
        // We use Integer.compare to prevent potential overflow issues (though unlikely with these constraints).
        // intervals[i][0] is start time, intervals[i][1] is end time.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        System.out.println("After sorting: " + Arrays.deepToString(intervals));

        // Step 2: Initialize variables
        // We "keep" the first interval (which ends the earliest due to sorting)
        int prevEnd = intervals[0][1];
        int removalCount = 0;

        // Step 3: Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart < prevEnd) {
                // CASE: OVERLAP
                // The current interval starts before the previous one ends.
                // Because we sorted by end time, the previous interval ends
                // earlier (or same time) than the current one.
                // To maximize space for future intervals, we keep the previous one
                // and discard the current one.
                removalCount++;
            } else {
                // CASE: NO OVERLAP
                // The current interval starts after (or exactly when) the previous one ends.
                // This is a valid non-overlapping interval. We keep it.
                // We update prevEnd to this new interval's end time.
                prevEnd = currentEnd;
            }
        }

        return removalCount;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Test Case 1:");
        printArray(intervals1);
        System.out.println("Result: " + eraseOverlapIntervals(intervals1)); // Expected: 1
        System.out.println();

        // Test Case 2
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Test Case 2:");
        printArray(intervals2);
        System.out.println("Result: " + eraseOverlapIntervals(intervals2)); // Expected: 2
        System.out.println();

        // Test Case 3
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println("Test Case 3:");
        printArray(intervals3);
        System.out.println("Result: " + eraseOverlapIntervals(intervals3)); // Expected: 0
        System.out.println();

        // Test Case 4: Complex overlap
        // [1,100] is a long interval. [2,3], [3,4], [4,5] are short ones inside it.
        // Sorting by end time ensures we pick [2,3], then [3,4], then [4,5] and drop [1,100].
        int[][] intervals4 = {{1, 100}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Test Case 4 (Long blocking interval):");
        printArray(intervals4);
        System.out.println("Result: " + eraseOverlapIntervals(intervals4)); // Expected: 1 (remove [1,100])
    }

    private static void printArray(int[][] arr) {
        System.out.print("Input: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i][0] + "," + arr[i][1] + "]");
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
