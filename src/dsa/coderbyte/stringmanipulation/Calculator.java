package dsa.coderbyte.stringmanipulation;

import java.util.Stack;

/*
 *             CODERBYTE CALCULATOR CHALLENGE                   *
 *                                                              *
 * Problem Statement                                            *
 * Have the function Calculator(str) take the str parameter     *
 * being passed and evaluate the mathematical expression within *
 * in. For example, if str were "2+(3-1)*3" the output should   *
 * be 8. Another example: if str were "(2-0)(6/2)" the output   *
 * should be 6. There can be parenthesis within the string so   *
 * you must evaluate it properly according to the rules of      *
 * arithmetic.                                                  *
 * The string will contain the operators: +, -, /, *, (, and ). *
 * If you have a string like this: #/#*# or #+#(#)/#, then      *
 * evaluate from left to right. So divide then multiply, and    *
 * for the second one multiply, divide, then add.               *
 * The evaluations will be such that there will not be any      *
 * decimal operations, so you do not need to account for        *
 * rounding and whatnot.                                        *
 *                                                              *
 * Examples                                                     *
 * Input 1: "6*(4/2)+3*1"                                       *
 * Output 1: 15                                                 *
 *                                                              *
 * Input 2: "6/3-1"                                             *
 * Output 2: 1
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println(calculate("2+(3-1)*3"));  // Output: 8
        System.out.println(calculate("(2-0)*(6/2)"));  // Output: 6
        System.out.println(calculate("6*(4/2)+3*1"));  // Output: 15
        System.out.println(calculate("6/3-1"));  // Output: 1
    }

    public static int calculate(String str) {
        if (str == null || str.isEmpty()) return 0;

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int len = str.length();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                int val = 0;
                while (i < len && Character.isDigit(str.charAt(i))) {
                    val = val * 10 + (str.charAt(i) - '0');
                    i++;
                }
                values.push(val);
                i--; // step back one index as the loop will increment it
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // remove '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
//        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
//            return false;
//        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    private static int applyOp(char op, int b, int a) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                yield a / b;
            }
            default -> 0;
        };
    }
}
