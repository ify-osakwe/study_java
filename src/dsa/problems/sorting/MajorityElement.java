package dsa.problems.sorting;

/**
 * Majority Element Algorithm
 * <a href="https://gemini.google.com/share/c8c5e6dd6e8a">Gemini Link</a>
 */
public class MajorityElement {

    public static int findMajorityElement(int[] nums) {
        // Phase 1: Find a candidate
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            // If the count is 0, we discard the previous candidate (if any)
            // and pick the current number as the new candidate.
            if (count == 0) {
                candidate = num;
            }

            // If the current number matches the candidate, it's a "vote" FOR it.
            if (num == candidate) {
                count++;
            }
            // If the current number is different, it cancels out one count of the candidate.
            else {
                count--;
            }
        }

        // Note: The problem guarantees a majority element exists.
        // If it were not guaranteed, we would need a Phase 2 here to loop
        // through the array again and verify the candidate appears > n/2 times.

        return candidate;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {3, 2, 3};
        int result1 = findMajorityElement(input1);
        System.out.println("Test Case 1: " + java.util.Arrays.toString(input1));
        System.out.println("Majority Element: " + result1); // Expected: 3
        System.out.println("-------------------------");

        // Test Case 2
        int[] input2 = {2, 2, 1, 1, 1, 2, 2};
        int result2 = findMajorityElement(input2);
        System.out.println("Test Case 2: " + java.util.Arrays.toString(input2));
        System.out.println("Majority Element: " + result2); // Expected: 2
        System.out.println("-------------------------");

        // Test Case 3 (Edge case: Single element)
        int[] input3 = {10};
        int result3 = findMajorityElement(input3);
        System.out.println("Test Case 3: " + java.util.Arrays.toString(input3));
        System.out.println("Majority Element: " + result3); // Expected: 10
    }
}
