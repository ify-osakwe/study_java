package dsa.problems.hashing;

/**
 * Roman to Integer
 * <a href="https://gemini.google.com/share/c9981b2bdafb">Gemini Link</a>
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        int sum = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentVal = getValue(s.charAt(i));

            if (i < length - 1) {
                int nextVal = getValue(s.charAt(i + 1));

                if (currentVal < nextVal) {
                    sum -= currentVal; // Case: Subtraction (e.g., IV -> 1 < 5)
                } else {
                    sum += currentVal; // Case: Addition (e.g., VI -> 5 > 1, or II -> 1 == 1)
                }
            } else {
                sum += currentVal;
            }
        }

        return sum;
    }

    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0; // Should not happen based on constraints
        };
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "III";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + romanToInt(s1)); // Expected: 3
        System.out.println("-----------------");

        // Test Case 2
        String s2 = "LVIII";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + romanToInt(s2)); // Expected: 58
        System.out.println("-----------------");

        // Test Case 3
        String s3 = "MCMXCIV";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + romanToInt(s3)); // Expected: 1994
        System.out.println("-----------------");
    }
}
