package playground;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AsteriskStripper {
    /*public static void main(String[] args) {
        String result = stripAsterisks(TextInput.input);
        System.out.println(result);  // Output: Hello World!
    }

    public static String stripAsterisks(String input) {
        if (input == null) return null;
        return input.replace("*", "");
    }*/

    public static void main(String[] args) {
        boolean hasStripped = stripAsterisksFromFile(TextInput.file1, TextInput.file2);
        if (hasStripped) {
            System.out.println("\nAsterisks removed and output written to " + TextInput.file2);
        } else {
            System.out.println("\nAn error occured");
        }
    }

    public static boolean stripAsterisksFromFile(String inputFileName, String outputFileName) {
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);

        try (Scanner scanner = new Scanner(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String modifiedLine = line.replace("*", "");
                writer.write(modifiedLine + System.lineSeparator());
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFileName);
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + outputFileName);
            return false;
        } catch (Exception e) {
            System.out.println("An undetected error has happened " + e);
            return false;
        }
    }

}

class TextInput {
    static String input = "";
    static String file1 =
            "/Users/ifeakachukwuosakwe/Projects/java/study_java/src/playground/asteriskinput.txt";
    static String file2 =
            "/Users/ifeakachukwuosakwe/Projects/java/study_java/src/playground/asteriskoutput.txt";

    private static final String pwd = "/Users/ifeakachukwuosakwe/Projects/java/study_java";
    static String dir = "/src/playground";
}
