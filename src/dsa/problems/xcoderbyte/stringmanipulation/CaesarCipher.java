package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE CAESAR CIPHER CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function CaesarCipher(str,num) take the str         *
 * parameter and perform a Caesar Cipher shift on it using the  *
 * num parameter as the shifting number. A Caesar Cipher works  *
 * by shifting each letter in the string N places in the        *
 * alphabet (in this case N will be num). Punctuation, spaces,  *
 * and capitalization should remain intact.                     *
 * For example if the string is "Caesar Cipher" and num is 2    *
 * the output should be "Ecguct Ekrjgt".                        *
 *                                                              *
 * Examples                                                     *
 * Input 1: "Hello" and num = 4                                 *
 * Output 1: Lipps                                              *
 *                                                              *
 * Input 2: "abc" and num = 0                                   *
 * Output 2: abc                                                *
 ***************************************************************/
public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(caesarCipher("Hello", 4));        // Output: Lipps
        System.out.println(caesarCipher("Caesar Cipher", 2)); // Output: Ecguct Ekrjgt
        System.out.println(caesarCipher("abc", 0));          // Output: abc
        System.out.println(caesarCipher("XYZ", 3));          // Output: ABC
    }

    public static String caesarCipher(String str, int num) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                // Determine if the character is uppercase or lowercase
                char base = Character.isUpperCase(c) ? 'A' : 'a';

                // Shift the character and wrap around the alphabet
                c = (char) ((c - base + num) % 26 + base);
            }

            // Append the shifted or unmodified character to the result
            result.append(c);
        }

        return result.toString();
    }
}
