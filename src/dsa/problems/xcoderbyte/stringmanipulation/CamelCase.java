package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE CAMEL CASE CHALLENGE                   *
 *                                                              *
 * Problem Statement                                            *
 * Have the function CamelCase(str) take the str parameter being*
 * passed and return it in proper camel case format where the   *
 * first letter of each word is capitalized (excluding the first*
 * letter). The string will only contain letters and some       *
 * combination of delimiter punctuation characters separating   *
 * each word.                                                   *
 *                                                              *
 * For example: if str is "BOB loves-coding" then your program  *
 *  should return the string bobLovesCoding.                    *
 *                                                              *
 * Examples                                                     *
 * Input 1: "cats AND*Dogs-are Awesome"                         *
 * Output 1: catsAndDogsAreAwesome                              *
 *                                                              *
 * Input 2: "a b c d-e-f%g"                                     *
 * Output 2: aBCDEFG                                            *
 ***************************************************************/
public class CamelCase {
    public static void main(String[] args) {
        System.out.println(camelCase("BOB loves-coding"));
        // Output: bobLovesCoding

        System.out.println(camelCase("cats AND*Dogs-are Awesome"));
        // Output: catsAndDogsAreAwesome

        System.out.println(camelCase("a b c d-e-f%g"));
        // Output: aBCDEFG
    }

    public static String camelCase(String str) {
        // Split the string into wordsArray using any non-letter character as delimiter
        String[] wordsArray = str.split("[^a-zA-Z]");
        StringBuilder result = new StringBuilder();

        // Process each word
        for (int i = 0; i < wordsArray.length; i++) {
            String word = wordsArray[i].toLowerCase();
            if (i == 0) {
                // Keep the first word in lowercase
                result.append(word);
            } else if (!word.isEmpty()) {
                // Capitalize the first letter of subsequent wordsArray
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1));
            }
        }

        return result.toString();
    }
}
