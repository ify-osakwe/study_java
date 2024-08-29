package dsa.notes.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {5, 1, 4, 2, 8};
        System.out.println("Sorted Array: " + Arrays.toString(bubbleSort(intArray)));

        Integer[] intArray2 = {5, 1, 4, 2, 8};
        System.out.println("Sorted Integer Array: " + Arrays.toString(bubbleSort(intArray2)));

        String[] strArray = {"banana", "apple", "cherry", "date"};
        System.out.println("Sorted String Array: " + Arrays.toString(bubbleSort(strArray)));
    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int lastIndex = array.length - 1;
        boolean sorted = false;
        //
        while (!sorted) {
            sorted = true;
            for (int index = 0; index < lastIndex; index++) {
                if (array[index] > array[index + 1]) {
                    // arr[index], arr[index + 1] = arr[index + 1], arr[index]
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    sorted = false;
                }
            }
            lastIndex--;
        }
        return array;
    }

    public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
        if (array.length == 1) {
            return array;
        }
        int lastIndex = array.length - 1;
        boolean sorted = false;
        //
        while (!sorted) {
            sorted = true;
            for (int index = 0; index < lastIndex; index++) {
                if (array[index].compareTo(array[index + 1]) > 0) {
                    T temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    sorted = false;
                }
            }
            lastIndex--;
        }
        return array;
    }
}
