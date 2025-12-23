package dsa.problems.xcoderbyte.stringmanipulation;

/****************************************************************
 *             CODERBYTE STRING CHANGES CHALLENGE               *
 *                                                              *
 * Problem Statement                                            *
 * Have the function StringChanges(str) take the str parameter  *
 * being passed, which will be a string containing letters from *
 * the alphabet, and return a new string based on the following *
 * rules. Whenever a capital M is encountered, duplicate the    *
 * previous character (then remove the M), and whenever a       *
 * capital N is encountered remove the next character from the  *
 * string (then remove the N). All other characters in the      *
 * string will be lowercase letters.                            *
 * For example: "abcNdgM" should return "abcgg".                *
 * The final string will never be empty.                        *
 *                                                              *
 * Examples                                                     *
 * Input 1: "MrtyNNgMM"                                         *
 * Output 1: rtyggg                                             *
 *                                                              *
 * Input 2: "oMoMkkNrrN"                                        *
 * Output 2: ooookkr                                            *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 52.6% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class StringChanges {
    public static void main(String[] args) {
        System.out.println(stringChanges("abcNdgM"));  // Output: "abcgg"
        System.out.println(stringChanges("MrtyNNgMM"));  // Output: "rtyggg"
        System.out.println(stringChanges("oMoMkkNrrN"));  // Output: "ooookkr"
    }

    public static String stringChanges(String str) {
        StringBuilder newString = new StringBuilder();

        for (int index = 0; index < str.length(); index++) {
            char current = str.charAt(index);

            if (current == 'M') {
                // Duplicate the previous character
                if (!newString.isEmpty()) {
                    char previousChar = newString.charAt(newString.length() - 1);
                    newString.append(previousChar);
                }
            } else if (current == 'N') {
                // Remove the next character if exists
                // and Skip the next character
                if (index + 1 < str.length()) index++;
            } else {
                // Append the current character if it's not 'M' or 'N'
                newString.append(current);
            }
        }

        return newString.toString();
    }
}
