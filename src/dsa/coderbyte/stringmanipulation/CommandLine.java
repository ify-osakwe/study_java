package dsa.coderbyte.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

/*
 *              CODERBYTE COMMAND LINE CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function CommandLine(str) take the str parameter    *
 * being passed which represents the parameters given to a      *
 * command in an old PDP system. The parameters are alphanumeric*
 * tokens (without spaces) followed by an equal sign & by their *
 * corresponding value. Multiple parameters/value pairs can be  *
 * placed on the command line with a single space between each  *
 * pair. Parameter tokens and values cannot contain equal signs *
 * but values can contain spaces. The purpose of the function is*
 * to isolate the parameters and values to return a list of     *
 * parameter and value lengths. It must provide its result in   *
 * the same format and in the same order by replacing each entry*
 * (tokens and values) by its corresponding length.             *
 *                                                              *
 * For example, if str is: "SampleNumber=3234 provider=Dr. M.   *
 * Welby patient=John Smith priority=High" then your function   *
 * should return the string "12=4 8=12 7=10 8=4" because        *
 * "SampleNumber" is a 12 character token with a 4 character    *
 * value ("3234") followed by "provider" which is an 8 character*
 * token followed by a 12 character value ("Dr. M. Welby"), etc.*
 *                                                              *
 * Examples                                                     *
 * Input 1: "letters=A B Z T numbers=1 2 26 20 combine=true"    *
 * Output 1: 7=7 7=9 7=4                                        *
 *                                                              *
 * Input 2: "a=3 b=4 a=23 b=a 4 23 c="                          *
 * Output 2: 1=1 1=1 1=2 1=6 1=0                                *
 *                                                              *
 ***************************************************************/
public class CommandLine {
    public static void main(String[] args) {
        /*System.out.println(commandLine("SampleNumber=3234 provider=Dr. M. Welby patient=John Smith priority=High"));
        // Output: 12=4 8=12 7=10 8=4

        System.out.println(commandLine("letters=A B Z T numbers=1 2 26 20 combine=true"));
        // Output: 7=7 7=9 7=4

        System.out.println(commandLine("a=3 b=4 a=23 b=a 4 23 c="));
        // Output: 1=1 1=1 1=2 1=6 1=0*/

        System.out.println(commandLine("SampleNumber=3234 provider=Dr. M. Welby patient=John Smith priority=High"));
        // Output: 12=4 8=12 7=10 8=4

        System.out.println(commandLine("letters=A B Z T numbers=1 2 26 20 combine=true"));
        // Output: 7=7 7=9 7=4

        System.out.println(commandLine("a=3 b=4 a=23 b=a 4 23 c="));
        // Output: 1=1 1=1 1=2 1=6 1=0
    }

    public static String commandLine(String str) {
        StringBuilder result = new StringBuilder();
        String[] pairs = str.split(" ");

        for (String pair : pairs) {
            // Split by the first '=' to separate the token and its value
            String[] parts = pair.split("=", 2);
            String token = parts[0];
            String value = parts[1];

            // Append the length of the token and value in the required format
            result.append(token.length()).append("=").append(value.length()).append(" ");
        }

        // Remove the trailing space and return the result
        return result.toString().trim();
    }

    // HAVING AN ArrayIndexOutOfBoundsException
    // it seems I am not properly splitting the strings

    public static String commandLine2(String str) {
        String[] pairs = str.split(" ");
        List<String> lengths = new ArrayList<>();

        for (String pair : pairs) {
            String[] parts = pair.split("=");
            if (parts.length == 2) {
                int tokenLength = parts[0].length();
                int valueLength = parts[1].length();
                lengths.add(tokenLength + "=" + valueLength);
            }
        }

        return String.join(" ", lengths);
    }
}
