package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE SWIPE CASE TWO CHALLENGE               *
 *                                                              *
 * Problem Statement                                            *
 * Have the function SwapII(str) take the str parameter and swap*
 * the case of each character. Then, if a letter is between two *
 * numbers (without separation), switch the places of the two   *
 * numbers.                                                     *
 * For example: if str is "6Hello4 -8World, 7 yes3"             *
 * the output should be 4hELLO6 -8wORLD, 7 YES3.                *
 *                                                              *
 * Examples                                                     *
 * Input 1: "Hello -5LOL6"                                      *
 * Output 1: hELLO -6lol5                                       *
 *                                                              *
 * Input 2: "2S 6 du5d4e"                                       *
 * Output 2: 2s 6 DU4D5E                                        *
 ***************************************************************/
public class SwapCase {

    public static void main(String[] args) {

        System.out.println(swapCase("6Hello4 -8World, 7 yes3")); // 4hELLO6 -8wORLD, 7 YES3
        System.out.println(swapCase("Hello -5LOL6")); // hELLO -6lol5
        System.out.println(swapCase("2S 6 du5d4e") + "\n"); // 2s 6 DU4D5E

        System.out.println(swapCase("6Hello4 -8World, 7 yes3")); // 4hELLO6 -8wORLD, 7 YES3
        System.out.println(swapCase("Hello -5LOL6")); // hELLO -6lol5
        System.out.println(swapCase("2S 6 du5d4e")); // 2s 6 DU4D5E
    }

    public static String swapCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (char currentChar : charArray) {
            // Swap the case of letters
            if (Character.isLetter(currentChar)) {
                if (Character.isUpperCase(currentChar)) {
                    stringBuilder.append(Character.toLowerCase(currentChar));
                } else {
                    stringBuilder.append(Character.toUpperCase(currentChar));
                }
            } else {
                stringBuilder.append(currentChar);
            }
        }

        // Convert stringBuilder to char array to perform number swapping
        charArray = stringBuilder.toString().toCharArray();
        stringBuilder.setLength(0);  // Clear the stringBuilder to reuse

        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];

            if (Character.isDigit(currentChar) && i + 2 < charArray.length &&
                    Character.isLetter(charArray[i + 1]) && Character.isDigit(charArray[i + 2])) {
                // Swap the digits if a letter is between them
                stringBuilder.append(charArray[i + 2]).append(charArray[i + 1]).append(charArray[i]);
                i += 2;  // Skip the next two characters since they are already processed
            } else {
                stringBuilder.append(currentChar);
            }
        }

        return stringBuilder.toString();
    }

    public static String swapCase2(String str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }

        chars = result.toString().toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (Character.isLetter(chars[i]) && Character.isDigit(chars[i - 1])
                    && Character.isDigit(chars[i + 1])) {
                char temp = chars[i - 1];
                chars[i - 1] = chars[i + 1];
                chars[i + 1] = temp;
            }
        }

        return new String(chars);
    }


}

