package dsa.problems.string;

import java.util.Stack;

/**
 * Valid Parentheses
 * <a href="https://gemini.google.com/share/ff9901cad710">Gemini Link</a>
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false; // If length is odd, it is invalid
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing bracket, we need to check matches
            else {
                if (stack.isEmpty()) {
                    return false; // we have a closing bracket without an opener -> Invalid
                }

                char top = stack.pop();

                // Check for mismatched pairs
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // If stack is empty, all brackets were matched correctly.
        // If not empty, we have unmatched opening brackets left.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases from the prompt
        String[] testCases = {
                "()",       // Example 1: true
                "()[]{}",   // Example 2: true
                "(]",       // Example 3: false
                "([])",     // Example 4: true
                "([)]"      // Example 5: false
        };

        System.out.println("--- Valid Parentheses Test Results ---");

        for (String s : testCases) {
            boolean result = isValid(s);
            System.out.println("Input: \"" + s + "\" -> " + result);
        }

        // Additional edge case
        String oddLength = "(";
        System.out.println("Input: \"" + oddLength + "\" -> " + isValid(oddLength));
    }
}
