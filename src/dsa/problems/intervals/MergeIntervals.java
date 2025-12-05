package dsa.problems.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * <a href="https://gemini.google.com/share/e1ba0eb1a598">Gemini Link</a>
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // 1. Edge case handling
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 2. Sort the intervals by their start time (ascending).
        // If start times are equal, the order doesn't technically matter for this logic,
        // but sorting purely by start time is sufficient.
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 3. Create a list to hold the merged intervals.
        // We use a List because we don't know the final number of intervals yet.
        List<int[]> result = new ArrayList<>();

        // 4. Initialize with the first interval
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        // 5. Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                // OVERLAP DETECTED
                // We merge the two by updating the end time of the currentInterval.
                // We must take the max, because the next interval might end before
                // the current one (e.g., [1, 10] and [2, 3]).
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // NO OVERLAP
                // The next interval starts after the current one ends.
                // Move our pointer 'currentInterval' to this new interval
                // and add it to our result list.
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }

        // 6. Convert the List back to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        // Test Case 1: Standard overlap
        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.deepToString(input1));
        System.out.println("Output: " + Arrays.deepToString(merge(input1)));
        System.out.println();

        // Test Case 2: Touching intervals (should merge)
        int[][] input2 = {{1, 4}, {4, 5}};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.deepToString(input2));
        System.out.println("Output: " + Arrays.deepToString(merge(input2)));
        System.out.println();

        // Test Case 3: Unsorted input (should still work)
        int[][] input3 = {{4, 7}, {1, 4}};
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.deepToString(input3));
        System.out.println("Output: " + Arrays.deepToString(merge(input3)));
        System.out.println();

        // Test Case 4: Interval completely inside another
        int[][] input4 = {{1, 10}, {2, 5}};
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.deepToString(input4));
        System.out.println("Output: " + Arrays.deepToString(merge(input4)));
    }
}
