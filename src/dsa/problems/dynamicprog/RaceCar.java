package dsa.problems.dynamicprog;

/**
 * Race Car
 * <a href="https://gemini.google.com/share/6df511d52a02">Gemini Link</a>
 */
public class RaceCar {
    public static int racecar(int target) {
        // dp[i] will store the minimum steps to reach position i starting from 0
        int[] dp = new int[target + 1];

        // Loop through every target from 1 up to the actual requested target
        for (int i = 1; i <= target; i++) {

            // 1. Find the number of 'A's (k) needed to reach or pass i.
            // Mathematical equivalent: Find k where 2^(k-1) <= i < 2^k
            int k = 0;
            long forwardDistance = 0;

            // (1 << k) is bitwise for 2^k
            while (forwardDistance < i) {
                k++;
                forwardDistance = (1L << k) - 1;
            }

            // CASE 1: Exact Match
            // We land exactly on 'i' using k accelerations.
            if (forwardDistance == i) {
                dp[i] = k;
                continue;
            }

            // CASE 2: Overshoot
            // We went k steps forward, passed i, and reached (2^k - 1).
            // Logic: k steps (A) + 1 step (R) + steps to cover the remaining distance back to i.
            // Remaining distance = forwardDistance - i
            long overshootDist = forwardDistance - i;
            dp[i] = k + 1 + dp[(int) overshootDist];

            // CASE 3: Undershoot
            // We go (k-1) steps forward, stop before i.
            // Then we reverse (R), go back j steps, reverse again (R).
            // Then we solve for the gap remaining.
            // Position after sequence: (2^(k-1) - 1) - (2^j - 1)

            // We try all possible amounts of "backing up" (j)
            for (int j = 0; j < k - 1; j++) {
                long distanceReachedForward = (1L << (k - 1)) - 1;
                long distanceReachedBackward = (1L << j) - 1;

                // Current net position after (A...A) R (A...A) R
                long currentPos = distanceReachedForward - distanceReachedBackward;

                // Steps taken so far:
                // (k-1) forward 'A's
                // + 1 'R'
                // + j backward 'A's
                // + 1 'R'
                int stepsSoFar = (k - 1) + 1 + j + 1;

                int remainingDist = i - (int) currentPos;

                // Update dp[i] with the minimum found
                dp[i] = Math.min(dp[i], stepsSoFar + dp[remainingDist]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        // Test Case 1
        int target1 = 3;
        System.out.println("Target: " + target1);
        System.out.println("Result: " + racecar(target1));
        System.out.println("Expected: 2 (AA)");
        System.out.println("-------------------");

        // Test Case 2
        int target2 = 6;
        System.out.println("Target: " + target2);
        System.out.println("Result: " + racecar(target2));
        System.out.println("Expected: 5 (AAARA)");
        System.out.println("-------------------");

        // Test Case 3 (Larger number)
        int target3 = 54;
        System.out.println("Target: " + target3);
        /*
         * Logic check for 54:
         * Closest powers: 31 (2^5 - 1) and 63 (2^6 - 1).
         * Overshoot strategy: Go to 63 (AAAAAA = 6 steps), Reverse (1), Go back 9 (dp[9]).
         * 9 is 15 - 6 (AAAA R AA).
         */
        System.out.println("Result: " + racecar(target3));
        System.out.println("-------------------");
    }
}
