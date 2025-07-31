package dsa.g4g.strings;

/*
Given an array of strings arr[]. Return the longest common prefix among each and every strings
present in the array. If there's no prefix common in all the strings, return "".
Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: "gee"
Explanation: "gee" is the longest common prefix in all the given strings.
Input: arr[] = ["hello", "world"]
Output: ""
Explanation: There's no common prefix in the given strings.
Constraints:
1 ≤ |arr| ≤ 10^3
1 ≤ |arr[i]| ≤ 10^3
*/
public class LongCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}));
        System.out.println(longestCommonPrefix(new String[]{"hello", "world"}));
    }

    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        String prefix = arr[0];
        for (int i = 1; i < arr.length && !prefix.isEmpty(); i++) {
            while (!arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) break;
            }
        }
        return prefix;
    }
}
