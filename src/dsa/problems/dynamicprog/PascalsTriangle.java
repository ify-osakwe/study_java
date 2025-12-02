package dsa.problems.dynamicprog;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 * <a href="https://gemini.google.com/share/f9f3d71882de">Gemini Link</a>
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }

        // 1. First Row is always just [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // 2. Loop to generate each subsequent row starting from row index 1
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // Rule 1: The first element is always 1
            currentRow.add(1);

            // Rule 2: The middle elements
            for (int j = 1; j < i; j++) {
                // Sum the two numbers directly above
                int sum = prevRow.get(j - 1) + prevRow.get(j);
                currentRow.add(sum);
            }

            // Rule 3: The last element is always 1
            currentRow.add(1);

            // Add the completed row to our triangle container
            triangle.add(currentRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        // Test Case 1: 5 Rows
        int n1 = 5;
        System.out.println("--- Generating " + n1 + " rows ---");
        List<List<Integer>> result1 = generate(n1);
        printTriangle(result1);

        System.out.println();

        // Test Case 2: 1 Row
        int n2 = 1;
        System.out.println("--- Generating " + n2 + " rows ---");
        List<List<Integer>> result2 = generate(n2);
        printTriangle(result2);
    }

    /**
     * Helper method to print the triangle in a readable format (List format)
     */
    private static void printTriangle(List<List<Integer>> triangle) {
        System.out.print("[");
        for (int i = 0; i < triangle.size(); i++) {
            System.out.print(triangle.get(i));
            if (i < triangle.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
