package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *              CODERBYTE SIMPLE PASSWORD CHALLENGE             *
 *                                                              *
 * Problem Statement                                            *
 * Have the function SimplePassword(str) take the str parameter *
 * being passed and determine if it passes as a valid password  *
 * that follows the list of constraints:                        *
 * 1. It must have a capital letter.                            *
 * 2. It must contain at least one number.                      *
 * 3. It must contain a punctuation mark.                       *
 * 4. It cannot have the word "password" in the string.         *
 * 5. It must be longer than 7 characters and                   *
 *    shorter than 31 characters.                               *
 * If all the above constraints are met within the string, the  *
 * your program should return the string true, otherwise your   *
 * program should return the string false.                      *
 * For example: if str is "apple!M7" then your program should   *
 * return "true".                                               *
 *                                                              *
 * Examples                                                     *
 * Input 1: "passWord123!!!!"                                   *
 * Output 1: false                                              *
 *                                                              *
 * Input 2: "turkey90AAA="                                      *
 * Output 2: true                                               *
 *                                                              *
 ***************************************************************/
public class SimplePassword {
    public static void main(String[] args) {
        System.out.println(simplePassword("passWord123!!!!")); // Output: false
        System.out.println(simplePassword("turkey90AAA="));   // Output: true
        System.out.println(simplePassword("apple!M7"));       // Output: true
        System.out.println(simplePassword("short1A!"));       // Output: true
        System.out.println(simplePassword("password1234"));  // Output: false
    }

    public static String simplePassword(String str) {
        if (str.length() <= 7 || str.length() >= 31) return "false";
        if (str.toLowerCase().contains("password")) return "false";

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasPunctuation = false;

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (isPunctuation(c)) hasPunctuation = true;
        }

        return (hasCapital && hasNumber && hasPunctuation) ? "true" : "false";
    }

    private static boolean isPunctuation(char c) {
        return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
    }
}
