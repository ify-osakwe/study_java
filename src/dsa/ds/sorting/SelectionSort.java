package dsa.ds.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array1 = {4, 3, 6, 1, 2, 7};
        System.out.println("Sorted: " + Arrays.toString(selectionSort(array1)));
        System.out.println("Sorted: " + Arrays.toString(selectionSort(array1)));

        String[] array2 = {"Chain", "China", "Chin", "Cheek", "Czechia"};
        System.out.println("Sorted: " + Arrays.toString(selectionSort(array2)));
    }

    public static int[] selectionSort(int[] array) {
        if (array.length == 1) return array;
        for (int i = 0; i < array.length - 1; i++) {
            int lowestNumIndex = i;
            // Find the smallest element in the unsorted portion of the array
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j] < array[lowestNumIndex]) {
                    lowestNumIndex = j;
                }
            }
            // Swap the smallest element with the element at index i
            if (lowestNumIndex != i) {
                // arr[i], arr[lowestNumIndex] = arr[lowestNumIndex], arr[i]
                int temp = array[i];
                array[i] = array[lowestNumIndex];
                array[lowestNumIndex] = temp;
            }
        }
        return array;
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
        if (array.length == 1) return array;
        for (int i = 0; i < array.length - 1; i++) {
            int lowestNumIndex = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j].compareTo(array[lowestNumIndex]) < 0) {
                    lowestNumIndex = j;
                }
            }
            if (lowestNumIndex != i) {
                T temp = array[i];
                array[i] = array[lowestNumIndex];
                array[lowestNumIndex] = temp;
            }
        }
        return array;
    }
}
