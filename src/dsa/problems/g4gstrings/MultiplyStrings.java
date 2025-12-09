package dsa.problems.g4gstrings;

/*
Given two numbers as strings s1 and s2. Calculate their Product.
Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.
*/
public class MultiplyStrings {
    public static void main(String[] args) {

    }

    public String multiplyStrings(String s1, String s2) {
        // strip leading zeros and handle zero cases
        if (s1 == null || s2 == null) return "0";
        boolean neg = false;
        if (s1.startsWith("-")) {
            neg = true;
            s1 = s1.substring(1);
        }
        if (s2.startsWith("-")) {
            neg = !neg;
            s2 = s2.substring(1);
        }

        // remove leading zeroes
        s1 = stripLeadingZeros(s1);
        s2 = stripLeadingZeros(s2);
        if (s1.equals("0") || s2.equals("0")) return "0";

        int n = s1.length(), m = s2.length();
        int[] result = new int[n + m];

        // Perform multiplication digit by digit
        for (int i = n - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int d2 = s2.charAt(j) - '0';
                int mul = d1 * d2;
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        // build string skipping leading zeroes in result array
        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            if (!(sb.isEmpty() && x == 0)) {
                sb.append(x);
            }
        }
        if (sb.isEmpty()) sb.append('0');
        if (neg) sb.insert(0, '-');
        return sb.toString();
    }

    private String stripLeadingZeros(String s) {
        int i = 0, len = s.length();
        while (i < len - 1 && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
