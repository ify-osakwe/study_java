package dsa.problems.string;

/**
 * Longest Common Prefix
 * <a href="https://gemini.google.com/share/2d2b4ae1916b">Gemini Link</a>
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 2. Initialize the prefix with the first string.
        // We will assume this is the answer and prune it down as we compare with others.
        String prefix = strs[0];

        // 3. Iterate through the rest of the strings in the array.
        for (int i = 1; i < strs.length; i++) {

            // 4. While the current string (strs[i]) does not start with the prefix...
            // indexOf returns 0 if the prefix is found at the start.
            while (strs[i].indexOf(prefix) != 0) {

                // Shorten the prefix by removing the last character.
                prefix = prefix.substring(0, prefix.length() - 1);

                // Optimization: If prefix becomes empty, there is no common prefix.
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] input1 = {"flower", "flow", "flight"};
        System.out.println("Input: [\"flower\", \"flow\", \"flight\"]");
        System.out.println("Output: \"" + longestCommonPrefix(input1) + "\"");
        System.out.println();

        // Test Case 2
        String[] input2 = {"dog", "racecar", "car"};
        System.out.println("Input: [\"dog\", \"racecar\", \"car\"]");
        System.out.println("Output: \"" + longestCommonPrefix(input2) + "\"");
        System.out.println();

        // Test Case 3: Single string
        String[] input3 = {"single"};
        System.out.println("Input: [\"single\"]");
        System.out.println("Output: \"" + longestCommonPrefix(input3) + "\"");
        System.out.println();

        // Test Case 4: Identical strings
        String[] input4 = {"java", "java", "java"};
        System.out.println("Input: [\"java\", \"java\", \"java\"]");
        System.out.println("Output: \"" + longestCommonPrefix(input4) + "\"");
    }
}
