package playground;

public class StringChallenge1 {
    public static void main(String[] args) {
        System.out.println(stringChallenge("224.315.218")); // Output: true
        System.out.println(stringChallenge("11.124.667"));   // Output: false
        System.out.println(stringChallenge("114.568.112"));  // Output: true
    }

    /*
     * write a function in Java - StringChallenge(str) return type is String
     * it takes the str parameter being passed and determine if it is a valid
     * serial number with the following constraints
     *
     * 1. it needs to contain three sets each with three digits
     * (1 through 9) separated by a period
     * 2. the first set of digits must add up to an even number
     * 3. the second set of digits must add up to an odd number.
     * 4. the last digit in each set must be larger than the
     * two previous digits in the same set
     *
     * if all the above constraints are met within the string,
     * then the code should return the string - true -
     * otherwise the code return the string - false.
     * for example: if str is - 224.315.218 - then the function returns - true
     *
     * Example 1
     * input: 11.124.667
     * output: false
     *
     * Example 2
     * input: 114.568.112
     * output: true
     */
    public static String stringChallenge(String str) {
        // Split the string by periods to get the sets of digits
        String[] sets = str.split("\\.");

        // Check if there are exactly 3 sets
        if (sets.length != 3) return "false";

        // Iterate through each set of digits
        for (String set : sets) {
            // Ensure that each set contains exactly 3 digits
            if (set.length() != 3 || !set.matches("[1-9]+")) {
                return "false";
            }
        }

        // Convert the sets to integers
        int[] set1 = new int[]{Character.getNumericValue(sets[0].charAt(0)),
                Character.getNumericValue(sets[0].charAt(1)),
                Character.getNumericValue(sets[0].charAt(2))};

        int[] set2 = new int[]{Character.getNumericValue(sets[1].charAt(0)),
                Character.getNumericValue(sets[1].charAt(1)),
                Character.getNumericValue(sets[1].charAt(2))};

        int[] set3 = new int[]{Character.getNumericValue(sets[2].charAt(0)),
                Character.getNumericValue(sets[2].charAt(1)),
                Character.getNumericValue(sets[2].charAt(2))};

        // Check the sum of the digits in the first set is even
        if ((set1[0] + set1[1] + set1[2]) % 2 != 0) {
            return "false";
        }

        // Check the sum of the digits in the second set is odd
        if ((set2[0] + set2[1] + set2[2]) % 2 != 1) {
            return "false";
        }

        // Check that the last digit in each set is greater than the previous two digits
        boolean check1 = set1[2] > set1[0] && set1[2] > set1[1];
        boolean check2 = set2[2] > set2[0] && set2[2] > set2[1];
        boolean check3 = set3[2] > set3[0] && set3[2] > set3[1];
        if (!check1 || !check2 || !check3) return "false";

        // If all checks pass, return true
        return "true";
    }
}
