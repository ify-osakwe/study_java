package dsa.problems.g4gstrings;

/*
You are given two strings s1 and s2, of equal lengths. The task is to check if s2 is a rotated
version of the string s1.
Note: A string is a rotation of another if it can be formed by moving characters
from the start to the end (or vice versa) without rearranging them.
Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.
Constraints:
1 ≤ s1.size(), s2.size() ≤ 10^5
s1, s2 consists of lowercase English alphabets.
*/
public class StringRotate {
    public static void main(String[] args) {
        System.out.println(areRotations("abcd", "cdab")); // true
        System.out.println(areRotations("aab", "aba"));  // true
        System.out.println(areRotations("abcd", "acbd")); // false
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String doubled = s1 + s1;
        return doubled.contains(s2);
        // return doubled.indexOf(s2) != -1;
    }

}
