package dsa.problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * <a href="https://gemini.google.com/share/a4d8a99d4bbf">Gemini Link</a>
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            // Step 1: Check for divisibility by both 3 and 5 (15)
            // This must be checked first to prevent 15 from being caught by the % 3 check.
            if (i % 15 == 0) {
                answer.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            else if (i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(String.valueOf(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test Case 1: n = 3
        System.out.println("Input: n = 3");
        System.out.println("Output: " + fizzBuzz(3));
        System.out.println();

        // Test Case 2: n = 5
        System.out.println("Input: n = 5");
        System.out.println("Output: " + fizzBuzz(5));
        System.out.println();

        // Test Case 3: n = 15
        System.out.println("Input: n = 15");
        System.out.println("Output: " + fizzBuzz(15));
    }
}
