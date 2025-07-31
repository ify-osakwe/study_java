package dsa.g4g.strings;

/*
You are given a string s. Your task is to determine if the string is a palindrome.
A string is considered a palindrome if it reads the same forwards and backwards.

Input: s = "abba"
Output: true
Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.

Input: s = "abc"
Output: false
Explanation: "abc" does not read the same forwards and backwards, so it is not a palindrome

Input: s = "a"
Output: true
Explanation: A single-character string is always a palindrome.

Input: s = "acbca"
Output: true
Explanation: "acbca" reads the same forwards and backwards, so it is a palindrome.

Constraints:
1 ≤ s.size() ≤ 10^6
The string s contains only lowercase letters (a-z).
*/
public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));  // true
        System.out.println(isPalindrome("abc"));   // false
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
