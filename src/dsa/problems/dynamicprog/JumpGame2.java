package dsa.problems.dynamicprog;

/**
 * Jump Game II
 * <a href="https://gemini.google.com/share/a9c9f30bf8db">Gemini Link</a>
 */
public class JumpGame2 {
    public static int jump(int[] nums) {
        // Edge case: If the array has 1 element, we are already at the end.
        // 0 jumps are needed.
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0; // The end boundary of the current jump level
        int farthest = 0;   // The farthest index reachable from the current level

        // We iterate to nums.length - 1 because we don't need to jump FROM the last index.
        // We only need to reach it.
        for (int i = 0; i < nums.length - 1; i++) {

            // Update the farthest point reachable from index 'i'
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range
            if (i == currentEnd) {
                jumps++; // We must take a jump
                currentEnd = farthest; // Update the boundary for the next jump

                // Optimization: If the new boundary covers the last index, we can stop early.
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test Case 1: " + java.util.Arrays.toString(nums1));
        System.out.println("Expected: 2, Actual: " + jump(nums1));
        System.out.println("-----------------------------");

        // Test Case 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test Case 2: " + java.util.Arrays.toString(nums2));
        System.out.println("Expected: 2, Actual: " + jump(nums2));
        System.out.println("-----------------------------");

        // Edge Case: Array length 1
        int[] nums3 = {0};
        System.out.println("Test Case 3 (Single Element): " + java.util.Arrays.toString(nums3));
        System.out.println("Expected: 0, Actual: " + jump(nums3));
        System.out.println("-----------------------------");

        // Big Jump Case
        int[] nums4 = {5, 1, 1, 1, 1, 1};
        System.out.println("Test Case 4 (Big first jump): " + java.util.Arrays.toString(nums4));
        System.out.println("Expected: 1, Actual: " + jump(nums4));
    }
}
