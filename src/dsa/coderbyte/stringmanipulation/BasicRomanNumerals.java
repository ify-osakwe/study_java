package dsa.coderbyte.stringmanipulation;

import java.util.HashMap;

/*
 *             CODERBYTE BASIC ROMAN NUMERALS CHALLENGE         *
 *                                                              *
 * Problem Statement                                            *
 * Have the function BasicRomanNumerals(str) read str which     *
 * will be a string of Roman numerals. The numerals being used  *
 * are: I for 1, V for 5, X for 10, L for 50, C for 100, D for  *
 * 500 and M for 1000. In Roman numerals, to create a number    *
 * like 11 you simply add a 1 after the 10, so you get XI. But  *
 * to create a number like 19, you use the subtraction notation *
 * which is to add an I before an X or V (or add an X before    *
 * an L or C). So 19 in Roman numerals is XIX.                  *
 *                                                              *
 * The goal of your program is to return the decimal equivalent *
 * of the Roman numeral given. For example: if str is "XXIV"    *
 * your program should return 24                                *
 *                                                              *
 * Examples                                                     *
 * Input 1: "IV"                                                *
 * Output 1: 4                                                  *
 *                                                              *
 * Input 2: XLVI                                                *
 * Output 2: 46                                                 *
 ***************************************************************/
public class BasicRomanNumerals {
    public static void main(String[] args) {
        System.out.println(basicRomanNumerals("IV"));    // Output: 4
        System.out.println(basicRomanNumerals("XXIV"));  // Output: 24
        System.out.println(basicRomanNumerals("XLVI"));  // Output: 46
        System.out.println(basicRomanNumerals("MCMXC")); // Output: 1990
    }

    public static int basicRomanNumerals(String str) {
        // Create a map to store the Roman numerals and their corresponding values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int n = str.length();

        // Loop through the characters of the Roman numeral string
        for (int i = 0; i < n; i++) {
            // Get the value of the current Roman numeral
            int currentVal = romanMap.get(str.charAt(i));

            // Check if the next Roman numeral is larger (for subtraction cases)
            if (i + 1 < n && romanMap.get(str.charAt(i + 1)) > currentVal) {
                // Subtract the current value from the result
                result -= currentVal;
            } else {
                // Add the current value to the result
                result += currentVal;
            }
        }

        return result;
    }
}
