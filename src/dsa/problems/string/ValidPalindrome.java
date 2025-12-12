package dsa.problems.string;

/**
 * Valid Palindrome
 * <a href="https://gemini.google.com/share/542a7956ca8e">Gemini Link</a>
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Edge case: empty string is a valid palindrome
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // 1. Move left pointer forward if current character is not alphanumeric
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            }
            // 2. Move right pointer backward if current character is not alphanumeric
            else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            }
            // 3. Both characters are alphanumeric, compare them
            else {
                // Convert both to lowercase for case-insensitive comparison
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false; // Mismatch found
                }
                // Characters match, move both pointers inward
                left++;
                right--;
            }
        }

        // If loop completes without returning false, it is a palindrome
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        String input1 = "A man, a plan, a canal: Panama";
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Output: " + isPalindrome(input1)); // Expected: true
        System.out.println();

        // Test Case 2
        String input2 = "race a car";
        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Output: " + isPalindrome(input2)); // Expected: false
        System.out.println();

        // Test Case 3
        String input3 = " ";
        System.out.println("Input: \"" + input3 + "\"");
        System.out.println("Output: " + isPalindrome(input3)); // Expected: true
        System.out.println();

        // Additional Test Case: Numbers
        String input4 = "0P";
        System.out.println("Input: \"" + input4 + "\"");
        System.out.println("Output: " + isPalindrome(input4)); // Expected: false
    }
}
