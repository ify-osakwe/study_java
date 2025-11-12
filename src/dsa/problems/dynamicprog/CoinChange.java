package dsa.problems.dynamicprog;

import java.util.Arrays;

/**
 * Coin Change Dynamic Programming Solution
 * <a href="https://gemini.google.com/share/1a8da9ea7b2d">Gemini Link</a>
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 4. Build the DP array from the bottom up.
        // We iterate through all amounts from 1 up to 'amount'.
        for (int index = 1; index <= amount; index++) {
            // For each amount 'index', we try every coin.
            for (int coin : coins) {
                // We can only use the coin if it's less than or equal to the
                // current amount 'index'.
                if (coin <= index) {
                    // This is the core of the algorithm.
                    // The minimum coins to make 'index' is the minimum of:
                    // 1. What we *already* have stored in dp[index]
                    // 2. Using this 'coin' (which costs 1 coin) + the
                    //    pre-calculated minimum coins for the remaining amount (dp[index - coin]).
                    dp[index] = Math.min(dp[index], 1 + dp[index - coin]);
                }
            }
        }

        // 5. Return the final answer.
        // If dp[amount] is still our sentinel value (amount + 1), it means
        // we never found a valid combination to make that amount.
        // Otherwise, dp[amount] holds our minimum.
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        // Example 1: coins = [1,2,5], amount = 11
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int output1 = coinChange(coins1, amount1);
        System.out.println("Example 1 Output: " + output1); // Expected: 3

        // Example 2: coins = [2], amount = 3
        int[] coins2 = {2};
        int amount2 = 3;
        int output2 = coinChange(coins2, amount2);
        System.out.println("Example 2 Output: " + output2); // Expected: -1

        // Example 3: coins = [1], amount = 0
        int[] coins3 = {1};
        int amount3 = 0;
        int output3 = coinChange(coins3, amount3);
        System.out.println("Example 3 Output: " + output3); // Expected: 0

        // Additional Test Case
        int[] coins4 = {1, 3, 4};
        int amount4 = 6;
        int output4 = coinChange(coins4, amount4);
        System.out.println("Example 4 Output: " + output4); // Expected: 2 (3 + 3)
    }
}
