package dsa.coderbyte.stringmanipulation;

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
        System.out.println(camelCase("BOB loves-coding"));            // Output: bobLovesCoding
        System.out.println(camelCase("cats ANDDogs-are Awesome"));    // Output: catsAndDogsAreAwesome
        System.out.println(camelCase("a b c d-e-f%g") + "\n");               // Output: aBCDEFG

        System.out.println(camelCase2("BOB loves-coding"));            // Output: bobLovesCoding
        System.out.println(camelCase2("cats ANDDogs-are Awesome"));    // Output: catsAndDogsAreAwesome
        System.out.println(camelCase2("a b c d-e-f%g"));               // Output: aBCDEFG
    }

    public static String camelCase(String str) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(c)) {
                if (result.isEmpty()) {
                    // Lowercase the first letter
                    result.append(Character.toLowerCase(c));
                } else if (capitalizeNext) {
                    // Capitalize the letter if needed
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    // Append the letter as is
                    result.append(c);
                }
            } else {
                // Set the flag to capitalize the next letter
                capitalizeNext = true;
            }
        }

        return result.toString();
    }

    // this gives a more correct ouput
    public static String camelCase2(String str) {
        // Split the string into words using any non-letter character as delimiter
        String[] words = str.split("[^a-zA-Z]");
        StringBuilder result = new StringBuilder();

        // Process each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (i == 0) {
                // Keep the first word in lowercase
                result.append(word);
            } else if (!word.isEmpty()) {
                // Capitalize the first letter of subsequent words
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1));
            }
        }

        return result.toString();
    }
}
