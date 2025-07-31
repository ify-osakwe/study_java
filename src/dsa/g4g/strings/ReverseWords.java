package dsa.g4g.strings;

/*
Given a string s, reverse the string without reversing its individual words.
Words are separated by spaces.
Note: The string may contain leading or trailing spaces, or multiple spaces between two words.
The returned string should only have a single space separating the words,
and no extra spaces should be included.

Input: s = " i like this program very much "
Output: "much very program this like i"
Explanation: After removing extra spaces and reversing the whole string (not individual words),
the input string becomes "much very program this like i".

Input: s = " pqr  mno "
Output: "mno pqr"
Explanation: After removing extra spaces and reversing the whole string, the input string becomes "mno pqr".

Input: s = " a "
Output: "a"
Explanation: The input string contains only one word with extra spaces around it.
After removing the extra spaces, the output is "a".

Constraints:
1 ≤ s.length() ≤ 10^6
String s contains only lowercase English alphabets and spaces.
*/
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords(" i like this program very much "));
        System.out.println(reverseWords(" pqr  mno "));
        System.out.println(reverseWords(" a "));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(' ');
        }
        return sb.toString();
    }
}
