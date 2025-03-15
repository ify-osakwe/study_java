package dsa.coderbyte.stringmanipulation;

import java.util.HashSet;

/*
 *             CODERBYTE ALPHABET SEARCHING CHALLENGE           *
 *                                                              *
 * Problem Statement                                            *
 * Have the function AlphabetSearching(str) take the string     *
 * parameter being passed and return the string true if every   *
 * single letter of the English alphabet exists in the string,  *
 * otherwise return the string false.                           *
 * For example: if str is "zacxyjbbkfgtbhdaielqrm45pnsowtuv"    *
 * then your program should return the string true because every*
 * character in the alphabet exists in this string even though  *
 * some characters appear more than once.                       *
 *                                                              *
 * Examples                                                     *
 * Input 1: abcdefghijklmnopqrstuvwxyyyy                        *
 * Output 1: false                                              *
 *                                                              *
 * Input 2: abc123456kmo                                        *
 * Output 2: false                                              *
 ***************************************************************/
public class AlphabetSearching {
    public static void main(String[] args) {
        System.out.println(alphabetSearching("zacxyjbbkfgtbhdaielqrm45pnsowtuv"));  // Output: true
        System.out.println(alphabetSearching("abcdefghijklmnopqrstuvwxyz"));       // Output: true
        System.out.println(alphabetSearching("abcdefg hijklmnopqrstuvwxyz"));      // Output: true
        System.out.println(alphabetSearching("abc123456kmo"));                     // Output: false
        System.out.println(alphabetSearching("abcdefghijklmnopqrstuvwxyyyy"));     // Output: false
    }

    public static String alphabetSearching(String str) {
        str = str.toLowerCase();
        HashSet<Character> alphabetSet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                alphabetSet.add(c);
            }
        }

        return alphabetSet.size() == 26 ? "true" : "false";
    }
}
