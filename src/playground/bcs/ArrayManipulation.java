package playground.bcs;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        // Output the entire contents of the array using a for loop:
        int[] numbers = {-2, 5, -9, 7, -1, 4};
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        // Double each number in the array and save the resulting array as doubleNums:
        int[] doubleNums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            doubleNums[i] = numbers[i] * 2;
        }
        System.out.println("doubleNums: " + Arrays.toString(doubleNums));

        // Use a filter to generate a new array containing the positive numbers:
        int[] positiveNums = Arrays.stream(numbers)
                .filter(n -> n > 0)
                .toArray();
        System.out.println("positiveNums: " + Arrays.toString(positiveNums));

        // Instead of using a hard-coded array, use a for loop to ask the user for input:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");

        int size = scanner.nextInt();
        int[] userInputArray = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter a number: ");
            userInputArray[i] = scanner.nextInt();
        }
        System.out.println("userInputArray: " + Arrays.toString(userInputArray));
    }

}
