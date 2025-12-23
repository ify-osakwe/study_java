package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE VOWEL COUNT CHALLENGE                  *
 *                                                              *
 * Problem Statement                                            *
 * Have the function VowelCount(str) take the str string        *
 * parameter being passed and return the number of vowels the   *
 * string contains (ie. "All cows eat grass and moo" would      *
 * return 8). Do not count y as a vowel for this challenge.     *
 *                                                              *
 * Examples                                                     *
 * Input 1: "hello"                                             *
 * Output 1: 2                                                  *
 *                                                              *
 * Input 2: "coderbyte"                                         *
 * Output 2: 3                                                  *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 20.7% of users who solved this   *
 * challenge.                                                   *
 *                                                              *
 ***************************************************************/
public class VowelCount {
    public static void main(String[] args) {
        System.out.println(vowelCount2("hello")); // 2
        System.out.println(vowelCount2("coderbyte")); // 3
        System.out.println(vowelCount2("All cows eat grass and moo")); // Output: 8
    }

    public static int vowelCount2(String str) {
        int count = 0;
        str = str.toLowerCase(); // Convert the string to lowercase to simplify comparisons

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c) && "aeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

}
