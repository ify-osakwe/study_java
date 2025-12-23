package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE SIMPLE SYMBOLS CHALLENGE               *
 *                                                              *
 * Problem Statement                                            *
 * Have the function SimpleSymbols(str) take the str parameter  *
 * being passed and determine if it is an acceptable sequence   *
 * by either returning the string true or false. The str        *
 * parameter will be composed of + and = symbols with several   *
 * characters between them (ie. ++d+===+c++==a) and for the     *
 * string to be true each letter must be surrounded by          *
 * a + symbol. So the string to the left would be false.        *
 * The string will not be empty & will have at least one letter *
 *                                                              *
 * Examples                                                     *
 * Input 1: "+d+=3=+s+"                                         *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: "f++d+"                                             *
 * Output 2: false                                              *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 48.0% of users who solved this   *
 * challenge.                                                   *
 ***************************************************************/
public class SimpleSymbols {
    public static void main(String[] args) {
        System.out.println(simpleSymbols("+d+=3=+s+")); // Should print true
        System.out.println(simpleSymbols("f++d+")); // Should print false
        System.out.println(simpleSymbols("+a+"));       // true
        System.out.println(simpleSymbols("+++"));       // true
        System.out.println(simpleSymbols("a+b+c+"));    // false
    }

    public static String simpleSymbols(String str) {
        if (str == null || str.length() < 3) return "false";

        char[] chars = str.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            if (Character.isLetter(chars[index])) {
                // Check if the letter is at the start or end of the string
                if (index == 0 || index == chars.length - 1) {
                    return "false";
                }
                // Check if the letter is surrounded by + symbols
                if (chars[index - 1] != '+' || chars[index + 1] != '+') {
                    return "false";
                }
            }
        }
        return "true";
    }
}
