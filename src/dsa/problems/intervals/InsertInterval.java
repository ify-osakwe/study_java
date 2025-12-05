package dsa.problems.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval
 * <a href="https://gemini.google.com/share/e52b79b250bf">Gemini Link</a>
 */
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int index = 0;
        int length = intervals.length;

        // PHASE 1: Add all intervals that come completely before the new interval.
        // While index < length AND intervals[index].end < newInterval.start
        // We know an interval comes before if its END time is less than the new Start time.
        while (index < length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }
        System.out.println("Result after Phase 1: " + Arrays.deepToString(result.toArray()));

        // PHASE 2: Merge overlapping intervals.
        // While index < length AND intervals[index].start <= newInterval.end:
        // We are in this phase while the current interval overlaps with the new interval.
        // Condition: The current interval starts BEFORE (or when) the new interval ends.
        while (index < length && intervals[index][0] <= newInterval[1]) {
            // We expand the newInterval to encompass the current one.
            // Start is the minimum of the two starts.
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            // End is the maximum of the two ends.
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);

            // Move to the next interval to see if it also needs merging
            index++;
        }

        // After merging is complete, add the (potentially expanded) newInterval.
        result.add(newInterval);
        System.out.println("Result after Phase 2: " + Arrays.deepToString(result.toArray()));

        // PHASE 3: Add the remaining intervals.
        // These are intervals that start after the new interval has ended.
        while (index < length) {
            result.add(intervals[index]);
            index++;
        }
        System.out.println("Result after Phase 3: " + Arrays.deepToString(result.toArray()));

        // Convert the List<int[]> back to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.deepToString(intervals1) + ", New: " + Arrays.toString(newInterval1));
        int[][] result1 = insert(intervals1, newInterval1);
        System.out.println("Output: " + Arrays.deepToString(result1));
        System.out.println();

        // Test Case 2 (Complex Merge)
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.deepToString(intervals2) + ", New: " + Arrays.toString(newInterval2));
        int[][] result2 = insert(intervals2, newInterval2);
        System.out.println("Output: " + Arrays.deepToString(result2));
        System.out.println();

        // Test Case 3 (New interval goes at the very beginning)
        int[][] intervals3 = {{5, 7}, {8, 10}};
        int[] newInterval3 = {1, 3};
        System.out.println("Test Case 3 (Insert at start):");
        System.out.println("Input: " + Arrays.deepToString(intervals3) + ", New: " + Arrays.toString(newInterval3));
        int[][] result3 = insert(intervals3, newInterval3);
        System.out.println("Output: " + Arrays.deepToString(result3));
    }

}
