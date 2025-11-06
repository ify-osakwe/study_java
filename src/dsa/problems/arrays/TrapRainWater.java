package dsa.problems.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * <p>
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * Constraints:
 * n == height.length
 * <p>
 * 1 <= n <= 2 * 10^4
 * <p>
 * 0 <= height[i] <= 10^5
 * <p>
 * Trapping Rain Water Problem Explained
 * <a href="https://gemini.google.com/share/97c3de3b3d10">Gemini Link</a>
 */
public class TrapRainWater {
    public static void main(String[] args) {
        // Example 1 from the problem description
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result1 = trap(height1);
        System.out.println("Test Case 1:");
        System.out.println("Input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]");
        System.out.println("Expected Output: 6");
        System.out.println("Actual Output: " + result1);
        System.out.println("Test " + (result1 == 6 ? "PASSED" : "FAILED"));
        System.out.println("--------------------");

        // Example 2 from the problem description
        int[] height2 = {4, 2, 0, 3, 2, 5};
        int result2 = trap(height2);
        System.out.println("Test Case 2:");
        System.out.println("Input: [4, 2, 0, 3, 2, 5]");
        System.out.println("Expected Output: 9");
        System.out.println("Actual Output: " + result2);
        System.out.println("Test " + (result2 == 9 ? "PASSED" : "FAILED"));
        System.out.println("--------------------");

        // Additional test cases
        int[] height3 = {4, 2, 3};
        int result3 = trap(height3);
        System.out.println("Test Case 3:");
        System.out.println("Input: [4, 2, 3]");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + result3);
        System.out.println("Test " + (result3 == 1 ? "PASSED" : "FAILED"));
        System.out.println("--------------------");

        int[] height4 = {};
        int result4 = trap(height4);
        System.out.println("Test Case 4 (Empty):");
        System.out.println("Input: []");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + result4);
        System.out.println("Test " + (result4 == 0 ? "PASSED" : "FAILED"));
        System.out.println("--------------------");
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        // Initialize pointers at the far left and far right of the map.
        int left = 0;
        int right = height.length - 1;

        // Initialize variables to track the tallest wall seen from each side.
        int max_left = 0;
        int max_right = 0;

        // Initialize the total trapped water.
        int total_water = 0;

        // Loop until the two pointers meet.
        while (left < right) {

            // We compare the heights at the left and right pointers.
            // The logic proceeds based on the *shorter* of the two,
            // as it's the limiting factor for trapping water.

            // Case 1: The bar at `left` is shorter than or equal to the bar at `right`.
            if (height[left] <= height[right]) {

                // We process the `left` side.
                // Check if the current `left` bar is taller than the tallest left wall seen so far.
                if (height[left] > max_left) {
                    // If yes, it becomes the new `max_left` wall.
                    // A wall itself cannot trap water on top of it.
                    max_left = height[left];
                } else {
                    // If no, the current bar is shorter than the `max_left` wall.
                    // This means it's part of a "valley" and can trap water.
                    // The water trapped is the difference between the wall height and the bar height.
                    total_water += (max_left - height[left]);
                }

                // Move the left pointer one step to the right.
                left++;

            }
            // Case 2: The bar at `right` is shorter than the bar at `left`.
            else {

                // We process the `right` side (mirror image of the logic above).
                // Check if the current `right` bar is taller than the `max_right` wall.
                if (height[right] > max_right) {
                    // If yes, it becomes the new `max_right` wall.
                    max_right = height[right];
                } else {
                    // If no, this bar can trap water.
                    // The water trapped is the difference between the wall height and the bar height.
                    total_water += (max_right - height[right]);
                }

                // Move the right pointer one step to the left.
                right--;
            }
        }

        // After the loop finishes, we have summed all the trapped water.
        return total_water;
    }
}
