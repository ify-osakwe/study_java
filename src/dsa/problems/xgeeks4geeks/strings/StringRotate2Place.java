package dsa.problems.xgeeks4geeks.strings;

/*
Given two strings s1 and s2. Return true if the string s2 can be obtained
by rotating (in any direction) string s1 by exactly 2 places, otherwise, false.
Note: Both rotations should be performed in same direction chosen initially.

Input: s1 = "amazon", s2 = "azonam"
Output: true
Explanation: "amazon" can be rotated anti-clockwise by two places, which will make it as "azonam".

Input: s1 = "geeksforgeeks", s2 = "geeksgeeksfor"
Output: false
Explanation: If we rotate "geeksforgeeks" by two place in any direction, we won't get "geeksgeeksfor".

Input: s1 = "ab", s2 = "ab"
Output: true
Explanation: If we rotate "ab" by two place in any direction, we always get "ab".

Constraints:
1 ≤ s1.length, s2.length ≤ 10^5
*/
public class StringRotate2Place {
    public static void main(String[] args) {
        System.out.println(isRotated("amazon", "azonam")); // true
        System.out.println(isRotated("geeksforgeeks", "geeksgeeksfor")); // false
        System.out.println(isRotated("ab", "ab"));
    }

    public static boolean isRotated(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        // For very short strings (length <= 2), any rotation yields the same string
        if (n <= 2) {
            return s1.equals(s2);
        }

        boolean clockwise = true;
        boolean anticlockwise = true;

        // Check clockwise: s2[i] == s1[(i + 2) % n]
        for (int i = 0; i < n; i++) {
            if (s1.charAt((i + 2) % n) != s2.charAt(i)) {
                clockwise = false;
                break;
            }
        }

        // Check anticlockwise: s2[(i + 2) % n] == s1.charAt(i)
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt((i + 2) % n)) {
                anticlockwise = false;
                break;
            }
        }

        return clockwise || anticlockwise;
    }
}
