package dsa.problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Justification
 * <a href="https://gemini.google.com/share/5d5b4bf7d652">Gemini Link</a>
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            // Step 1: Determine which words fit on the current line
            int last = index + 1;
            int lineLength = words[index].length();

            // Try adding words until we exceed maxWidth
            // Condition: Current length + 1 space + next word length <= maxWidth
            while (last < n && (lineLength + 1 + words[last].length()) <= maxWidth) {
                lineLength += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numberOfWords = last - index;
            int diff = last - 1 - index; // Number of gaps between words

            // Step 2: Determine Justification Type

            // Case 1: Last line OR Single word line -> Left Justified
            if (last == n || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    // Add a space after each word, except the very last word in the line
                    if (i < last - 1) {
                        sb.append(" ");
                    }
                }
                // Pad the remainder with spaces to reach maxWidth
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            // Case 2: Fully Justified (Middle lines with multiple words)
            else {
                // Calculate total spaces available to distribute
                // Note: We recalculate raw char length without pre-assumed spaces
                int totalChars = 0;
                for (int i = index; i < last; i++) {
                    totalChars += words[i].length();
                }

                int totalSpaces = maxWidth - totalChars;
                int spacesPerGap = totalSpaces / diff;
                int extraSpaces = totalSpaces % diff; // Extra spaces to distribute from the left

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);

                    // Append spaces: base spaces + 1 if this gap gets an extra space
                    int spacesToAppend = spacesPerGap + (i - index < extraSpaces ? 1 : 0);
                    for (int k = 0; k < spacesToAppend; k++) {
                        sb.append(" ");
                    }
                }
                // Append the last word of the line (no spaces after it)
                sb.append(words[last - 1]);
            }

            result.add(sb.toString());
            index = last; // Move to the next set of words
        }

        return result;
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        TextJustification solution = new TextJustification();

        // Test Case 1
        System.out.println("--- Test Case 1 ---");
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int width1 = 16;
        printResult(solution.fullJustify(words1, width1));

        // Test Case 2
        System.out.println("\n--- Test Case 2 ---");
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int width2 = 16;
        printResult(solution.fullJustify(words2, width2));

        // Test Case 3
        System.out.println("\n--- Test Case 3 ---");
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int width3 = 20;
        printResult(solution.fullJustify(words3, width3));
    }

    private static void printResult(List<String> lines) {
        for (String line : lines) {
            // Start and end quotes to visualize spaces
            System.out.println("\"" + line + "\"");
        }
    }
}
