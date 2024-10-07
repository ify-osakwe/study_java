package playground.bcs;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeePay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hours worked this week: ");
        int hoursWorked = scanner.nextInt();

        // Validate hours worked
        if (hoursWorked <= 0 || hoursWorked > 80) {
            System.out.println("Error: Invalid number of hours worked. Must be between 1 and 80.");
            return;
        }

        // Calculate wages
        double wages;
        if (hoursWorked <= 40) {
            wages = hoursWorked * 10.0;
        } else {
            wages = 40 * 10.0 + (hoursWorked - 40) * 15.0;
        }

        // Print wages
        System.out.println("Total wages: £" + wages);

        // Save wages to file
        try (FileWriter fileWriter = new FileWriter("employee_wages.txt")) {
            fileWriter.write("Total wages: £" + wages);
            System.out.println("Wages saved to employee_wages.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

