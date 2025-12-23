package dsa.problems.xgeeks4geeks.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings s1 and s2 consisting of only lowercase English letters and of equal length,
check if these two strings are isomorphic to each other.
If the characters in s1 can be changed to get s2, then two strings, s1 and s2 are isomorphic.
A character must be completely swapped out for another character while maintaining the order of
the characters. A character may map to itself, but no two characters may map to the same character.

Input: s1 = "aab", s2 = "xxy"
Output: true
Explanation: Each character in s1 can be consistently mapped to a unique character in s2 (a → x, b → y).

Input: s1 = "aab", s2 = "xyz"
Output: false
Explanation: Same character 'a' in s1 maps to two different characters 'x' and 'y' in s2.

Input: s1 = "abc", s2 = "xxz"
Output: false
Explanation: Two different characters 'a' and 'b' in s1 maps with same character 'x' in s2.

Constraints:
1 ≤ s1.size() = s2.size() ≤ 10^5
*/
public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(areIsomorphic("egg", "add"));
    }

    public static boolean areIsomorphic(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        int[] array2 = new int[26];
        int[] array1 = new int[26];
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Array 1: " + Arrays.toString(array1));

        Arrays.fill(array2, -1);
        Arrays.fill(array1, -1);

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        for (int i = 0; i < s1.length(); i++) {
            int indexA = s1.charAt(i) - 'a';
            int indexB = s2.charAt(i) - 'a';

            System.out.println("IndexA: " + indexA + " IndexB: " + indexB);

            if (array2[indexA] == -1 && array1[indexB] == -1) {
                array2[indexA] = indexB;
                array1[indexB] = indexA;

                System.out.println("Array 2: " + Arrays.toString(array2));
                System.out.println("Array 1: " + Arrays.toString(array1));

            } else if (array2[indexA] != indexB || array1[indexB] != indexA) {
                return false;
            }
        }
        return true;
    }

    public static boolean areIsomorphic2(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        Map<Character, Character> forward = new HashMap<>(); // s1 -> s2
        Map<Character, Character> reverse = new HashMap<>(); // s2 -> s1

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            Character mb = forward.get(a);
            Character ma = reverse.get(b);

            if (mb == null && ma == null) {
                forward.put(a, b);
                reverse.put(b, a);
            } else {
                if (mb == null || ma == null) return false; // one mapped, the other not
                if (mb != b || ma != a) return false;       // inconsistent mapping
            }
        }
        return true;
    }
}
