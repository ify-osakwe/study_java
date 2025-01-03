package playground;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;

public class CheckDuplicateInCSV {

    public static void main(String[] args) {
        String csvFile = "/Users/ifeakachukwuosakwe/Downloads/oworonumbers.csv"; // Change this to the path of your CSV file
        String line;
        String csvSplitBy = ",";

        HashSet<String> phoneNumbers = new HashSet<>();
        HashMap<String, Integer> duplicateCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);
                if (columns.length < 2) continue; // Skip if the line doesn't have enough columns

                String phoneNumber = columns[1].trim();

                if (!phoneNumbers.add(phoneNumber)) {
                    duplicateCount.put(phoneNumber, duplicateCount.getOrDefault(phoneNumber, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (duplicateCount.isEmpty()) {
            System.out.println("No duplicate phone numbers found.");
        } else {
            System.out.println("Duplicate phone numbers found:");
            for (String phoneNumber : duplicateCount.keySet()) {
                System.out.println(phoneNumber + " (appeared " + (duplicateCount.get(phoneNumber) + 1) + " times)");
            }
        }
    }
}

