package dsa.problems.paternmatch;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
    public static void main(String[] args) {
        String text = "ABCABCD";
        String pattern = "BCA";
        System.out.println(rabinKarp(text, pattern)); // Output: Pattern found at index 1

        String text2 = "AAAAABAAAA";
        String pattern2 = "AAAA";
        System.out.println(rabinKarp(text2, pattern2)); // Output: Pattern found at index 0
        //         Pattern found at index 1
        //         Pattern found at index 6
    }

    public static List<Integer> rabinKarp(String text, String pattern) {
        final int D = 256; // number of characters in the alphabet (base)
        final int Q = 1000000007; // prime number for the modulo operation

        int pLen = pattern.length();
        int tLen = text.length();
        int i, j;
        int patternHash = 0; // hash value for pattern
        int textHash = 0;    // hash value for text window
        int h = 1;           // The "remove" multiplier: d^(M-1) % q
        List<Integer> foundIndexes = new ArrayList<>();

        // 1. Calculate h = (D^(M-1)) % Q
        // This is the value we'll use to subtract the most significant character
        for (i = 0; i < pLen - 1; i++) {
            h = (h * D) % Q;
        }

        // 2. Calculate the hash value of the pattern
        //    and the hash value of the first window of text
        for (i = 0; i < pLen; i++) {
            patternHash = (D * patternHash + pattern.charAt(i)) % Q;
            textHash = (D * textHash + text.charAt(i)) % Q;
        }

        // 3. Slide the pattern over the text one by one
        for (i = 0; i <= tLen - pLen; i++) {

            // Check if the hash values match
            if (patternHash == textHash) {
                // Hashes match! Now we must verify character by character.
                for (j = 0; j < pLen; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break; // Not a real match (spurious hit)
                    }
                }

                // If j == M, we've verified all characters
                if (j == pLen) {
                    System.out.println("Pattern found at index " + i);
                    foundIndexes.add(i);
                }
            }

            // 4. Calculate the hash for the *next* window
            //    using the rolling hash formula
            if (i < tLen - pLen) {
                // Remove leading character:
                // (textHash - text[i] * h)
                //
                // Shift left:
                // D * ( ... )
                //
                // Add trailing character:
                // ... + text[i+M]
                //
                // And apply modulo:
                // ( ... ) % Q

                textHash = (D * (textHash - text.charAt(i) * h) + text.charAt(i + pLen)) % Q;

                // We might get a negative result, so we add Q to make it positive
                if (textHash < 0) {
                    textHash = (textHash + Q);
                }
            }
        }
        return foundIndexes;
    }
}
