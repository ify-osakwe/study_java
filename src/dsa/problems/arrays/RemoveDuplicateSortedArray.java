package dsa.problems.arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates
 * in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * <p>
 * Consider the number of unique elements in nums to be k. After removing duplicates,
 * return the number of unique elements k. The first k elements of nums should contain the
 * unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 * <p>
 * Custom Judge:
 * The judge will test your solution with the following code:
 * </>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * </>
 * <p>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2,
 * nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums
 * being 1 and 2 respectively. It does not matter what you leave beyond the returned k
 * (hence they are underscores).
 * <p>
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5,
 * nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums
 * being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * <p>
 * -100 <= nums[i] <= 100
 * <p>
 * nums is sorted in non-decreasing order.
 * <p>
 * Remove Duplicates From Sorted Array
 * <a href="https://gemini.google.com/share/1cfdd456c380">Gemini Link</a>
 */
public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 1, 2};
        System.out.println("Original array: [1, 1, 2]");
        int k1 = removeDuplicates(nums1);
        System.out.println("Returned k: " + k1);
        printArray(nums1, k1);

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Original array: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]");
        int k2 = removeDuplicates(nums2);
        System.out.println("Returned k: " + k2);
        printArray(nums2, k2);

        // Example 3: All duplicates
        int[] nums3 = {5, 5, 5, 5};
        System.out.println("Original array: [5, 5, 5, 5]");
        int k3 = removeDuplicates(nums3);
        System.out.println("Returned k: " + k3);
        printArray(nums3, k3);

        // Example 4: No duplicates
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("Original array: [1, 2, 3, 4, 5]");
        int k4 = removeDuplicates(nums4);
        System.out.println("Returned k: " + k4);
        printArray(nums4, k4);

        // Example 5: Empty array
        int[] nums5 = {};
        System.out.println("Original array: []");
        int k5 = removeDuplicates(nums5);
        System.out.println("Returned k: " + k5);
        printArray(nums5, k5);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // Initialize the "write pointer" or "unique count" (k).
        // We start at 1 because the first element (at index 0) is always
        // unique and already in its correct place.
        // `k` will track the index where the *next* unique element should be written.
        int k = 1;

        for (int index = 1; index < nums.length; index++) {

            if (nums[index] != nums[index - 1]) {
                nums[k] = nums[index]; // We found a new unique element.
                k++;
            }
        }

        return k;
    }

    private static void printArray(int[] nums, int k) {
        System.out.print("Modified array: [");
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(nums[i] + (i == k - 1 ? "" : ", "));
            }
        }
        System.out.println("]");
        System.out.println("--------------------");
    }
}
