package dsa.coderbyte.stringmanipulation;

/*
 *           CODERBYTE NUMBER ENCODING CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function NumberEncoding(str) take the str parameter *
 * and encode the message according to the following rule:      *
 * encode every letter into its corresponding numbered position *
 * in the alphabet. Symbols and spaces will also be used in the *
 * input. For example: if str is "af5c a#!" then your program   *
 * should return 1653 1#!.                                      *
 *                                                              *
 * Examples                                                     *
 * Input 1: "hello 45"                                          *
 * Output 1: 85121215 45                                        *
 *                                                              *
 * Input 2: "jaj-a"                                             *
 * Output 2: 10110-1                                            *
 ***************************************************************/
public class NumberEncoding {
    public static void main(String[] args) {
        System.out.println(numberEncoding("af5c a#!"));  // Output: 1653 1#!
        System.out.println(numberEncoding("hello 45"));  // Output: 85121215 45
        System.out.println(numberEncoding("jaj-a"));     // Output: 10110-1
    }

    public static String numberEncoding(String str) {
        StringBuilder encodedStr = new StringBuilder();

        // Iterate through each character in the input string
        for (char c : str.toCharArray()) {
            // Check if the character is a letter
            if (Character.isLetter(c)) {
                // Convert lowercase letters to their alphabet positions
                // (a = 1, b = 2, ..., z = 26)
                int position = Character.toLowerCase(c) - 'a' + 1;
                encodedStr.append(position);
            } else {
                // Keep non-letter characters as they are
                encodedStr.append(c);
            }
        }

        return encodedStr.toString();
    }
}
