package dsa.grokbook.twopointers;

import java.util.Arrays;

/**
 * Squaring a sorted array (easy).
 * Given a sorted array, create a new array containing squares of all
 * the number of the input array in the sorted order.
 */
public class TwoPointer4 {
    public static void main(String[] args) {
        int[] arr1 = {-2, -1, 0, 2, 3}; // output: [0, 1, 4, 4, 9]
        int[] arr2 = {-3, -1, 0, 1, 2}; // output : [0, 1, 1, 4, 9]

        System.out.println("make squares: " + Arrays.toString(makeSquares(arr1)));
        System.out.println("make squares: " + Arrays.toString(makeSquares(arr2)));
    }

    // time complexity is O(N)
    // space complexity is O(N)
    private static int[] makeSquares(int[] array) {
        int[] squares = new int[array.length];
        int highestSquareIdx = array.length - 1;
        int leftIdx = 0, rightIdx = array.length - 1;

        while (leftIdx <= rightIdx) {
            int leftSquare = array[leftIdx] * array[leftIdx];
            int rightSquare = array[rightIdx] * array[rightIdx];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                leftIdx++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                rightIdx--;
            }
        }
        return squares;
    }
}
