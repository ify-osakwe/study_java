package dsa.notes.optimise;

// Longest Common Subsequence
public class DpLCS {
    public static void main(String[] args) {
        String s1 = "stone";
        String s2 = "longest";

        String result = findLCS(s1, s2);
        System.out.println("S1: " + s1);
        System.out.println("S2: " + s2);
        System.out.println("The Longest Common Subsequence is: " + result);
    }

    public static String findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // This 2D array is the table we built manually.
        // dp[i][j] will store the length of the LCS of s1[0...i-1] and s2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        // --- Part 1: Fill the DP table (same as our manual process) ---
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, add 1 to the diagonal result.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // If they don't match, take the max from the top or left cell.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Print Array
        print2Darray(dp);

        // The length of the LCS is in the bottom-right corner.
        int lcsLength = dp[m][n];
        System.out.println("Length of LCS: " + lcsLength);

        // --- Part 2: Backtrack to reconstruct the LCS string ---
        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            // If characters match, it's part of the LCS.
            // Move diagonally up and left.
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            // If characters don't match, move to the cell with the larger value.
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // Move up
            } else {
                j--; // Move left
            }
        }

        // The backtracking builds the string backward, so we reverse it at the end.
        return lcs.reverse().toString();
    }

    private static void print2Darray(int[][] matrix) {
        for (int[] row : matrix) {
            // Loop through each element in the row
            for (int element : row) {
                System.out.print(element + " ");
            }
            // Print a new line after each row is printed
            System.out.println();
        }
    }
}
