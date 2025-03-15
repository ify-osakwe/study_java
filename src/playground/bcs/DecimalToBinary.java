package playground.bcs;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number (0 to 255): ");
        int decimalNumber = scanner.nextInt();

        // Call the function and print the binary representation
        String binary = convertToBinary(decimalNumber);
        String formattedBinary = String.format("%8s", binary).replace(' ', '0');

        System.out.println("The 8-bit binary equivalent is: " + formattedBinary);
    }


    public static String convertToBinary(int n) {
        int[] binaryArray = new int[8]; // Fixed size array for 8 binary digits

        // Use a for loop to perform division and store remainders
        for (int index = 0; index < 8; index++) {
            binaryArray[index] = n % 2; // Store remainder
            n = n / 2; // Integer division
        }

        // Build binary string by reading array in reverse
        StringBuilder binaryString = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            binaryString.append(binaryArray[i]);
        }

        return binaryString.toString();
    }

}
