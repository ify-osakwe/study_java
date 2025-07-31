package dsa.g4g.strings;

/*
Given a string s, the objective is to convert it into integer format
without utilizing any built-in functions. Refer the below steps to know about atoi() function.

Cases for atoi() conversion:
1. Skip any leading whitespaces.
2. Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
3. Read the integer by ignoring leading zeros until a non-digit character is
encountered or end of the string is reached. If no digits are present, return 0.
4. If the integer is greater than 2^31 – 1, then return 2^31 – 1 and if the integer
is smaller than -2^31, then return -2^31.

Input: s = "-123"
Output: -123
Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer

Input: s = "  -"
Output: 0
Explanation: No digits are present, therefore the returned answer is 0.

Input: s = " 1231231231311133"
Output: 2147483647
Explanation: The converted number will be greater than 2^31 – 1, therefore print 2^31 – 1 = 2147483647.

Input: s = "-999999999999"
Output: -2147483648
Explanation: The converted number is smaller than -2^31, therefore print -2^31 = -2147483648.

Input: s = "  -0012gfg4"
Output: -12
Explanation: After ignoring leading zeros nothing is read after -12 as a non-digit character ‘g’ was encountered.

Constraints:
1 ≤ |s| ≤ 15
 */
public class ImplementAtoi {
    public static void main(String[] args) {

    }

    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check for sign
        int sign = 1;
        if (i < n) {
            if (s.charAt(i) == '+') {
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
        }

        // 3. Process digits and ignore leading zeros
        long result = 0;
        boolean digitFound = false;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                digitFound = true;
                int digit = ch - '0';
                result = result * 10 + digit;
                // 4. Clamp result if it goes out of integer range
                if (sign == 1 && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && -result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break; // non-digit encountered
            }
            i++;
        }

        if (!digitFound) return 0;
        return (int) (sign * result);
    }
}
