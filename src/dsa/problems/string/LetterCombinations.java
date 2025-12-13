package dsa.problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations from Digits
 * <a href="https://gemini.google.com/share/b736af69e0b8">Gemini Link</a>
 */
public class LetterCombinations {
    // Mapping of digits to letters as seen on a telephone keypad.
    // Index 0 and 1 are empty because keys 0 and 1 usually don't have letters.
    private static final String[] KEYPAD_MAPPING = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Edge case: empty input
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Start the backtracking process
        // We pass the input digits, current index (0),
        // a StringBuilder for constructing strings, and the result list.
        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base Case: If the current string length equals the input digits length,
        // we have formed a valid combination.
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the current digit character (e.g., '2')
        char digitChar = digits.charAt(index);

        // Convert char to integer index (e.g., '2' - '0' = 2)
        int mappingIndex = digitChar - '0';

        // Retrieve the letters corresponding to this digit (e.g., "abc")
        String letters = KEYPAD_MAPPING[mappingIndex];

        // Loop through each letter corresponding to the current digit
        for (char letter : letters.toCharArray()) {
            // 1. Choose: Append the letter to the current combination
            current.append(letter);

            // 2. Explore: Move to the next digit (index + 1)
            backtrack(digits, index + 1, current, result);

            // 3. Un-choose (Backtrack): Remove the last character to try the next letter in the loop
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: "23"
        String input1 = "23";
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Output: " + letterCombinations(input1));
        System.out.println();

        // Test Case 2: "2"
        String input2 = "2";
        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Output: " + letterCombinations(input2));
        System.out.println();

        // Test Case 3: "79" (Testing 4-letter keys)
        String input3 = "79";
        System.out.println("Input: \"" + input3 + "\"");
        System.out.println("Output: " + letterCombinations(input3));
        System.out.println();

        // Test Case 4: "" (Empty)
        String input4 = "";
        System.out.println("Input: \"" + input4 + "\"");
        System.out.println("Output: " + letterCombinations(input4));
    }
}
