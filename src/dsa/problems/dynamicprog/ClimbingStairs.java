package dsa.problems.dynamicprog;

/**
 * Climbing Stairs: Dynamic Programming Solution
 * <a href="https://gemini.google.com/share/b6986e0042ba">Gemini Link</a>
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // We only need to store the last two results to calculate the next one.
        int twoStepsBack = 1; // Initialize to ways(1)
        int oneStepBack = 2; // Initialize to ways(2)

        for (int i = 3; i <= n; i++) {
            // Calculate the ways for the current step 'i'
            // ways(i) = ways(i-1) + ways(i-2)
            int currentWays = oneStepBack + twoStepsBack;

            // Update our pointers for the next iteration.
            // The previous 'oneStepBack' becomes the new 'twoStepsBack'
            twoStepsBack = oneStepBack;
            // The 'currentWays' becomes the new 'oneStepBack'
            oneStepBack = currentWays;
        }

        // Step 4: Return Result
        // After the loop finishes, 'oneStepBack' holds the value for ways(n).
        return oneStepBack;
    }

    public static void main(String[] args) {
        // Example 1: n = 2 // Expected: 2
        int n1 = 2;
        System.out.println("Ways to climb " + n1 + " steps: " + climbStairs(n1));

        // Example 2: n = 3 // Expected: 3
        int n2 = 3;
        System.out.println("Ways to climb " + n2 + " steps: " + climbStairs(n2));

        // Additional Test: n = 5 // Expected: 8
        // ways(4) = 3 + 2 = 5
        // ways(5) = 5 + 3 = 8
        int n3 = 5;
        System.out.println("Ways to climb " + n3 + " steps: " + climbStairs(n3));

        // Constraint Test: n = 45 // Expected: 1836311903
        int n4 = 45;
        System.out.println("Ways to climb " + n4 + " steps: " + climbStairs(n4));
    }
}
