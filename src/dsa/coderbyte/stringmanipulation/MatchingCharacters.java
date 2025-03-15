package dsa.coderbyte.stringmanipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 *           CODERBYTE MATCHING CHARACTERS CHALLENGE            *
 *                                                              *
 * Problem Statement                                            *
 * Have the function MatchingCharacters(str) take the str       *
 * parameter being passed and determine the largest number of   *
 * unique characters that exists between a pair of matching     *
 * letters anywhere in the string.                              *
 *                                                              *
 * For example: if str is "ahyjakh" then there are only two     *
 * pairs of matching letters, the two a's and the two h's.      *
 * Between the pair of a's there are 3 unique characters:       *
 * h, y, and j.                                                 *
 * Between the h's there are 4 unique characters: y, j, a, & k. *
 * So for this example your program should return 4.            *
 *                                                              *
 * Another example: if str is "ghececgkaem" then your program   *
 * should return 5 because the most unique characters exists    *
 * within the farthest pair of e characters. The input string   *
 * may not contain any character pairs, and in that case your   *
 * program should just return 0. The input will only consist of *
 * lowercase alphabetic characters.                             *
 *                                                              *
 * Examples                                                     *
 * Input 1: "mmmerme"                                           *
 * Output 1: "3"                                                *
 *                                                              *
 * Input 2: "abccdefghi"                                        *
 * Output 2: "0"                                                *
 *                                                              *
 * Solution Efficiency                                          *
 * This user scored higher than 67.3% of users who solved this  *
 * challenge.                                                   *
 ***************************************************************/
public class MatchingCharacters {
    public static void main(String[] args) {
        System.out.println(matchingCharacters("mmmerme"));  // Output: 3
        System.out.println(matchingCharacters("abccdefghi"));  // Output: 0
        System.out.println(matchingCharacters("ahyjakh"));  // Output: 4
        System.out.println(matchingCharacters("ghececgkaem"));  // Output: 5
    }

    public static int matchingCharacters(String str) {
        // To keep track of the last seen index of each character
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        int maxUniqueCount = 0;

        // Iterate through the string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (lastIndexMap.containsKey(currentChar)) {
                // Calculate the unique characters between the matching pair
                int startIndex = lastIndexMap.get(currentChar);
                Set<Character> uniqueChars = new HashSet<>();

                // Add unique characters between the pair to the set
                for (int j = startIndex + 1; j < i; j++) {
                    uniqueChars.add(str.charAt(j));
                }

                // Update the maximum number of unique characters found
                maxUniqueCount = Math.max(maxUniqueCount, uniqueChars.size());
            }

            // Update the last index of the current character
            lastIndexMap.put(currentChar, i);
        }

        return maxUniqueCount;
    }
}
