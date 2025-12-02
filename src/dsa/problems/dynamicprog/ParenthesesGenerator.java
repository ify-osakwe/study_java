package dsa.problems.dynamicprog;

import java.util.ArrayList;
import java.util.List;

/**
 * Parentheses Generator
 * <a href="https://gemini.google.com/share/0cf028795d57">Gemini Link</a>
 */
public class ParenthesesGenerator {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // We start with an empty string, 0 open parentheses, and 0 closed parentheses.
        backtrack(result, "", 0, 0, n);

        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base Case:
        // If the current string is complete (length is 2 * n), add it to results.
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Decision 1: Can we add an open parenthesis?
        // We can only add '(' if we haven't used all n opening brackets yet.
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Decision 2: Can we add a close parenthesis?
        // We can only add ')' if we have more open brackets than closed ones.
        // This ensures we never create an unbalanced string like "())".
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {

        // Test Case 1: n = 3
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + generateParenthesis(n1));

        System.out.println("-----------------");

        // Test Case 2: n = 1
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + generateParenthesis(n2));

        System.out.println("-----------------");

        // Test Case 3: n = 2 (To visualize the example in the strategy guide)
        int n3 = 2;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + generateParenthesis(n3));
    }
}
