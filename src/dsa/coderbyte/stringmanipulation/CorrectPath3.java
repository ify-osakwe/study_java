package dsa.coderbyte.stringmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// From ChatGPT
public class CorrectPath3 {

    private static final String[] POSSIBLE_MOVES_ARRAY = {"r", "l", "u", "d"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();

        int quotientMarkCount = countQuestionMarks(inputString);
        ArrayList<String> combinationArray = new ArrayList<>();

        if (quotientMarkCount == 1) {
            combinationArray.addAll(Arrays.asList(POSSIBLE_MOVES_ARRAY));
//            for (String move : POSSIBLE_MOVES_ARRAY) {
//                combinationArray.add(move);
//            }
        }

        // Generate all possible combinations of moves
        for (int i = 2; i <= quotientMarkCount; i++) {
            combinationArray = makeMovesCombination(i, combinationArray);
        }

        // Test each combination
        for (String combination : combinationArray) {
            String combinationString = buildCombinationString(inputString, combination);
            boolean isPathGood = makeArrayMovement(combinationString);
            if (isPathGood) {
                System.out.println(combinationString);
                break;
            }
        }
    }

    private static int countQuestionMarks(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '?') {
                count++;
            }
        }
        return count;
    }

    private static ArrayList<String> makeMovesCombination(int movesCount, ArrayList<String> movesArray) {
        ArrayList<String> combinationArrayCopy = new ArrayList<>();

        for (String move1 : POSSIBLE_MOVES_ARRAY) {
            for (String move2 : movesArray) {
                combinationArrayCopy.add(move1 + move2);
            }
        }

        return combinationArrayCopy;
    }

    private static String buildCombinationString(String inputString, String combination) {
        StringBuilder combinationString = new StringBuilder();
        int temp = 0;

        for (char c : inputString.toCharArray()) {
            if (c == '?') {
                combinationString.append(combination.charAt(temp));
                temp++;
            } else {
                combinationString.append(c);
            }
        }

        return combinationString.toString();
    }

    private static boolean makeArrayMovement(String combinationString) {
        int[][] array = new int[5][5];
        int row = 0;
        int column = 0;

        for (char move : combinationString.toCharArray()) {
            switch (move) {
                case 'r':
                    column++;
                    break;
                case 'd':
                    row++;
                    break;
                case 'l':
                    column--;
                    break;
                case 'u':
                    row--;
                    break;
            }

            // Check if the path goes out of grid
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

