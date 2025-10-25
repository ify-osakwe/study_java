package dsa.ds.searching;

/**
 * Implementation of binary search in an ordered array/list
 * Time complexity is O(logN).
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] collection = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(collection, 5));  // Output: 2
        System.out.println(binarySearch(collection, 8)); // Output: 0

        Integer[] intCollection = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(intCollection, 5));  // Output: 2
        System.out.println(binarySearch(intCollection, 8));  // Output: 0

        String[] stringCollection = {"apple", "banana", "cherry", "date"};
        System.out.println(binarySearch(stringCollection, "cherry"));  // Output: 2
        System.out.println(binarySearch(stringCollection, "grape"));   // Output: 0
    }

    public static int binarySearch(int[] array, int value) {
        int lowerBound = 0;
        int upperBound = array.length - 1;
        //
        while (lowerBound <= upperBound) {
            int midPoint = (upperBound + lowerBound) / 2;
            int valueAtMidPoint = array[midPoint];
            //
            if (value == valueAtMidPoint) {
                return midPoint;
            } else if (value < valueAtMidPoint) {
                upperBound = midPoint - 1;
            } else {
                lowerBound = midPoint + 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, T value) {
        int lowerBound = 0;
        int upperBound = array.length - 1;
        //
        while (lowerBound <= upperBound) {
            int midPoint = (upperBound + lowerBound) / 2;
            T valueAtMidPoint = array[midPoint];
            //
            if (value.compareTo(valueAtMidPoint) == 0) {
                return midPoint;
            } else if (value.compareTo(valueAtMidPoint) < 0) {
                upperBound = midPoint - 1;
            } else {
                lowerBound = midPoint + 1;
            }
        }
        return -1;
    }
}