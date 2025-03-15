package dsa.notes.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // Example usage
        int[] arr = {29, 10, 14, 37, 13};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Partition method
    public static int partition(int[] array, int leftPointer, int rightPointer) {
        int pivotIndex = rightPointer;
        int pivot = array[pivotIndex];
        rightPointer -= 1;

        while (true) {
            // Move the left pointer to the right as long as the element is less than the pivot
            while (array[leftPointer] < pivot) {
                leftPointer++;
            }

            // Move the right pointer to the left as long as the element is greater than the pivot
            while (array[rightPointer] > pivot) {
                rightPointer--;
            }

            // If the pointers have crossed, break the loop
            if (leftPointer >= rightPointer) {
                break;
            } else {
                // Swap elements at the left and right pointers
                int temp = array[leftPointer];
                array[leftPointer] = array[rightPointer];
                array[rightPointer] = temp;
                leftPointer++;
            }
        }

        // Swap the pivot element with the element at the left pointer
        int temp = array[leftPointer];
        array[leftPointer] = array[pivotIndex];
        array[pivotIndex] = temp;

        // Return the pivot's final index
        return leftPointer;
    }

    // QuickSort method
    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        // Base case: if the section of the array has 0 or 1 element, it's already sorted
        if (rightIndex - leftIndex <= 0) {
            return;
        }

        // Partition the array and get the pivot index
        int pivotIndex = partition(array, leftIndex, rightIndex);

        // Recursively sort the left and right sub-arrays
        quickSort(array, leftIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, rightIndex);
    }

}

