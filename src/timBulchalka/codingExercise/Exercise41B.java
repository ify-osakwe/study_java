package timBulchalka.codingExercise;

import java.util.Scanner;

public class Exercise41B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers to sort: ");
        int numIntegers = scanner.nextInt();

        int[] integers = getIntegers(numIntegers);

        System.out.println("\nUnsorted array:");
        printArray(integers);

        int[] sortedIntegers = sortIntegers(integers);

        System.out.println("\nSorted array in descending order:");
        printArray(sortedIntegers);
    }

    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        // Create a copy of the array to preserve the original
        int[] sortedArray = array.clone();

        // Implement a descending bubble sort
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - i - 1; j++) {
                if (sortedArray[j] < sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }
}
