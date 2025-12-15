package dsa.problems.stack;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * <a href="https://gemini.google.com/share/180ba8e4cdb6">Gemini Link</a>
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String str) {
        // Initialize stack and push -1 as the initial base index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;

        for (int index = 0; index < str.length(); index++) {
            char character = str.charAt(index);

            if (character == '(') {
                // If open parenthesis, push its index onto the stack
                stack.push(index);
            } else {
                // If close parenthesis, pop the top index
                stack.pop();

                if (stack.isEmpty()) {
                    // If stack is empty, it means we have an unmatched closing parenthesis.
                    // This index becomes the new base marker for future valid strings.
                    stack.push(index);
                } else {
                    // If stack is not empty, we found a matching pair.
                    // The valid substring extends from the index after the *new* top
                    // of the stack up to current index index.
                    int currentLen = index - stack.peek();
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "(()";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Expected: 2");
        System.out.println("Result: " + longestValidParentheses(s1));
        System.out.println();

        // Test Case 2
        String s2 = ")()())";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Expected: 4");
        System.out.println("Result: " + longestValidParentheses(s2));
        System.out.println();

        // Test Case 3
        String s3 = "";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Expected: 0");
        System.out.println("Result: " + longestValidParentheses(s3));
        System.out.println();

        // Test Case 4 (Complex)
        String s4 = "()(()";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Expected: 2");
        System.out.println("Result: " + longestValidParentheses(s4));
    }
}
