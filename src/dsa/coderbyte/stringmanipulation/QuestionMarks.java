package dsa.coderbyte.stringmanipulation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *             CODERBYTE QUESTIONS MARKS CHALLENGE              *
 *                                                              *
 * Problem Statement                                            *
 * Have the function QuestionsMarks(str) which takes the str    *
 * string parameter, which will contain single digit numbers,   *
 * letters, & question marks, & check if there are exactly 3    *
 * question marks between every pair of two numbers that add up *
 * to 10. If so, then your program should return the string     *
 * true, otherwise it should return the string false. If there  *
 * aren't any two numbers that add up to 10 in the string, then *
 * your program should return false as well.                    *
 *                                                              *
 * Test Cases                                                   *
 * For example: if str is "arrb6???4xxbl5???eee5" then your     *
 * program should return true because there are exactly 3       *
 * question marks between 6 and 4, and 3 question marks between *
 * 5 and 5 at the end of the string.                            *
 *                                                              *
 * Examples                                                     *
 * Input 1: aa6?9                                               *
 * Output 1: false                                              *
 *                                                              *
 * Input 2: acc?7??sss?3rr1??????5                              *
 * Output 2: true                                               *
 *                                                              *
 * Input 3: 5??aaaaaaaaaaaaaaaaaaa?5?5                          *
 * Output 3: false                                              *
 *                                                              *
 * Input 4: 9???1???9???1???9                                   *
 * Output 4: true                                               *
 ***************************************************************/
public class QuestionMarks {
    public static void main(String[] args) {
        System.out.println(questionMarks("arrb6???4xxbl5???eee5")); // Output: true
        System.out.println(questionMarks("aa6?9")); // Output: false
        System.out.println(questionMarks("acc?7??sss?3rr1??????5")); // Output: true
        System.out.println(questionMarks("5??aaaaaaaaaaaaaaaaaaa?5?5")); // Output: false
        System.out.println(questionMarks("9???1???9???1???9")); // Output: true
    }

    public static String questionMarks(String str) {
        // Variables to track the previous digit and question mark count
        int prevDigit = -1;
        int questionMarkCount = 0;
        boolean validPairFound = false;

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Check if the current character is a digit
            if (Character.isDigit(currentChar)) {
                int currentDigit = Character.getNumericValue(currentChar);

                // Check if there's a previous digit and if their sum is 10
                if (prevDigit != -1 && (prevDigit + currentDigit == 10)) {
                    validPairFound = true;

                    if (questionMarkCount != 3) return "false";
                }

                // Reset the question mark count and update the previous digit
                prevDigit = currentDigit;
                questionMarkCount = 0;

            } else if (currentChar == '?') {
                questionMarkCount++;
            }
        }

        // If no valid pairs are found, return false
        return validPairFound ? "true" : "false";
    }

    public static String questionMarks2(String str) {
        // Define the regex pattern to find a digit, three question marks, and another digit
        Pattern pattern = Pattern.compile("(\\d)\\?{3}(\\d)");
        Matcher matcher = pattern.matcher(str);

        boolean validPairFound = false;

        // Iterate through the matches
        while (matcher.find()) {
            int firstDigit = Integer.parseInt(matcher.group(1));
            int secondDigit = Integer.parseInt(matcher.group(2));

            if (firstDigit + secondDigit == 10) {
                validPairFound = true;
            } else {
                return "false";
            }
        }

        // Return true if at least one valid pair is found, otherwise return false
        return validPairFound ? "true" : "false";
    }


}
