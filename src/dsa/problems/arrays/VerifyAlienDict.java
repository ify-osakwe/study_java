package dsa.problems.arrays;

/**
 * In an alien language, surprisingly, they also use English lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographically in this alien language.
 * <p>
 * Example 1:
 * Input: words = ["hello","leetcode"],
 * order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * <p>
 * Example 2:
 * Input: words = ["word","world","row"],
 * order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1],
 * hence the sequence is unsorted.
 * <p>
 * Example 3:
 * Input: words = ["apple","app"],
 * order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is
 * shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅',
 * where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * <p>
 * 1 <= words[i].length <= 20
 * <p>
 * order.length == 26
 * <p>
 * All characters in words[i] and order are English lowercase letters.
 * <p>
 * Alien Alphabet Sorting Verification
 * <a href="https://gemini.google.com/share/2e60643b0f84">Gemini Link</a>
 */
public class VerifyAlienDict {
    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                int rank1 = orderMap[c1 - 'a'];
                int rank2 = orderMap[c2 - 'a'];

                if (rank1 > rank2) {
                    // Case 1: word1 is greater than word2. The list is unsorted.
                    // Example: "word", "world" in order "worldabc..."
                    // 'd' (rank 3) > 'l' (rank 2)
                    return false;
                }

                if (rank1 < rank2) {
                    // Case 2: word1 is less than word2. This pair is sorted.
                    // We can stop comparing these two words and move to the next pair.
                    // Example: "hello", "leetcode" in order "hlabc..."
                    // 'h' (rank 0) < 'l' (rank 1)
                    foundDifference = true;
                    break;
                }
            }

            // 4. Handle the Prefix Edge Case
            // If the loop finished without finding any difference...
            if (!foundDifference) {
                // ...we check their lengths.
                // Example: "apple", "app"
                // The loop finishes, foundDifference is false.
                // word1.length() (5) > word2.length() (3), so this is unsorted.
                if (word1.length() > word2.length()) {
                    return false;
                }
            }
            // If "app", "apple", word1.length() (3) <= word2.length() (5), so it's fine.
        }

        // 5. Final Result
        // If we checked all pairs and never returned false, the list is sorted.
        return true;
    }
}
