package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE AB CHECKS CHALLENGE                    *
 *                                                              *
 * Problem Statement                                            *
 * Have the function ABCheck(str) take the str parameter being  *
 * passed and return the string true if the characters a and b  *
 * are separated by exactly 3 places anywhere in the string at  *
 * least once (ie. "lane borrowed" would result in true because *
 * there is exactly three characters between a and b).          *
 * Otherwise return the string false.                           *
 *                                                              *
 * Examples                                                     *
 * Input 1: after badly                                         *
 * Output 1: false                                              *
 *                                                              *
 * Input 2: Laura sobs                                          *
 * Output 2: true                                               *
 *                                                              *
 ***************************************************************/
public class ABCheck {

    public static void main(String[] args) {
        System.out.println(abcheck("after badly"));  // Output: false
        System.out.println(abcheck("Laura sobs"));   // Output: true
    }

    public static String abcheck(String str) {
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 4; i++) {
            if ((str.charAt(i) == 'a' && str.charAt(i + 4) == 'b') ||
                    (str.charAt(i) == 'b' && str.charAt(i + 4) == 'a')) {
                return "true";
            }
        }

        return "false";
    }
}
