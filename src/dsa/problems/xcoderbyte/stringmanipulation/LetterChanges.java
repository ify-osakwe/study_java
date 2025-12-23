package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE LETTER CHANGES CHALLENGE               *
 *                                                              *
 * Problem Statement                                            *
 * Have the function LetterChanges(str) take the str parameter  *
 * being passed and modify it using the following algorithm.    *
 * Replace every letter in the string with the letter following *
 * it in the alphabet (ie. c becomes d, z becomes a). Then      *
 * capitalize every vowel in this new string (a, e, i, o, u)    *
 * & finally return this modified string.                       *
 *                                                              *
 * Examples                                                     *
 * Input 1: hello*3                                             *
 * Ouput 1: Ifmmp*3                                             *
 *                                                              *
 * Input 2: fun times!                                          *
 * Output 2: gvO Ujnft!                                         *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 60.4% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class LetterChanges {

    public static void main(String[] args) {
        // Test cases
        System.out.println(letterChanges("hello3"));    // Output: Ifmmp3
        System.out.println(letterChanges("fun times!")); // Output: gvO Ujnft!
    }

    public static String letterChanges(String str) {
        StringBuilder result = new StringBuilder();

        // Loop through each character in the string
        for (char c : str.toCharArray()) {
            // Check if the character is a letter
            if (Character.isLetter(c)) {
                // Replace the letter with the next one in the alphabet
                if (c == 'z') {
                    c = 'a';  // Wrap around for 'z'
                } else if (c == 'Z') {
                    c = 'A';  // Wrap around for 'Z'
                } else {
                    c = (char) (c + 1);
                }
            }

            // Capitalize vowels if the character is a letter
            if ("aeiou".indexOf(c) != -1) {
                c = Character.toUpperCase(c);
            }

            // Append the character to the result
            result.append(c);
        }

        return result.toString();
    }
}
