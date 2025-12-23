package dsa.problems.xgeeks4geeks.strings;

public class RomanToInteger {
    public static void main(String[] args) {

    }

    public int romanToDecimal(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input must be a non-empty Roman numeral.");
        }

        s = s.toUpperCase();
        int total = 0;
        int previous = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = romanVal(s.charAt(i));
            if (val < previous) {
                total -= val;   // subtractive case (e.g., IV, IX, XL, XC, CD, CM)
            } else {
                total += val;   // normal additive case
            }
            previous = val;
        }

        if (total < 1 || total > 3999) {
            throw new IllegalArgumentException("Roman numeral value out of range (1..3999).");
        }
        return total;
    }

    private int romanVal(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid Roman symbol: " + c);
        };
    }
}
