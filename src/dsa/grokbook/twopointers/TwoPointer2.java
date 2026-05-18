package dsa.grokbook.twopointers;

/**
 * Remove Duplicates (easy).
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place
 * return the new length of the array.
 */
public class TwoPointer2 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 3, 3, 6, 9, 9}; // output = 4
        int[] arr2 = {2, 2, 2, 11}; // output = 2

        System.out.println("Remove duplicates, new length: " + removeDuplicates(arr1));
        System.out.println("Remove duplicates, new length: " + removeDuplicates(arr2));
    }

    // time complexity is O(N)
    // space complexity is O(1)
    private static int removeDuplicates(int[] array) {
        // index of the next non-duplicate element
        int nextNonDuplicate = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[nextNonDuplicate - 1] != array[i]) {
                array[nextNonDuplicate] = array[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
}
