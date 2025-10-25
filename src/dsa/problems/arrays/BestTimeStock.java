package dsa.problems.arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximise your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * Constraints:
 * 1 <= prices.length <= 10^5
 * <p>
 * 0 <= prices[i] <= 10^4
 * <p>
 * Maximize Stock Profit Algorithm Explained
 * <a href="https://gemini.google.com/share/0b7009193033">Gemini Link</a>
 */
public class BestTimeStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        // 1. Initialize our two tracker variables
        int minBuyPrice = prices[0];
        int maxProfit = 0;

        // 2. Loop through the array starting from the second day
        for (int i = 1; i < prices.length; i++) {

            // 3. Check our logic
            if (prices[i] > minBuyPrice) {
                // Case 1: Today's price is higher. Check for a new max profit.
                // We found a potential profit AND Check if it's the new max profit.
                int potentialProfit = prices[i] - minBuyPrice;
                if (potentialProfit > maxProfit) {
                    maxProfit = potentialProfit;
                }
                // Math.max is just a shortcut for the if-statement you wrote.
                //maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
            } else {
                // Case 2: Today's price is lower. We found a new best day to buy.
                minBuyPrice = prices[i];
            }
        }

        // 4. Return the result
        return maxProfit;
    }


}
