package dsa.problems.optimise;

public class DPTabulate {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        // Handle base cases
        if (n < 2) {
            return n;
        }

        // 1. Create the table 📊
        int[] dp = new int[n + 1];

        // 2. Initialize the first two values.
        dp[0] = 0;
        dp[1] = 1;

        // 3. Loop from 2 up to n, filling the table.
        for (int i = 2; i <= n; i++) {
            // Each new value is the sum of the previous two.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 4. The answer is the last entry in the table.
        return dp[n];
    }
}
