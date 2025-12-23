package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE PALINDROME TWO CHALLENGE               *
 *                                                              *
 * Problem Statement                                            *
 * Have the function PalindromeTwo(str) take the str parameter  *
 * being passed and return the string true if the parameter is  *
 * a palindrome, (the string is the same forward as it is       *
 * backward) otherwise return the string false. The parameter   *
 * entered may have punctuation and symbols but they should not *
 * affect whether the string is in fact a palindrome.           *
 * For example: "Anne, I vote more cars race Rome-to-Vienna"    *
 * should return true.                                          *
 *                                                              *
 * Examples                                                     *
 * Input 1: "Noel - sees Leon"                                  *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: "A war at Tarawa!"                                  *
 * Output 2: true                                               *
 ***************************************************************/
public class PalindromeTwo {
    public static void main(String[] args) {
        System.out.println(palindromeTwo("Noel - sees Leon")); // Output: true
        System.out.println(palindromeTwo("A war at Tarawa!")); // Output: true
        System.out.println(palindromeTwo("Hello, World!")); // Output: false
    }

    public static String palindromeTwo(String str) {
        // Remove all non-alphabetic characters and convert the string to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

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
