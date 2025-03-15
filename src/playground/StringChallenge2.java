package playground;

import java.util.HashMap;

public class StringChallenge2 {
    public static void main(String[] args) {
        System.out.println(stringChallenge("cdore", "coder")); // Output: true
        System.out.println(stringChallenge("h3llko", "hello")); // Output: false
        System.out.println(stringChallenge("rkqodlw", "world")); // Output: true
    }

    /*
    * write a function in Java - StringChallenge(str1, str2) return type is String
    * it takes both parameters being passed and return the string - true -
    * if a portion of str1 characters can be rearranged to match str2,
    * otherwise return the string false.
    *
    * for example, if str is - rkqodlw - and str2 is - world -
    * the output should return true.
    * Punctuation and symbols will not be entered with the parameters.
    *
    * Example 1
    * input: str1 is cdore, str2 is coder
    * output: true
    *
    * Example 2
    * input str1 is h3llko, str2 is hello
    * output: false
    */
    public static String stringChallenge(String str1, String str2) {
        // Create a HashMap to store the frequency of each character in str1
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Populate the HashMap with the characters from str1
        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if str2 can be formed using the characters from str1
        for (char c : str2.toCharArray()) {
            // If a character in str2 is not present in str1 or
            // if there aren't enough occurrences, return "false"
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return "false";
            }
            // Decrease the count of the character as it is being used
            charCount.put(c, charCount.get(c) - 1);
        }

        // If all characters in str2 are matched, return "true"
        return "true";
    }
}
