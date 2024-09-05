package dsa.coderbyte.stringmanipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 *             CODERBYTE EX OH CHALLENGE                        *
 *                                                              *
 * Problem Statement                                            *
 * Have the function ExOh(str) take the str parameter being     *
 * passed & return the string true if there is an equal number  *
 * of x's & o's, otherwise return the string false. Only these  *
 * two letters will be entered in the string, no punctuation or *
 * numbers. For example: if str is "xooxxxxooxo" then the       *
 * output should return false because there are 6 x's and 5 o's *
 *                                                              *
 * Examples                                                     *
 * Input 1: xooxxo                                              *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: x                                                   *
 * Output 2: false                                              *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 16.8% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class XandO {
    public static void main(String[] args) {
        System.out.println(xAndO("xooxxxxooxo")); // Output: false
        System.out.println(xAndO("xooxxo"));      // Output: true
        System.out.println(xAndO("x") + "\n");    // Output: false

        System.out.println(xAndOv2("xooxxxxooxo")); // Output: false
        System.out.println(xAndOv2("xooxxo"));      // Output: true
        System.out.println(xAndOv2("x"));           // Output: false
    }

    public static String xAndO(String str) {
        int xCount = 0;
        int oCount = 0;

        // Iterate through the string and count the 'x' and 'o' characters
        for (char c : str.toCharArray()) {
            if (c == 'x') {
                xCount++;
            } else if (c == 'o') {
                oCount++;
            }
        }

        // Compare the counts of 'x' and 'o'
        return xCount == oCount ? "true" : "false";
    }

    public static String xAndOv2(String str) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }

        Integer xValue = characterMap.get('x');
        Integer oValue = characterMap.get('o');

        // Compare the counts of 'x' and 'o'
        return Objects.equals(xValue, oValue) ? "true" : "false";
    }
}
