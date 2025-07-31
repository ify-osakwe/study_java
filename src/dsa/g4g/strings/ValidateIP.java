package dsa.g4g.strings;

/*
You are given a string s in the form of an IPv4 Address. Your task is to validate an IPv4 Address,
if it is valid return true otherwise return false.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
each ranging from 0 to 255, separated by dots, e.g., "172.16.254.1"

A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255.
Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)
Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will
be considered invalid.

Input: s = "222.111.111.111"
Output: true
Explanation: Here, the IPv4 address is as per the criteria mentioned and
also all four decimal numbers lies in the mentioned range.
Input: s = "5555..555"
Output: false
Explanation: "5555..555" is not a valid IPv4 address, as the middle two portions are missing.
Input: s = "0.0.0.255"
Output: true
Constraints:
1 ≤ |s| ≤ 15
*/
public class ValidateIP {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        String[] parts = s.split("\\.", -1);
        if (parts.length != 4) return false;

        for (String part : parts) {
            // 1 – 3 chars, all digits
            if (part.isEmpty() || part.length() > 3) return false;
            for (char c : part.toCharArray())
                if (!Character.isDigit(c)) return false;

            // no leading zeros unless the octet is exactly "0"
            if (part.length() > 1 && part.charAt(0) == '0') return false;

            // numeric range check
            int value;
            try {
                value = Integer.parseInt(part);
            } catch (NumberFormatException ex) {
                return false;
            }
            if (value < 0 || value > 255) return false;
        }
        return true;
    }
}
