package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE FIRST REVERSE CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function FirstReverse(str) take the str parameter   *
 * being passed and return the string in reversed order.        *
 *                                                              *
 * Test Cases                                                   *
 * For example: if the input string is "Hello World and Coders" *
 * then your program should return the string                   *
 * sredoC dna dlroW olleH.                                      *
 *                                                              *
 * Examples                                                     *
 * Input 1: coderbyte                                           *
 * Output 1: etybredoc                                          *
 *                                                              *
 * Input 2: I Love Code                                         *
 * Output 2: edoC evoL I                                        *
 ***************************************************************/
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello World and Coders"));
        // Output: sredoC dna dlroW olleH

        System.out.println(reverseString("coderbyte"));
        // Output: etybredoc

        System.out.println(reverseString("I Love Code") + "\n");
        // Output: edoC evoL I

        System.out.println(reverseString2("Hello World and Coders"));
        // Output: sredoC dna dlroW olleH

        System.out.println(reverseString2("coderbyte"));
        // Output: etybredoc

        System.out.println(reverseString2("I Love Code"));
        // Output: edoC evoL I
    }

    public static String reverseString(String str) {
        // Create a StringBuilder initialized with the input string
        StringBuilder reversedStr = new StringBuilder(str);

        // Reverse the string using the StringBuilder's reverse method
        reversedStr.reverse();

        // Convert the StringBuilder back to a String and return it
        return reversedStr.toString();
    }

    public static String reverseString2(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (int index = charArray.length - 1; index >= 0; index--) {
            stringBuilder.append(charArray[index]);
        }
        return stringBuilder.toString();
    }
}
