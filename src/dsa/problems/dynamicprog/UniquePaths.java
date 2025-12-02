package dsa.problems.dynamicprog;

/**
 * Unique Paths
 * <a href="https://gemini.google.com/share/805497594830">Gemini Link</a>
 */
public class UniquePaths {

    /**
     * The Step-by-Step Algorithm
     * <li>Create a 2D Array: Initialize an array dp[m][n] to store the number of paths to each cell.</li>
     * <li>Initialize First Row and Column: Set every cell in the first row (dp[0][x])
     * and first column (dp[x][0]) to 1.</li>
     * <li>Iterate: Loop through the rest of the grid starting from (1, 1).</li>
     * <li>Calculate: For every cell (i, j), apply the formula:
     * dp[i][j] = dp[i-1][j] + dp[i][j-1] </li>
     * <li>Return: The value in the bottom-right corner dp[m-1][n-1]. </li>
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // --- BASE CASE INITIALIZATION ---

        // Fill the first column with 1.
        // There is only one way to reach any cell in the first column:
        // moving straight down from the start.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill the first row with 1.
        // There is only one way to reach any cell in the first row:
        // moving straight right from the start.
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // --- FILLING THE DP TABLE ---

        // We start from [1][1] because [0][x] and [x][0] are already filled.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of ways to reach cell (i, j) is the sum of:
                // 1. The ways to reach the cell directly ABOVE it (i-1, j)
                // 2. The ways to reach the cell directly to the LEFT of it (i, j-1)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The result is stored in the bottom-right corner of the grid.
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // Test Case 1
        int m1 = 3;
        int n1 = 7;
        int result1 = uniquePaths(m1, n1);
        System.out.println("Test Case 1 (m=3, n=7): " + result1); // Expected: 28

        // Test Case 2
        int m2 = 3;
        int n2 = 2;
        int result2 = uniquePaths(m2, n2);
        System.out.println("Test Case 2 (m=3, n=2): " + result2); // Expected: 3

        // Test Case 3 (Square grid)
        int m3 = 3;
        int n3 = 3;
        int result3 = uniquePaths(m3, n3);
        System.out.println("Test Case 3 (m=3, n=3): " + result3); // Expected: 6
    }
}
