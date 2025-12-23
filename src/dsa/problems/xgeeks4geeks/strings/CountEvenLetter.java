package dsa.problems.xgeeks4geeks.strings;

/*
You are given a string s consisting of lowercase english letters. Your task is to count
how many distinct characters appear an even number of times in the string.
Input: s = "abacaba"
Output: 2
Explanation: The frequency of a is 4, b is 2 and c is 1 so there are 2 characters with even frequency.
Input: s = "zzacccz"
Output: 0
Explanation:The frequency of z is 3, a is 1 and c is 3 so there are no characters with even frequency.
Constraint: 1 ≤ s.size() ≤ 10^5
 */
public class CountEvenLetter {
    public static void main(String[] args) {
        System.out.println(count("abacaba")); // 2
        System.out.println(count("zzacccz")); // 0
    }

    public static int count(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int evenCount = 0;
        for (int f : freq) {
            if (f != 0 && (f & 1) == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }
}
