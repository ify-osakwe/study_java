package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *           CODERBYTE LONGEST WORD CHALLENGE                   *
 *                                                              *
 * Problem Statement                                            *
 * Have the function LongestWord(sen) take the sen parameter    *
 * being passed and return the longest word in the string.      *
 * If there are two or more words that are the same length,     *
 * return the first word from the string with that length.      *
 * Ignore punctuation and assume sen will not be empty.         *
 *                                                              *
 * Examples                                                     *
 * Input 1: "fun&!! time"                                       *
 * Output 1: time                                               *
 *                                                              *
 * Input 2: "I love dogs"                                       *
 * Output 2: love                                               *
 *                                                              *
 * Solution Efficiency                                          *
 * This user scored higher than 63.3% of users who solved this  *
 * challenge.                                                   *
 ***************************************************************/
public class LongestWord {
    public static void main(String[] args) {
        System.out.println(longestWord("fun&!! time"));  // Output: time
        System.out.println(longestWord("I love dogs"));  // Output: love
        System.out.println(longestWord("John is a bull"));
    }


    public static String longestWord(String sen) {
        // Remove all non-alphabetic characters (punctuation) and split by spaces
        String[] words = sen.replaceAll("[^a-zA-Z ]", "").split(" ");
        String longest = "";

        // Loop through each word
        for (String word : words) {
            // Update longest if the current word is longer
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }
}
