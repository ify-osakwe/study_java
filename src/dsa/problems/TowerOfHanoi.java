package dsa.problems;

public class TowerOfHanoi {

    // --- Let's run it for our 3-disk puzzle ---
    public static void main(String[] args) {
        System.out.println("Solving for 3 disks (A to C):");
        solveHanoi(3, "A", "C", "B");
    }

    /**
     * Solves the Tower of Hanoi puzzle recursively.
     *
     * @param n           The number of disks to move.
     * @param source      The name of the source peg.
     * @param destination The name of the destination peg.
     * @param auxiliary   The name of the auxiliary peg.
     */
    public static void solveHanoi(int n, String source, String destination, String auxiliary) {

        // 1. Base Case: If we only have 1 disk
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return; // We're done with this step
        }

        // 2. Recursive Step (for n > 1)

        // Phase 1: Move n-1 disks from source to auxiliary
        solveHanoi(n - 1, source, auxiliary, destination);

        // Phase 2: Move the nth (largest) disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Phase 3: Move the n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxiliary, destination, source);
    }
}
