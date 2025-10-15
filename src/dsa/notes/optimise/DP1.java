package dsa.notes.optimise;

/**
 * DP problem: House Robber.
 * You are a robber planning to rob houses along a street. Each house has a certain
 * amount of money. The only constraint is that you cannot rob two adjacent houses because
 * the security system will go off. Given a list of non-negative integers representing the
 * amount of money in each house, what is the maximum amount of money you can rob?
 * Example: If the houses have money [2, 7, 9, 3, 1].
 * The optimal solution is to rob houses with 2, 9, and 1 for a total of 2 + 9 + 1 = 12.
 */
public class DP1 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }


    public static int rob(int[] nums) {
        // 1. Handle edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 2. Create the DP table
        int[] dp = new int[nums.length];

        // 3. Initialize the table with our base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 4. Loop from the third house to the end
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        // 5. The final answer is the last entry in the table
        return dp[nums.length - 1];
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int robNext = 0; // Represents dp[i-1]
        int robNextPlusOne = 0; // Represents dp[i-2]

        // Loop through the houses
        for (int money : nums) {
            // The new 'robNext' is the max of robbing this house or skipping it
            int currentMax = Math.max(money + robNextPlusOne, robNext);

            // Update our variables for the next iteration
            robNextPlusOne = robNext;
            robNext = currentMax;
        }

        // The final answer is the last calculated max
        return robNext;
    }

}
