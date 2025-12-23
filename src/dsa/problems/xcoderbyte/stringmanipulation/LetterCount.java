package dsa.problems.xcoderbyte.stringmanipulation;

import java.util.HashMap;

/*
 *             CODERBYTE LETTER COUNT ONE CHALLENGE             *
 *                                                              *
 * Problem Statement                                            *
 * Have the function LetterCountI(str) take the str parameter   *
 * being passed and return the first word with the greatest     *
 * number of repeated letters.                                  *
 * For example: "Today, is the greatest day ever!"              *
 * should return greatest because it has 2 e's (and 2 t's) & it *
 * comes before ever which also has 2 e's. If there are no      *
 * words with repeating letters return -1. Words will be        *
 * separated by spaces.                                         *
 *                                                              *
 * Examples                                                     *
 * Input 1: Hello apple pie                                     *
 * Output 1: Hello                                              *
 *                                                              *
 * Input 2: No words                                            *
 * Output 2: -1                                                 *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 39.2% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class LetterCount {

    public static void main(String[] args) {
        System.out.println(letterCountI("Hello apple pie"));  // Output: Hello
        System.out.println(letterCountI("No words"));         // Output: -1
        System.out.println(letterCountI("Today, is the greatest day ever!"));  // Output: greatest
    }

    public static String letterCountI(String str) {
        // Split the string into words
        String[] words = str.split(" ");

        // Default result if no word has repeating letters
        String result = "-1";

        // Track the maximum number of repeated letters
        int maxRepeats = 0;

        // Loop through each word
        for (String word : words) {
            // Get the maximum repeated letter count for the current word
            int repeatCount = getMaxRepeatingLetterCount(word);

            // If the current word has more repeats than the previous max, update result
            if (repeatCount > maxRepeats) {
                maxRepeats = repeatCount;
                result = word;
            }
        }

        return result;
    }

    // Helper function to find the maximum number of repeating letters in a word
    private static int getMaxRepeatingLetterCount(String word) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        int maxCount = 0;

        // Count occurrences of each letter in the word
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
                maxCount = Math.max(maxCount, letterCount.get(c));
            }
        }

        // Return the highest occurrence count
        return maxCount > 1 ? maxCount : 0;  // Only return if there are repeated letters
    }
}
