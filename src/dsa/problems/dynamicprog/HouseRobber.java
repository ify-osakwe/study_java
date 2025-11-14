package dsa.problems.dynamicprog;

/**
 * Robbing Houses Dynamic Programming Solution
 * <a href="https://gemini.google.com/share/8cc2a56ff213">Gemini Link</a>
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 'rob2stepBack' represents the max money we could have robbed two houses ago (i-2).
        int rob2stepBack = 0;

        // 'rob1stepBack' represents the max money we could have robbed one house ago (i-1).
        int rob1stepBack = 0;

        for (int money : nums) {
            // At each house 'i', we have two choices:
            // 1. Rob this house (money): We add its value to the max we had two houses ago (rob2stepBack).
            //    We can't add to rob1stepBack, as that would be robbing adjacent houses.
            //    Total = money + rob2stepBack
            //
            // 2. Skip this house: The max money we have is just the max we had
            //    at the previous house (rob1stepBack).
            //
            // 'temp' will store the new maximum profit *at this current house*.
            int temp = Math.max(money + rob2stepBack, rob1stepBack);

            // Now, we update our variables for the next iteration.

            // The max profit from one house ago (rob1stepBack) now becomes
            // the max profit from two houses ago (rob2stepBack) for the *next* house.
            rob2stepBack = rob1stepBack;

            // The 'temp' value (max profit at the current house) becomes
            // the max profit from one house ago (rob1stepBack) for the *next* house.
            rob1stepBack = temp;
        }

        // After the loop finishes, rob1stepBack holds the maximum profit for the entire array.
        return rob1stepBack;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        int max1 = rob(nums1);
        System.out.println("Input: [1, 2, 3, 1]");
        System.out.println("Output: " + max1); // Expected: 4
        System.out.println("--------------------");

        // Example 2
        int[] nums2 = {2, 7, 9, 3, 1};
        int max2 = rob(nums2);
        System.out.println("Input: [2, 7, 9, 3, 1]");
        System.out.println("Output: " + max2); // Expected: 12
        System.out.println("--------------------");

        // Example 3: Only one house
        int[] nums3 = {100};
        int max3 = rob(nums3);
        System.out.println("Input: [100]");
        System.out.println("Output: " + max3); // Expected: 100
        System.out.println("--------------------");

        // Example 4: Two houses
        int[] nums4 = {2, 1};
        int max4 = rob(nums4);
        System.out.println("Input: [2, 1]");
        System.out.println("Output: " + max4); // Expected: 2
        System.out.println("--------------------");
    }
}
