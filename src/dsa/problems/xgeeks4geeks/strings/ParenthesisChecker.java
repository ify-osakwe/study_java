package dsa.problems.xgeeks4geeks.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/*
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']',
verify the validity of the arrangement.
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.

Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.

Input: s = "([]"
Output: False
Explanation: The expression is not balanced as there is a missing ')' at the end.

Input: s = "([{]})"
Output: False
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.

Constraints:
1 ≤ s.size() ≤ 10^6
s[i] ∈ {'{', '}', '(', ')', '[', ']'}
*/
public class ParenthesisChecker {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(String str) {
        Map<Character, Character> PAIR = Map.of(')', '(', ']', '[', '}', '{');

        Deque<Character> stack = new ArrayDeque<>(str.length());
        for (char ch : str.toCharArray()) {
            if (PAIR.containsValue(ch)) {
                stack.push(ch);
            } else {
                char need = PAIR.getOrDefault(ch, '\0');
                if (need == '\0' || stack.isEmpty() || stack.pop() != need) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
