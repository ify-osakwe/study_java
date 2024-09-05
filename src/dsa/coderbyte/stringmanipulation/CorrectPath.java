package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE CORRECT PATH CHALLENGE                 *
 *                                                              *
 * Problem Statement                                            *
 * Have the function CorrectPath(str) read the str parameter    *
 * being passed, which will represent the movements made in a   *
 * 5x5 grid of cells starting from the top left position. The   *
 * characters in the input string will be entirely composed     *
 * of: r, l, u, d, ?. Each of the characters stand for the      *
 * direction to take within the grid,                           *
 * for example: r = right, l = left, u = up, d = down. Your goal*
 * is to determine what characters the question marks should be *
 * in order for a path to be created to go from the top left of *
 * the grid all the way to the bottom right without touching    *
 * previously travelled on cells in the grid.                   *
 *                                                              *
 * For example: if str is "r?d?drdd" then your program should   *
 * output the final correct string that will allow a path to be *
 * formed from the top left of a 5x5 grid to the bottom right.  *
 * For this input, your program should therefore return the     *
 * string rrdrdrdd. There will only ever be one correct path &  *
 * there will always be at least one question mark within the   *
 * input string.                                                *
 *                                                              *
 * Examples                                                     *
 * Input 1: "???rrurdr?"                                        *
 * Output 1: dddrrurdrd                                         *
 *                                                              *
 * Input 2: "drdr??rrddd?"                                      *
 * Output 2: drdruurrdddd                                       *
 ***************************************************************/
public class CorrectPath {
    public static void main(String[] args) {
        System.out.println(correctPath("???rrurdr?")); // Output: dddrrurdrd
        System.out.println(correctPath("drdr??rrddd?")); // Output: drdruurrdddd
    }

    public static String correctPath(String str) {
        char[] path = str.toCharArray();
        int x = 0, y = 0;
        int questionMarks = 0;

        // Calculate current position and count '?'
        for (char ch : path) {
            switch (ch) {
                case 'r': x++; break;
                case 'l': x--; break;
                case 'u': y--; break;
                case 'd': y++; break;
                case '?': questionMarks++; break;
            }
        }

        // Determine how many moves are needed
        int rightNeeded = 4 - x;
        int downNeeded = 4 - y;

        // Replace '?' with the correct moves
        for (int i = 0; i < path.length; i++) {
            if (path[i] == '?') {
                if (rightNeeded > 0) {
                    path[i] = 'r';
                    rightNeeded--;
                } else if (downNeeded > 0) {
                    path[i] = 'd';
                    downNeeded--;
                } else if (x > 0) {
                    path[i] = 'l';
                    x--;
                } else if (y > 0) {
                    path[i] = 'u';
                    y--;
                }
            }
        }

        return new String(path);
    }
}
