package dsa.problems.g4gstrings;
/*
Given a string s, remove all its adjacent duplicate characters recursively,
until there are no adjacent duplicate characters left.

Note: If the resultant string becomes empty, return an empty string.

Input: s = "geeksforgeek"
Output: "gksforgk"
Explanation:  g(ee)ksforg(ee)k -> gksforgk

Input: s = "abccbccba"
Output: ""
Explanation: ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)

Input: s = "abcd"
Output: "abcd"
Explanation: There are no adjacent duplicate characters

Constraints:
1 <= s.size() <= 10^5
*/
public class AdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeUtil("geeksforgeek"));
    }

    public static String removeUtil(String str) {
        if (str == null || str.isEmpty()) return "";

        String current = str;
        while (true) {
            StringBuilder sb = new StringBuilder();
            int n = current.length();

            for (int i = 0; i < n; ) {
                int j = i;
                // advance j to the end of the current run of equal chars
                while (j + 1 < n && current.charAt(j) == current.charAt(j + 1)) {
                    j++;
                }
                // if it's a run of length 1, keep it; otherwise drop the whole run
                if (j == i) {
                    sb.append(current.charAt(i));
                }
                // move past this run
                i = j + 1;
            }

            // if no change, we're done
            String next = sb.toString();
            if (next.length() == current.length()) {
                return next;
            }
            current = next;  // continue removing newly formed adjacencies
        }
    }
}
