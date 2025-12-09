package dsa.problems.g4gstrings;

/*
You are given a lowercase string s, determine the total number of distinct strings
that can be formed using the following rules:
- Identify all unique vowels (a, e, i, o, u) present in the string.
- For each distinct vowel, choose exactly one of its occurrences from s.
If a vowel appears multiple times, each occurrence represents a unique selection choice.
- Generate all possible permutations of the selected vowels.
Each unique arrangement counts as a distinct string.
Return the total number of such distinct strings.

Input: s = "ae"
Output: 2
Explanation: Pick a and e, make all orders → "ae", "ea".

Input: s = "aacidf"
Output: 4
Explanation: Vowels in s are 'a' and 'i', Pick each 'a' once with a single 'i',
make all orders → "ai", "ia", "ai", "ia".
 */
public class CountUniqueVowels {
    public static void main(String[] args) {

    }

    public static int vowelCount(String s) {
        int[] freq = new int[5]; // Frequency for a,e,i,o,u  → indices 0..4
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'a' -> freq[0]++;
                case 'e' -> freq[1]++;
                case 'i' -> freq[2]++;
                case 'o' -> freq[3]++;
                case 'u' -> freq[4]++;
            }
        }

        long ways = 1;
        int distinct = 0;
        for (int f : freq) {
            if (f > 0) {
                ways *= f;      // pick one occurrence of this vowel
                distinct++;     // count how many different vowels we saw
            }
        }

        if (distinct == 0) {
            return 0; // no vowels at all
        }
        for (int i = 2; i <= distinct; i++) {
            ways *= i;
        }
        return (int) ways;
    }
}
