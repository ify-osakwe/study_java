package dsa.problems.paternmatch;

import java.util.ArrayList;
import java.util.List;

public class KmpAlgorithm {
    public static void main(String[] args) {
        String text = "GCABACABACABAD";
        String pattern = "ABACABA";

        // 1. Compute LPS for "ABACABA" -> [0, 0, 1, 0, 1, 2, 3]

        // 2. Run the search
        List<Integer> matches = kmpSearch(text, pattern);

        // 3. Print results
        System.out.println("Pattern found at indices: " + matches);
        // Output: Pattern found at indices: [2, 6]
    }

    /**
     * Searches for all occurrences of a pattern within a text using the KMP algorithm.
     *
     * @param text    The text string to search in.
     * @param pattern The pattern string to search for.
     * @return A list of starting indices where the pattern is found.
     */
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> foundIndices = new ArrayList<>();
        int tLen = text.length();
        int pLen = pattern.length();

        if (pLen == 0) {
            return foundIndices; // No pattern to search for
        }

        // Step 1: Pre-compute the LPS array for the pattern
        int[] lpsArray = computeLPSArray(pattern);

        int tIndex = 0; // index for text
        int pIndex = 0; // index for pattern

        // Step 2: Loop through the text
        while (tIndex < tLen) {
            if (pattern.charAt(pIndex) == text.charAt(tIndex)) {
                // --- Case 1: Characters Match ---
                // Good, move both pointers forward
                tIndex++;
                pIndex++;
            }

            if (pIndex == pLen) {
                // --- Case 2: 🌟 Pattern Found! ---
                // We've matched the entire pattern
                int startIndex = tIndex - pIndex;
                foundIndices.add(startIndex);

                // Use LPS array to find next potential match (for overlaps)
                // This is our Rule 4 from the walkthrough
                pIndex = lpsArray[pIndex - 1];
            } else if (tIndex < tLen && pattern.charAt(pIndex) != text.charAt(tIndex)) {
                // --- Case 3: Mismatch After Some Matches ---
                // Don't restart. Use the magic shift.
                if (pIndex != 0) {
                    // This is our Rule 3a
                    // We fall back, using the LPS array.
                    // 'i' STAYS THE SAME. We re-check text.charAt(i)
                    // against a new character in the pattern.
                    pIndex = lpsArray[pIndex - 1];
                } else {
                    // --- Case 4: Mismatch at j = 0 ---
                    // This is our Rule 3b
                    // We couldn't even match the first character.
                    // Just move on to the next character in the text.
                    tIndex++;
                }
            }
        }
        return foundIndices;
    }

    /**
     * Computes the Longest Proper Prefix (LPS) array for the KMP algorithm.
     * This array stores the length of the longest proper prefix of the
     * sub-pattern pattern[0...i] which is also a suffix of this sub-pattern.
     *
     * @param pattern The pattern string.
     * @return The computed LPS array.
     */
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m]; // This will hold the LPS values

        // `length` stores the length of the previous longest prefix suffix
        // It's like our 'j' pointer, tracking the prefix.
        int length = 0;

        int i = 1; // `i` is our main iterator, tracking the suffix.
        lps[0] = 0; // lps[0] is always 0

        // The loop calculates lps[i] for i = 1 to m-1
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                // Case 1: Characters match
                // We've extended our matching prefix
                length++;
                lps[i] = length;
                i++;
            } else {
                // Case 2: Characters mismatch
                if (length != 0) {
                    // This is the "magic shift"
                    // We don't restart length at 0.
                    // We look at the LPS value of the *previous* character.
                    length = lps[length - 1];
                    // Note: We do NOT increment 'i' here. We re-check
                    // pattern.charAt(i) against the new, shorter 'length'.
                } else {
                    // Case 3: Mismatch, and length is 0
                    // We have no prefix to fall back on.
                    lps[i] = 0;
                    i++; // Move to the next character
                }
            }
        }
        return lps;
    }
}
