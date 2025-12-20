package dsa.problems.binarybit;

/**
 * Missing Numbers
 * <a href="https://gemini.google.com/share/e6d583cb4801">Gemini Link</a>
 */
public class MissingNumber {
    private static int findMissingNumber(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate expected sum of numbers 0 to n
        // Note: Using n * (n + 1) / 2
        int expectedSum = n * (n + 1) / 2;

        // Step 2: Calculate the actual sum of elements in the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Step 3: The difference is the missing number
        return expectedSum - actualSum;
    }

    private static int findMissingNumberXor(int[] nums) {
        int xorAll = 0;

        // XOR all numbers in range [0, n]
        // Note: We include 'n' specifically because the loop for indices
        // usually goes to n-1.
        for (int i = 0; i <= nums.length; i++) {
            xorAll ^= i;
        }

        // XOR with all values in the array
        for (int num : nums) {
            xorAll ^= num;
        }

        return xorAll;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 0, 1};
        System.out.println("Test Case 1:");
        System.out.println("Input: [3, 0, 1]");
        System.out.println("Expected: 2");
        System.out.println("Calculated: " + findMissingNumber(nums1));
        System.out.println("Calculated: " + findMissingNumberXor(nums1));
        System.out.println("-------------------------");

        // Test Case 2
        int[] nums2 = {0, 1};
        System.out.println("Test Case 2:");
        System.out.println("Input: [0, 1]");
        System.out.println("Expected: 2");
        System.out.println("Calculated: " + findMissingNumber(nums2));
        System.out.println("Calculated: " + findMissingNumberXor(nums1));
        System.out.println("-------------------------");

        // Test Case 3
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Test Case 3:");
        System.out.println("Input: [9, 6, 4, 2, 3, 5, 7, 0, 1]");
        System.out.println("Expected: 8");
        System.out.println("Calculated: " + findMissingNumber(nums3));
        System.out.println("Calculated: " + findMissingNumberXor(nums1));
        System.out.println("-------------------------");
    }
}
