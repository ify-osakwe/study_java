package timBuchalka.inputOutput;

import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        int currentYear = 2024;
        //String usersDateOfBirth = "1999";

        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(currentYear));
        }

    }

    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, What's your name? ");
        System.out.println("Hi " + name + ", Thanks for taking the course");

        String dob = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dob);

        return "So you are " + age + " years old";
    }

    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Hi " + name + ", Thanks for taking the course");
        System.out.println("What year were you born? ");

        boolean validDob = false;
        int age = 0;
        do {
            System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <= " + (currentYear));
            try {
                age = checkData(currentYear, scanner.nextLine());
                validDob = age >= 0;
            } catch (NumberFormatException badUserData) {
                System.out.println("Characters not allowed!!! Try again");
            }
        } while (!validDob);

        return "So you are " + age + " years old";
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minYear = currentYear - 125;
        if ((dob < minYear) || (dob > currentYear)) {
            return -1;
        }
        return (currentYear - dob);
    }
}
