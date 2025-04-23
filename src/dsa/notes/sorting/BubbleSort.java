package dsa.notes.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {5, 1, 4, 2, 8};
        System.out.println("Sorted Array: " + Arrays.toString(bubbleSort(intArray)));
        Integer[] intArray2 = {5, 1, 4, 2, 8};
        System.out.println("Sorted Integer Array: " + Arrays.toString(bubbleSortGeneric(intArray2)));

        String[] strArray = {"banana", "apple", "cherry", "date"};
        System.out.println("Sorted String Array: " + Arrays.toString(bubbleSortGeneric(strArray)));

        int[] intArray3 = {20, 35, -15, 7, 55, 1, -22};
        System.out.println("Sorted Array: " + Arrays.toString(bubbleSort2(intArray3)));

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

    public static int[] bubbleSort2(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int index = 0; index < lastUnsortedIndex; index++) {
                if (array[index] > array[index + 1]) {
                    swap(array, index, index + 1);
                }
            }
        }
        return array;
    }

    public static <T extends Comparable<T>> T[] bubbleSortGeneric(T[] array) {
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

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
