package dsa.ds.sorting;

public class MergeSortExample {

    // The recursive function that divides the array and calls merge()
    void sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Find the middle point to divide the array into two halves
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // Recursive calls to sort the two halves
            sort(array, leftIndex, midIndex);
            sort(array, midIndex + 1, rightIndex);

            // Merge the sorted halves
            merge(array, leftIndex, midIndex, rightIndex);
        }
    }

    // The helper function that merges two sorted subarrays
    void merge(int[] arr, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, left, L, 0, n1);
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[middle + 1 + j];
        }

        // Copy data to temp arrays
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[left + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[middle + 1 + j];

        // Merge the temp arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // A utility function to print an array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // The main method that drives the program
    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 1};

        System.out.println("Given Array:");
        printArray(arr);

        MergeSortExample ob = new MergeSortExample();
        ob.sort(arr, 0, arr.length - 1); // Initial call to start the sort

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}