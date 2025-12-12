package dsa.problems.string;

import java.util.*;

/**
 * Group Anagrams
 * <a href="https://gemini.google.com/share/eaf7b932619f">Gemini Link</a>
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Edge case check (though constraints say 1 <= strs.length)
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store the grouped anagrams
        // Key: The sorted version of the string (e.g., "aet")
        // Value: The list of original strings (e.g., ["eat", "tea", "ate"])
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 1. Convert string to char array to sort it
            char[] charArray = s.toCharArray();

            // 2. Sort the characters
            Arrays.sort(charArray);

            // 3. Convert back to string to use as a key
            String sortedKey = new String(charArray);

            // 4. If key doesn't exist, initialize the list
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            // 5. Add the original string to the correct group
            map.get(sortedKey).add(s);
        }

        // Return the values of the map as a new ArrayList
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + groupAnagrams(input1));
        System.out.println();

        // Test Case 2 (Empty strings)
        String[] input2 = {""};
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + groupAnagrams(input2));
        System.out.println();

        // Test Case 3 (Single character)
        String[] input3 = {"a"};
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("Output: " + groupAnagrams(input3));
        System.out.println();

        // Test Case 4 (No anagrams)
        String[] input4 = {"hello", "world", "java"};
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.toString(input4));
        System.out.println("Output: " + groupAnagrams(input4));
    }
}
