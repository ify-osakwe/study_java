package dsa.coderbyte.stringmanipulation;

import java.util.Stack;

/*
 *             CODERBYTE HTML ELEMENTS CHALLENGE                 *
 *                                                               *
 * Problem Statement                                             *
 * Have the function HTMLElements(str) read the str parameter    *
 * being passed which will be a string of HTML DOM elements and  *
 * plain text. The elements that will be used are: b, i, em,     *
 * div, p.                                                       *
 *                                                               *
 * For example: if str is "<div><b><p>hello world</p></b></div>" *
 * then this string of DOM elements is nested correctly so your  *
 * program should return the string true.                        *
 *                                                               *
 * If a string is not nested correctly, return the first element *
 * encountered where, if changed into a different element, would *
 * result in a properly formatted string. If the string is not   *
 * formatted properly, then it will only be one element that     *
 * needs to be changed.                                          *
 *                                                               *
 * For example: if str is "<div><i>hello</i>world</b>" then your *
 * program should return the string div because if the first     *
 * <div> element were changed into a <b>, the string would be    *
 * properly formatted.                                           *
 *                                                               *
 * Examples                                                      *
 * Input 1: "<div><div><b></b></div></p>"                        *
 * Output 1: div                                                 *
 *                                                               *
 * Input 2: "<div>abc</div><p><em><i>test test test</b></em></p>"*
 * Output 2: i                                                   *
 ****************************************************************/
public class HtmlElements {
    public static void main(String[] args) {
        System.out.println(htmlElements("<div><b><p>hello world</p></b></div>"));  // Output: true
        System.out.println(htmlElements("<div><i>hello</i>world</b>"));            // Output: div
        System.out.println(htmlElements("<div><div><b></b></div></p>"));           // Output: div
        System.out.println(htmlElements("<div>abc</div><p><em><i>test test test</b></em></p>")); // Output: i
    }

    public static String htmlElements(String str) {
        // Define the HTML elements we are checking
        String[] elements = {"b", "i", "em", "div", "p"};

        // Stack to keep track of open elements
        Stack<String> stack = new Stack<>();

        // Iterate through the string and process each tag
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                int endTag = str.indexOf('>', i);
                if (endTag == -1) break; // Invalid if there's no closing '>'

                String tag = str.substring(i + 1, endTag);

                // If it's a closing tag
                if (tag.startsWith("/")) {
                    String closeTag = tag.substring(1);  // Get the actual tag name
                    if (stack.isEmpty() || !stack.peek().equals(closeTag)) {
                        // Return the problematic element that caused the issue
                        return stack.isEmpty() ? closeTag : stack.peek();
                    } else {
                        stack.pop();  // Matching tag found, pop from stack
                    }
                }
                // If it's an opening tag
                else if (isValidTag(tag, elements)) {
                    stack.push(tag);  // Push the opening tag onto the stack
                }
                i = endTag;  // Move the index to the end of the current tag
            }
        }

        // If the stack is empty, it means all tags were properly nested
        return stack.isEmpty() ? "true" : stack.peek();
    }

    // Helper function to check if a tag is valid
    private static boolean isValidTag(String tag, String[] elements) {
        for (String elem : elements) {
            if (tag.equals(elem)) return true;
        }
        return false;
    }
}
