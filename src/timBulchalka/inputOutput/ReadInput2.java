package timBulchalka.inputOutput;

import java.util.Scanner;

public class ReadInput2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 1;
        double sum = 0;

        while (counter <= 5) {
            System.out.println("Enter a number #" + counter + ":");
            String nextNumber = scanner.nextLine();
            try {
                double number = Double.parseDouble(nextNumber);
                counter++;
                sum += number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }

        System.out.println("The sum of the 5 numbers = " + sum);
    }
}
