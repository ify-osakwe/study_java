package timBuchalka.codingExercise;

import java.util.Scanner;

public class Exercise42 {
    public static void main(String[] args) {
        int count = readInteger();
        int[] array = readElements(count);
        int min = findMin(array);
        System.out.println("Minimum element in the array: " + min);
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        return scanner.nextInt();
    }

    private static int[] readElements(int count) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[count];
        System.out.println("Enter " + count + " elements:");
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
