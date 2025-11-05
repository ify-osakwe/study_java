package dsa.problems.arrays;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * <p>
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * <p>
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * <p>
 * 2 <= n <= 10^5
 * <p>
 * 0 <= height[i] <= 10^4
 * <p>
 * Two-Pointer Strategy for Container With Water
 * <a href="https://gemini.google.com/share/ae7a6683c9a6">Gemini Link</a>
 */
public class ContainerWithWater {
    public static void main(String[] args) {
        // Example 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int output1 = maxArea(height1);
        System.out.println("Input: [1,8,6,2,5,4,8,3,7]");
        System.out.println("Output: " + output1); // Expected: 49

        // Example 2
        int[] height2 = {1, 1};
        int output2 = maxArea(height2);
        System.out.println("\nInput: [1,1]");
        System.out.println("Output: " + output2); // Expected: 1
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        // Loop as long as the left pointer is to the left of the right pointer.
        while (left < right) {
            int width = right - left;

            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;

            // Update maxArea if the current container is larger.
            maxArea = Math.max(maxArea, currentArea);

            // If the line at the 'left' pointer is shorter than the 'right' one...
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
