package dsa.coderbyte.stringmanipulation;

/*
 *             CODERBYTE TIME CONVERT CHALLENGE                 *
 *                                                              *
 * Problem Statement                                            *
 * Have the function TimeConvert(num) take the num parameter    *
 * being passed and return the number of hours and minutes the  *
 * parameter converts to (ie. if num = 63 then the output       *
 * should be 1:3). Separate the number of hours and minutes     *
 * with a colon.                                                *
 *                                                              *
 * Examples                                                     *
 * Input 1: 126                                                 *
 * Output 1: 2:6                                                *
 *                                                              *
 * Input 2: 45                                                  *
 * Output 2: 0:45                                               *
 *                                                              *
 * Solution Efficiency                                          *
 * The user scored higher than 29.1% of users who solved this   *
 * challenge.                                                   *
 ***************************************************************/
public class TimeConvert {
    public static void main(String[] args) {
        System.out.println(timeConvert(126));  // Output: 2:6
        System.out.println(timeConvert(45));   // Output: 0:45
        System.out.println(timeConvert(63));   // Output: 1:3
    }

    public static String timeConvert(int num) {
        int hours = num / 60;  // Calculate the number of hours

        int minutes = num % 60; // Calculate the remaining minutes

        // Return the result in "hours:minutes" format
        return hours + ":" + minutes;
    }
}
