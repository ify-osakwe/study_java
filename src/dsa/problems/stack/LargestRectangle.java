package dsa.problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Largest Rectangle in Histogram
 * <a href="https://gemini.google.com/share/9ede70b3c0df">Gemini Link</a>
 */
public class LargestRectangle {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // We use a Deque as a Stack to store indices.
        // The stack will maintain indices of bars in strictly increasing order of height.
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        // Iterate through all bars.
        // We go up to i = n (inclusive) to effectively handle the remaining bars
        // in the stack by treating the bar at index n as having height 0.
        for (int i = 0; i <= n; i++) {

            // If we are at the end (i == n), use height 0 to force pops.
            // Otherwise, use the current bar's height.
            int currentHeight = (i == n) ? 0 : heights[i];

            // While the stack is not empty and the current bar is shorter than
            // the bar at the top of the stack:
            // This means we found the RIGHT boundary for the bar at stack.peek().
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                // Get the height of the bar we are processing (the one at the top)
                int height = heights[stack.pop()];

                // Determine the width:
                // The right boundary is the current index 'i'.
                // The left boundary is the new top of the stack (after the pop).
                // If stack is empty, it means the popped bar was the smallest so far,
                // so it extends all the way to the left (width = i).
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Update max area
                maxArea = Math.max(maxArea, height * width);
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Example 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Test Case 1: " + java.util.Arrays.toString(heights1));
        System.out.println("Expected: 10");
        System.out.println("Result: " + largestRectangleArea(heights1));
        System.out.println();

        // Example 2
        int[] heights2 = {2, 4};
        System.out.println("Test Case 2: " + java.util.Arrays.toString(heights2));
        System.out.println("Expected: 4");
        System.out.println("Result: " + largestRectangleArea(heights2));
        System.out.println();

        // Edge Case: Ascending order
        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 3 (Ascending): " + java.util.Arrays.toString(heights3));
        System.out.println("Expected: 9"); // 3 * 3 = 9 (height 3, width 3) -> actually max is 9 (height 3 width 3? no. 4*2=8, 5*1=5, 3*3=9)
        System.out.println("Result: " + largestRectangleArea(heights3));
    }
}
