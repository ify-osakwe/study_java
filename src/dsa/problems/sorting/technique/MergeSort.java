package dsa.problems.sorting.technique;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(array, 0, array.length);

        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (endIndex - startIndex < 2) {
            return;
        }
        int midIndex = (startIndex + endIndex) / 2;
        mergeSort(array, startIndex, midIndex);
        mergeSort(array, midIndex, endIndex);
        merge(array, startIndex, midIndex, endIndex);
    }

    public static void merge(int[] array, int startIndex, int midIndex, int endIndex) {
        if (array[midIndex - 1] <= array[midIndex]) {
            return;
        }
        int i = startIndex, j = midIndex, tempIndex = 0;
        int[] tempArray = new int[endIndex - startIndex];

        while (i < midIndex && j < endIndex) {
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        // Copy remaining elements from left side
        System.arraycopy(array, i, array, startIndex + tempIndex, midIndex - i);
        // Copy merged elements back into original array
        System.arraycopy(tempArray, 0, array, startIndex, tempIndex);
    }
}
