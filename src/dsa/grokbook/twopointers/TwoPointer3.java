package dsa.grokbook.twopointers;

/**
 * Given an unsorted array of numbers and a target ‘key’,
 * remove all instances of ‘key’ in-place and return the new length of the array.
 */
public class TwoPointer3 {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 3, 6, 3, 10, 9, 3}; // output : 4
        int key1 = 3;

        int[] arr2 = {2, 11, 2, 2, 1}; // output : 2
        int key2 = 2;

        System.out.println("Remove 'key', new length: " + removeDuplicates(arr1, key1));
        System.out.println("Remove 'key', new length: " + removeDuplicates(arr2, key2));
    }

    // time complexity is O(N); N is number of elements in the array
    // space complexity is O(1)
    private static int removeDuplicates(int[] array, int key) {
        // index of the next element which is not 'key'
        int nextElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != key) {
                array[nextElement] = array[i];
                nextElement++;
            }
        }
        return nextElement;
    }
}
