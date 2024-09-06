package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE NUMBER REVERSE CHALLENGE               *
 *                                                              *
 * Problem Statement                                            *
 * Have the function NumberReverse(str) take the str parameter	*
 * being passed which will be a string of numbers, and return a *
 * new string with the numbers in reverse order.  		*
 *                                                              *
 * Examples                                                     *
 * Input 1: "1 2 3"                                             *
 * Output 1: 3 2 1                                              *
 *                                                              *
 * Input 2: "10 20 50"                                          *
 * Output 2: 50 20 10                                           *
 *                                                              *
 ***************************************************************/
public class NumberReverse {
    public static void main(String[] args) {
        System.out.println(numberReverse("1 2 3")); // Output: 3 2 1
        System.out.println(numberReverse("10 20 50")); // Output: 50 20 10
    }

    public static String numberReverse(String str) {
        String[] splittedString = str.split(" ");
        StringBuilder reversedString = new StringBuilder();

        for (int i = splittedString.length - 1; i >= 0; i--) {
            reversedString.append(splittedString[i]).append(" ");
        }

        return reversedString.toString();
    }
}
