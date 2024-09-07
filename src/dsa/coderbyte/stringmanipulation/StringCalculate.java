package dsa.coderbyte.stringmanipulation;

import java.util.Stack;

/*
 *             CODERBYTE STRING CALCULATE CHALLENGE             *
 *                                                              *
 * Problem Statement                                            *
 * Have the function StringCalculate(str) take the str parameter*
 * being passed and evaluate the mathematical expression within *
 * in. The double asterisks (**) represent exponentiation.      *
 * For example, if str were "(2+(3-1)*3)**3" the output should  *
 * be 512. Another example: if str is "(2-0)(6/2)" the output   *
 * should be 6. There can be parenthesis within the string so   *
 * you must evaluate it properly according to the rules of      *
 * arithmetic.                                                  *
 * The string will contain the operators: +, -, /, *, (, ),     *
 * and **. If you have a string like this: #/#*# or #+#(#)/#,   *
 * then evaluate from left to right. So divide then multiply,   *
 * and for the second one multiply, divide, then add.           *
 * The evaluations will be such that there will not be any      *
 * decimal operations, so you do not need to account for        *
 * rounding.                                                    *
 *                                                              *
 * Examples                                                     *
 * Input 1: "6*(4/2)+3*1"                                       *
 * Output 1: 15                                                 *
 *                                                              *
 * Input 2: "100*2**4"                                          *
 * Output 2: 1600                                               *
 *                                                              *
 ***************************************************************/
public class StringCalculate {
    public static void main(String[] args) {
        System.out.println(stringCalculate("6*(4/2)+3*1"));  // Output: 15
        System.out.println(stringCalculate("100*2**4"));     // Output: 1600
        System.out.println(stringCalculate("(2+(3-1)*3)**3"));  // Output: 512
        System.out.println(stringCalculate("(2-0)(6/2)"));   // Output: 6
    }

    public static int stringCalculate(String str) {
        // Step 1: Replace double asterisks (**) with ^ for easier parsing
        str = str.replace("**", "^");

        // Step 2: Handle implicit multiplication like (2)(6/2) -> (2)*(6/2)
        str = str.replaceAll("\\)\\(", ")*(");
        // Adds multiplication between two adjacent parentheses

        str = str.replaceAll("(\\d)\\(", "$1*(");
        // Adds multiplication between number and opening parenthesis

        str = str.replaceAll("\\)(\\d)", ")*$1");
        // Adds multiplication between closing parenthesis and number

        // Step 3: Evaluate the expression
        return evaluateExpression(str);
    }

    // Function to evaluate the expression
    private static int evaluateExpression(String expression) {
        // Using a stack to evaluate the expression
        Stack<Integer> nums = new Stack<>();  // Stack to store numbers
        Stack<Character> ops = new Stack<>(); // Stack to store operators
        int num = 0;
        boolean hasNum = false;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                hasNum = true;
            } else {
                if (hasNum) {
                    nums.push(num);
                    num = 0;
                    hasNum = false;
                }

                if (c == '(') {
                    ops.push(c);
                } else if (c == ')') {
                    while (ops.peek() != '(') {
                        nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                    }
                    ops.pop(); // Remove '(' from ops stack
                } else if (isOperator(c)) {
                    while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                        nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                    }
                    ops.push(c);
                }
            }
        }

        if (hasNum) nums.push(num); // Push the last number if it was left

        while (!ops.isEmpty()) {
            nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Function to define precedence of operators
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }

    // Function to apply an operator to two numbers
    private static int applyOp(char op, int b, int a) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '^' -> (int) Math.pow(a, b);
            default -> 0;
        };
    }
}
