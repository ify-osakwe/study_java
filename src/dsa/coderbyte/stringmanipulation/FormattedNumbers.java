package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE FORMATTED NUMBERS CHALLENGE            *
 *                                                              *
 * Problem Statement                                            *
 * Have the function FormattedNumber(strArr) take the strArr    *
 * parameter being passed, which will only contain a single     *
 * element, and return the string true if it is a valid number  *
 * that contains only digits with properly placed decimals &    *
 * commas, otherwise return the string false.                   *
 * For example: if strArr is ["1,093,222.04"] then your program *
 * should return the string true, but if the input were         *
 * ["1,093,22.04"] then your program should return the string   *
 * false. The input may contain characters other than digits.   *
 *                                                              *
 * Examples                                                     *
 * Input 1: ["0.232567"]                                        *
 * Output 1: true                                               *
 *                                                              *
 * Input 2: ["2,567.00.2"]                                      *
 * Output 2: false                                              *
 *                                                              *
 ***************************************************************/
public class FormattedNumbers {
    public static void main(String[] args) {
        // Test cases
        System.out.println(formattedNumber(new String[]{"1,093,222.04"}));  // Output: true
        System.out.println(formattedNumber(new String[]{"1,093,22.04"}));   // Output: false
        System.out.println(formattedNumber(new String[]{"0.232567"}));      // Output: true
        System.out.println(formattedNumber(new String[]{"2,567.00.2"}));    // Output: false
    }

    // The regular expression ^\\d{1,3}(,\\d{3})*(\\.\\d+)?$
    // is used to check if the string is a valid number with:
    // - A sequence of 1 to 3 digits at the beginning.
    // - Groups of 3 digits separated by commas.
    // - An optional decimal part.
    public static String formattedNumber(String[] strArr) {
        // The input will contain only a single element
        String number = strArr[0];

        // Regular expression to validate the number format
        String regex = "^\\d{1,3}(,\\d{3})*(\\.\\d+)?$";

        // Check if the number matches the regular expression
        if (number.matches(regex)) {
            return "true";
        } else {
            return "false";
        }
    }
}
