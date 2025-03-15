package dsa.coderbyte.stringmanipulation;

import java.util.*;

// From Claude
public class CorrectPath2 {
    private static final String[] possibleMovesArray = {"r", "l", "u", "d"};
    private static List<String> combinationArray = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int quotientMarkCount = 0;

        // Count quotient marks
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '?') {
                quotientMarkCount++;
            }
        }

        // Initialize combinationArray if quotientMarkCount is 1
        if (quotientMarkCount == 1) {
            combinationArray = Arrays.asList(possibleMovesArray);
        }

        // Construct moves array recursively
        for (int i = 2; i <= quotientMarkCount; i++) {
            if (combinationArray.isEmpty()) {
                combinationArray = makeMovesCombination(i, Arrays.asList(possibleMovesArray));
            } else {
                combinationArray = makeMovesCombination(i, combinationArray);
            }
        }

        // Try each combination
        for (String combination : combinationArray) {
            StringBuilder combinationString = new StringBuilder();
            int temp = 0;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == '?') {
                    combinationString.append(combination.charAt(temp++));
                } else {
                    combinationString.append(string.charAt(j));
                }
            }
            if (makeArrayMovement(combinationString.toString())) {
                System.out.println(combinationString);
                break;
            }
        }
    }

    private static List<String> makeMovesCombination(int movesCount, List<String> movesArray) {
        List<String> combinationArrayCopy = new ArrayList<>();
        for (String possibleMove : possibleMovesArray) {
            for (String move : movesArray) {
                combinationArrayCopy.add(possibleMove + move);
            }
        }
        return combinationArrayCopy;
    }

    private static boolean makeArrayMovement(String combinationString) {
        int[][] array = new int[5][5];
        int row = 0, column = 0;

        for (int i = 0; i < combinationString.length(); i++) {
            char move = combinationString.charAt(i);
            switch (move) {
                case 'r': column++; break;
                case 'd': row++; break;
                case 'l': column--; break;
                case 'u': row--; break;
            }

            // Check if path goes out of grid
            if (row < 0 || column < 0 || row > 4 || column > 4) {
                return false;
            }

            // Check if the path is already traversed
            if (array[row][column] == 1) {
                return false;
            }

            array[row][column] = 1;
        }

        return row == 4 && column == 4;
    }
}
