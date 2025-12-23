package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE CONSONANT COUNT CHALLENGE              *
 *                                                              *
 * Problem Statement                                            *
 * Have the function ConsonantCount(str) take the str string	*
 * parameter being passed and return the number of consonants 	*
 * the string contains.  					*
 *                                                              *
 * Examples                                                     *
 * Input 1: "Hello World"                                       *
 * Output 1: 7		                                        *
 *                                                              *
 * Input 2: "Alphabets"                                         *
 * Output 2: 6                                                  *
 *                                                              *
 ***************************************************************/
public class ConsonantCount {
    public static void main(String[] args) {
        System.out.println(consonantCount("Hello World")); // Output: 7
        System.out.println(consonantCount("Alphabets"));   // Output: 6
        System.out.println(consonantCount("AEIOU"));       // Output: 0
        System.out.println(consonantCount("BCDFG") + "\n");       // Output: 5

        System.out.println(consonantCount2("Hello World")); // Output: 7
        System.out.println(consonantCount2("Alphabets"));   // Output: 6
        System.out.println(consonantCount2("AEIOU"));       // Output: 0
        System.out.println(consonantCount2("BCDFG"));       // Output: 5
    }

    public static int consonantCount(String str) {
        int count = 0;
        str = str.toLowerCase(); // Convert the string to lowercase to simplify comparisons

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z' && !"aeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    public static int consonantCount2(String str) {
        int count = 0;
        str = str.toLowerCase(); // Convert the string to lowercase to simplify comparisons

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z' && !isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isVowel(char c) {
        // Regex pattern to match vowels (both uppercase and lowercase)
        return String.valueOf(c).matches("[AEIOUaeiou]");
    }
}
