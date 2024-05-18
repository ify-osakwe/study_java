package timBuchalka.codingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise41 {
    public static void main(String[] args) {
        int[] myArray = getIntegers(5);
        printArray(myArray);
        int[] sortedArray = sortIntegers(myArray);
        System.out.println("Sorted array in descending order:");
        printArray(sortedArray);
    }

    public static int[] getIntegers(int size) {
        System.out.println("Enter " + size + " integers:");
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
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
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        int[] descendingArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            descendingArray[i] = sortedArray[array.length - 1 - i];
        }
        return descendingArray;
    }
}
