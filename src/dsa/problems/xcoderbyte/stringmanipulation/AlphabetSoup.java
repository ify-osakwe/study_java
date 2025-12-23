package dsa.problems.xcoderbyte.stringmanipulation;

import java.util.Arrays;

/*
 *             CODERBYTE ALPHABET SOUP CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function AlphabetSoup(str) take the str string      *
 * parameter being passed and return the string with the        *
 * letters in alphabetical order (ie. hello becomes ehllo).     *
 * Assume numbers and punctuation symbols will not be included  *
 * in the string.                                               *
 *                                                              *
 * Examples                                                     *
 * Input 1: coderbyte                                           *
 * Output 1: bcdeeorty                                          *
 *                                                              *
 * Input 2: hooplah                                             *
 * Output 2: ahhloop                                            *
 *                                                              *
 ***************************************************************/
public class AlphabetSoup {
    public static void main(String[] args) {
        System.out.println(alphabetSoup("coderbyte"));  // Output: bcdeeorty
        System.out.println(alphabetSoup("hooplah"));    // Output: ahhloop
    }

    public static String alphabetSoup(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Sort the character array
        Arrays.sort(charArray);

        // Convert the sorted character array back to a string
        return new String(charArray);
    }


}
