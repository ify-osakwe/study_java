package playground.bcs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A3April2024 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking a question to the user
        System.out.print("What is your favorite programming language? ");
        String userAnswer = scanner.nextLine();

        // Storing the answer in a file
        try (FileWriter fileWriter = new FileWriter("user_answer.txt")) {
            fileWriter.write("User's favorite programming language: " + userAnswer);
            System.out.println("Answer has been saved to user_answer.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        scanner.close();
    }

}


