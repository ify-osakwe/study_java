package dsa.coderbyte.stringmanipulation;

/*
 *                  CODERBYTE FIZZBUZZ CHALLENGE                *
 *                                                              *
 * Problem Statement                                            *
 * Have the function FizzBuzz(num) take the num parameter being *
 * passed and return all the numbers from 1 to num separated by *
 * spaces but replace every number that is divisible by 3       *
 * with the word "Fizz", replace every number that is divisible *
 * by 5 with the word "Buzz", & every number that is divisible  *
 * by both 3 and 5 with the word "FizzBuzz".                    *
 * For example: if num is 16, the code should return the string *
 * 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 *
 * The input will be within the range 1 - 50.                   *
 *                                                              *
 * Examples                                                     *
 * Input 1: 3                                                   *
 * Output 1: "1 2 Fizz"                                         *
 *                                                              *
 * Input 2: 8                                                   *
 * Output 2: "1 2 Fizz 4 Buzz Fizz 7 8"                         *
 ***************************************************************/
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(3)); // Output 1: "1 2 Fizz"
        System.out.println(fizzBuzz(8)); // Output 2: "1 2 Fizz 4 Buzz Fizz 7 8"
        System.out.println(fizzBuzz(16));
        // 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16
    }

    public static String fizzBuzz(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int digit = 1; digit <= num; digit++) {
            if (digit % 3 == 0 && digit % 5 == 0) {
                stringBuilder.append("FizzBuzz ");
            } else if (digit % 5 == 0) {
                stringBuilder.append("Buzz ");
            } else if (digit % 3 == 0) {
                stringBuilder.append("Fizz ");
            } else {
                stringBuilder.append(digit).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
