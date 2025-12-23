package dsa.problems.xcoderbyte.stringmanipulation;

/*
 *             CODERBYTE STRING ZIGZAG CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function StringZigzag(strArr) read the array of     *
 * strings stored in strArr, which will contain two elements,   *
 * the first some sort of string and the second element will be *
 * a number ranging from 1 to 6. The number represents how many *
 * rows to print the string on so that it forms a zig-zag       *
 * pattern. For example: if strArr is ["coderbyte", "3"] then   *
 * this word will look like the following if you print it in a  *
 * zig-zag pattern with 3 rows:                                 *
 * Your program should return the word formed by combining the  *
 * characters as you iterate through each row, so for this      *
 * example your program should return the string creoebtdy.     *
 *                                                              *
 * Examples                                                     *
 * Input 1: ["cat", "5"]                                        *
 * Output 1: cat                                                *
 *                                                              *
 * Input 2: ["kaamvjjfl", "4"]                                  *
 * Output 2: kjajfavlm                                          *
 *                                                              *
 ***************************************************************/
public class StringZigZag {
    public static void main(String[] args) {
        System.out.println(stringZigzag(new String[]{"coderbyte", "3"}));  // Output: "creoebtdy"
        System.out.println(stringZigzag(new String[]{"cat", "5"}));        // Output: "cat"
        System.out.println(stringZigzag(new String[]{"kaamvjjfl", "4"}));  // Output: "kjajfavlm"
    }

    public static String stringZigzag(String[] strArr) {
        String str = strArr[0];  // The input string
        int numRows = Integer.parseInt(strArr[1]);  // The number of rows

        // If the number of rows is 1, the output is the original string
        if (numRows == 1 || numRows >= str.length()) {
            return str;
        }

        // Create an array of StringBuilder to store each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = true;

        // Iterate through each character in the input string
        for (char c : str.toCharArray()) {
            // Add the character to the current row
            rows[currentRow].append(c);

            // Determine the next row to move to (zig-zag pattern)
            if (currentRow == 0) {
                goingDown = true;  // Start going down
            } else if (currentRow == numRows - 1) {
                goingDown = false;  // Start going up
            }

            // Move to the next row depending on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one result string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
