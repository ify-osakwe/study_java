package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE PALINDROME CHALLENGE                   *
 *                                                              *
 * Problem Statement                                            *
 * Have the function Palindrome(str) take the str parameter     *
 * being passed and return the string true if the parameter is  *
 * a palindrome, (the string is the same forward as it is       *
 * backward) otherwise return the string false. For example:    *
 * "racecar" is also "racecar" backwards. Punctuation & numbers *
 * will not be part of the string.                              *
 *                                                              *
 * Examples                                                     *
 * Input 1: never odd or even                                   *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: eye                                                 *
 * Output 2: true                                               *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 33.0% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome("never odd or even")); // Output: true
        System.out.println(palindrome("eye")); // Output: true
        System.out.println(palindrome("hello")); // Output: false
    }

    public static String palindrome(String str) {
        // Remove all spaces and convert the string to lowercase
        String cleanedStr = str.replaceAll("\\s+", "").toLowerCase();

        // Reverse the cleaned string
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();

        // Check if the cleaned string is equal to the reversed string
        if (cleanedStr.equals(reversedStr)) {
            return "true";
        } else {
            return "false";
        }
    }
}
