package dsa.notes.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array1 = {4, 3, 6, 1, 2, 7, 9, 11, 8};
        System.out.println("Sorted: " + Arrays.toString(insertionSort(array1)));
        System.out.println("Sorted: " + Arrays.toString(insertionSort2(array1)));

        String[] array2 = {"Chain", "China", "Chin", "Cheek", "Czechia"};
        //System.out.println("Sorted: " + Arrays.toString(insertionSort(array2)));
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 1) return array;
        for (int i = 1; i < array.length; i++) {
            int tempValue = array[i];
            int position = i - 1;
            // Move elements of arr[0..index-1],
            // that are greater than tempValue, to one position ahead
            while (position >= 0) {
                if (array[position] > tempValue) {
                    array[position + 1] = array[position];
                    position -= 1;
                } else {
                    break;
                }
            }
            array[position + 1] = tempValue;
        }
        return array;
    }

    public static int[] insertionSort2(int[] array) {
        if (array.length == 1) return array;
        for (int i = 1; i < array.length; i++) {
            int tempValue = array[i];
            int position = i - 1;

            // Move elements of arr[0..index-1],
            // that are greater than tempValue, to one position ahead
            while (position >= 0 && array[position] > tempValue) {
                array[position + 1] = array[position];
                position--;
            }

            // Place tempValue at the correct position
            array[position + 1] = tempValue;
        }
        return array;
    }
}
