package dsa.problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Minimum Remove Parentheses
 * <a href="https://gemini.google.com/share/6e6831507d69">Gemini Link</a>
 */
public class MinimumRemoveParentheses {
    public static String minRemoveToMakeValid(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        // A boolean array to mark indices of characters to remove.
        // false = keep, true = remove
        boolean[] remove = new boolean[str.length()];

        // Stack to store indices of opening parentheses '('
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);

            if (character == '(') {
                // Store index of open parenthesis to check for future match
                stack.push(i);
            } else if (character == ')') {
                if (stack.isEmpty()) {
                    // Current ')' has no matching '(' seen before it.
                    // It is invalid and must be removed.
                    remove[i] = true;
                } else {
                    // We found a match for the most recent '('.
                    stack.pop();
                }
            }
        }

        // After the loop, the stack might contain indices of '(' that were never closed.
        // These are invalid and must be removed.
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Construct the final string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // Append only if the index is NOT marked for removal
            if (!remove[i]) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1
        String input1 = "lee(t(c)o)de)";
        String output1 = minRemoveToMakeValid(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: lee(t(c)o)de");
        System.out.println("-".repeat(20));

        // Test Case 2
        String input2 = "a)b(c)d";
        String output2 = minRemoveToMakeValid(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: ab(c)d");
        System.out.println("-".repeat(20));

        // Test Case 3
        String input3 = "))((";
        String output3 = minRemoveToMakeValid(input3);
        System.out.println("Input: " + input3);
        System.out.println("Output: \"" + output3 + "\"");
        System.out.println("Expected: \"\"");
        System.out.println("-".repeat(20));

        // Test Case 4: Complex Nested
        String input4 = "(a(b(c)d)";
        String output4 = minRemoveToMakeValid(input4);
        System.out.println("Input: " + input4);
        System.out.println("Output: " + output4);
        System.out.println("Expected: a(b(c)d) or (ab(c)d)");
    }
}
