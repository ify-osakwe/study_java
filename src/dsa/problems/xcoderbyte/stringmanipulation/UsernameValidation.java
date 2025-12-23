package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *      CODERBYTE CODELAND USERNAME VALIDATION CHALLENGE        *
 *                                                              *
 * Problem Statement                                            *
 * Have the function CodelandUsernameValidation(str) take the   *
 * str parameter being passed and determine if the string is a  *
 * valid username according to the following rules:             *
 * 1. The username is between 4 and 25 characters.              *
 * 2. It must start with a letter.                              *
 * 3. It can only contain letters, numbers, & underscore.       *
 * 4. It cannot end with an underscore character.               *
 * If the username is valid then your program should return the *
 * string true, otherwise return the string false.              *
 *                                                              *
 * Examples                                                     *
 * Input 1: "aa_"                                               *
 * Output 1: false                                              *
 *                                                              *
 * Input 2: "u__hello_world123"                                 *
 * Output 2: true                                               *
 *                                                              *
 ***************************************************************/
public class UsernameValidation {
    public static void main(String[] args) {
        System.out.println(usernameValidation("aa_"));              // Output: false
        System.out.println(usernameValidation("u__hello_world123")); // Output: true
        System.out.println(usernameValidation("user_name_"));        // Output: false
        System.out.println(usernameValidation("user1"));             // Output: true
        System.out.println(usernameValidation("2username"));         // Output: false
    }

    public static String usernameValidation(String str) {
        // Rule 1: Check length between 4 and 25 characters
        if (str.length() < 4 || str.length() > 25) {
            return "false";
        }

        // Rule 2: Check if the first character is a letter
        if (!Character.isLetter(str.charAt(0))) {
            return "false";
        }

        // Rule 3: Check if it contains only letters, numbers, and underscores
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return "false";
            }
        }

        // Rule 4: Check if it ends with an underscore
        if (str.charAt(str.length() - 1) == '_') {
            return "false";
        }

        // If all conditions are met, return true
        return "true";
    }
}
