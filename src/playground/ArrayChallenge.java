package playground;

public class ArrayChallenge {
    public static void main(String[] args) {
        String[] s1 = {"10011", "10100"};
        String[] s2 = {"abcdef", "defabc"};
        String[] s3 = {"house", "hours"};

        System.out.println(arrayChallenge(s1)); // Output: 3
        System.out.println(arrayChallenge(s2)); // Output: 6
        System.out.println(arrayChallenge(s3));   // Output: 2
    }

    /*
    * write a  function ArrayChallenge(strArr) in Java, take the array of strings
    * stored in strArr, which will only contain 2 strings of equal length and return
    * the number of characters at each position that are different between them.
    * For example, if strArr is [house, hours] then your program should return 2.
    * The String will always be of equal length and will only contain certain
    * lowercase characters from the alphabet and numbers
    *
    * Example 1
    * input = new String[] {10011, 10100}
    * output = 3
    *
    * Example 2
    * input = new String[] {abcdef, defabc]
    * output = 6
    */
    public static int arrayChallenge(String[] strArr) {
        // Variable to store the count of differing characters
        int diffCount = 0;

        // Extract the two strings from the array
        String str1 = strArr[0];
        String str2 = strArr[1];

        // Iterate through the characters of the strings
        for (int i = 0; i < str1.length(); i++) {
            // Compare characters at each position
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }
        }

        // Return the count of differing characters
        return diffCount;
    }
}
