package dsa.problems.string;

/**
 * Longest Repeating Character Replacement
 * <a href="https://gemini.google.com/share/1903b89025bd">Gemini Link</a>
 */
public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        int[] charCounts = new int[26]; // array to store frequency of each uppercase character 'A'-'Z'
        int left = 0;
        int maxLength = 0;
        int maxCount = 0; // Tracks the count of the most frequent char in the current window

        // 'right' pointer iterates through the string to expand the window
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            int index = currentChar - 'A';
            charCounts[index]++;

            // Update the most frequent character count seen in the current window
            maxCount = Math.max(maxCount, charCounts[index]);

            // Calculate current window size
            int currentWindowLength = right - left + 1;

            // Check if the window is valid.
            // A window is valid if: (Window Length) - (Most Frequent Char Count) <= k
            // If it's NOT valid, we need to shrink the window from the left.
            if (currentWindowLength - maxCount > k) {
                // Get char at left pointer
                char leftChar = s.charAt(left);

                // Decrement its count
                charCounts[leftChar - 'A']--;

                // Move left pointer forward
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: " + characterReplacement(s1, k1)); // Expected: 4
        System.out.println();

        // Test Case 2
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Test Case 2:");
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: " + characterReplacement(s2, k2)); // Expected: 4
        System.out.println();

        // Test Case 3: All same characters
        String s3 = "AAAA";
        int k3 = 2;
        System.out.println("Test Case 3:");
        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        System.out.println("Output: " + characterReplacement(s3, k3)); // Expected: 4
        System.out.println();

        // Test Case 4: k equals string length
        String s4 = "ABCDE";
        int k4 = 5;
        System.out.println("Test Case 4:");
        System.out.println("Input: s = \"" + s4 + "\", k = " + k4);
        System.out.println("Output: " + characterReplacement(s4, k4)); // Expected: 5
    }
}
