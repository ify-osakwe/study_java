package playground;

import java.util.Stack;

public class SearchingChallenge {
    public static void main(String[] args) {
        System.out.println(searchingChallenge("(coder)[byte)]")); // Output: "0"
        System.out.println(searchingChallenge("(c([od]er)) b(yt[e])")); // Output: "1 5"
        System.out.println(searchingChallenge("(hello [world])(!)")); // Output: "1 3"
        System.out.println(searchingChallenge("((hello [world])"));   // Output: "0"
        System.out.println(searchingChallenge("hello world"));        // Output: "1"
    }

    /*
     * write a function SearchingChallenge(str) in Java, it takes the str parameter
     * being passed and return 1 #ofBrackets if the brackets are correctly matched
     * and each one is accounted for. Otherwise return 0.
     *
     * For example: if str is - (hello [world])(!) - then the output should be - 1 3 -
     * because all the brackets are matched and there are 3 pairs of brackets,
     * but if str is - ((hello [world]) - the output should be - 0 -
     * because the brackets do not correctly match up.
     *
     * Only () and [] will be used as brackets. if str contains no brackets return 1.
     * the return type of SearchingChallenge(str) is String
     *
     * Example 1
     * input: (coder)[byte)]
     * output: 0
     *
     * Example 2
     * input: (c([od]er)) b(yt[e])
     * output: 1 5
     */
    public static String searchingChallenge(String str) {
        Stack<Character> stack = new Stack<>();
        int bracketPairs = 0;

        // Iterate through the string
        for (char bracket : str.toCharArray()) {
            // Check for opening brackets and push to stack
            // and Check for closing brackets
            if (bracket == '(' || bracket == '[') {
                stack.push(bracket);
            } else if (bracket == ')' || bracket == ']') {
                // If stack is empty, there is a mismatch
                if (stack.isEmpty()) return "0";

                // Check for matching bracket types
                char top = stack.pop();
                if ((bracket == ')' && top != '(') || (bracket == ']' && top != '[')) {
                    return "0";
                }
                // If brackets match, increment bracketPairs
                bracketPairs++;
            }
        }

        // If stack is not empty, there is an unmatched opening bracket
        if (!stack.isEmpty()) {
            return "0";
        }

        // Return the result based on the number of bracket pairs
        return bracketPairs > 0 ? "1 " + bracketPairs : "1";
    }
}
