package dsa.problems.dynamicprog;

/**
 * Jump Game
 * <a href="https://gemini.google.com/share/830394c8f3e9">Gemini Link</a>
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        // The furthest index we can currently reach.
        // Initially, we are at index 0, and we haven't jumped yet.
        int maxReach = 0;

        // Iterate through each position in the array
        for (int i = 0; i < nums.length; i++) {

            // CRITICAL STEP:
            // If the current index 'i' is greater than our 'maxReach',
            // it means this position is unreachable. We are stuck.
            if (i > maxReach) {
                return false;
            }

            // Calculate the furthest we can jump from the current position 'i'.
            // Current position + jump power = i + nums[i]
            // We take the max because we want to keep the best reach found so far.
            maxReach = Math.max(maxReach, i + nums[i]);

            // OPTIONAL OPTIMIZATION: stop early
            // If our maxReach has already passed or reached the last index,
            // we don't need to check the rest of the array.
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // If we finish the loop, it means we reached the end (or passed it).
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Reachable
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test Case 1: " + (canJump(nums1) ? "PASSED (true)" : "FAILED"));

        // Test Case 2: Unreachable (stuck at index 3)
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Test Case 2: " + (!canJump(nums2) ? "PASSED (false)" : "FAILED"));

        // Test Case 3: Single element (Always true, start is end)
        int[] nums3 = {0};
        System.out.println("Test Case 3: " + (canJump(nums3) ? "PASSED (true)" : "FAILED"));

        // Test Case 4: Zero at start with length > 1 (Immediate fail)
        int[] nums4 = {0, 2, 3};
        System.out.println("Test Case 4: " + (!canJump(nums4) ? "PASSED (false)" : "FAILED"));
    }
}
