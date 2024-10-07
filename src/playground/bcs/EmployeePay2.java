package playground.bcs;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeePay2 {
    public static void main(String[] args) {
        int hoursWorked = getHoursWorked();

        if (!isValidHours(hoursWorked)) {
            System.out.println("Error: Invalid number of hours worked. Must be between 1 and 80.");
            return;
        }

        double wages = calculateWages(hoursWorked);
        printWages(wages);
        saveWagesToFile(wages);
    }

    // Step 1: Function to get hours worked
    public static int getHoursWorked() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hours worked this week: ");
        return scanner.nextInt();
    }

    // Step 2: Function to validate hours
    public static boolean isValidHours(int hours) {
        return hours > 0 && hours <= 80;
    }

    // Step 3: Function to calculate wages
    public static double calculateWages(int hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * 10.0;
        } else {
            return 40 * 10.0 + (hoursWorked - 40) * 15.0;
        }
    }

    // Step 4: Function to print wages
    public static void printWages(double wages) {
        System.out.println("Total wages: £" + wages);
    }

    // Step 5: Function to save wages to file
    public static void saveWagesToFile(double wages) {
        try (FileWriter fileWriter = new FileWriter("employee_wages.txt")) {
            fileWriter.write("Total wages: £" + wages);
            System.out.println("Wages saved to employee_wages.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

