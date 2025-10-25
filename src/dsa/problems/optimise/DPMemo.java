package dsa.problems.optimise;


public class DPMemo {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    static int[] memo; // Our cache 🧠

    public static int fib(int n) {
        // Initialize the cache array. In Java, it defaults to all 0s.
        memo = new int[n + 1];
        return fibMemo(n);
    }

    private static int fibMemo(int n) {
        // 1. Base Case
        if (n < 2) {
            return n;
        }

        // 2. Check the cache: If we've seen this 'n' before, return the stored value.
        if (memo[n] != 0) {
            return memo[n];
        }

        // 3. Compute, store, and return if not in cache.
        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return memo[n];
    }
}


/*public class DPMemo {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        // Create a memoization table (array) and initialize with -1 (or any indicator for not computed)
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return fibMemo(n, memo);
    }

    private static int fibMemo(int n, int[] memo) {
        // Base cases
        if (n < 2) {
            return n;
        }

        // If the value is already computed, return it from the memo
        if (memo[n] != -1) {
            return memo[n];
        }

        // If not computed, compute it and store in memo before returning
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }
}*/
