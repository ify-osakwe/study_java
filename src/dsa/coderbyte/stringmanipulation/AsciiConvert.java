package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE ASCII CONVERTION CHALLENGE             *
 *                                                              *
 * Problem Statement                                            *
 * Have the function ASCIIConversion(str) take the str parameter*
 * being passed and return a new string where every character,  *
 * aside from the space character, is replaced with its         *
 * corresponding decimal character code. For example: if str is *
 * "dog" then your program should return the string 100111103   *
 * because d = 100, o = 111, g = 103.                           *
 *                                                              *
 * Examples                                                     *
 * Input 1: "hello world"                                       *
 * Output 1: 104101108108111 119111114108100                    *
 *                                                              *
 * Input 2: "abc **"                                            *
 * Output 2: 979899 4242                                        *
 ***************************************************************/
public class AsciiConvert {
    public static void main(String[] args) {
        System.out.println(asciiConversion("hello world"));  // Output: 104101108108111 119111114108100
        System.out.println(asciiConversion("abc "));         // Output: 979899
    }

    public static String asciiConversion(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c != ' ') {
                result.append((int) c);
            } else {
                result.append(' ');
            }
        }

        return result.toString();
    }
}
