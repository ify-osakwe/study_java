package playground.bcs;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        int[] array = new int[MAX_SIZE];
        int arraySize;

        String input;
        boolean found;

        Scanner scanner = new Scanner(System.in);

        // Step 1: Initialize the game
        System.out.print("Enter the number of elements in the array: ");
        arraySize = scanner.nextInt();

        // Step 2: Input the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Step 3: Main game loop
        while (true) {
            System.out.print("Enter a number to check if it's in the array (or 'q' to quit): ");
            input = scanner.next();

            // Step 4: Check if the user wants to quit
            if (input.equals("q")) {
                break;  // Exit the loop
            }

            // Step 5: Convert input to a number
            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'q' to quit.");
                continue;
            }

            // Step 6: Check if the number is in the array
            found = false;
            for (int i = 0; i < arraySize; i++) {
                if (array[i] == number) {
                    found = true;
                    break;  // Exit the loop as number is found
                }
            }

            // Step 7: Provide feedback to the user
            if (found) {
                System.out.println("The number " + number + " is in the array!");
            } else {
                System.out.println("The number " + number + " is not in the array.");
            }
        }

        // Step 8: Exit message
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}

