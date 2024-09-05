package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE LETTER CAPITALIZE CHALLENGE            *
 *                                                              *
 * Problem Statement                                            *
 * Have the function LetterCapitalize(str) take the str         *
 * parameter being passed and capitalize the first letter of    *
 * each word. Words will be separated by only one space.        *
 *                                                              *
 * Examples                                                     *
 * Input 1: "hello world"                                       *
 * Output 1: Hello World                                        *
 *                                                              *
 * Input 2: "i ran there"                                       *
 * Output 2: I Ran There                                        *
 ***************************************************************/
public class LetterCapitalize {
    public static void main(String[] args) {
        System.out.println(letterCapitalize("hello world"));  // Output: Hello World
        System.out.println(letterCapitalize("i ran there"));  // Output: I Ran There
    }

    public static String letterCapitalize(String str) {
        // Split the string by spaces to get individual words
        String[] words = str.split(" ");

        // StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Loop through each word
        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize the first letter and append the rest of the word
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        // Return the result string without the trailing space
        return result.toString().trim();
    }
}
