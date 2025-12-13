package dsa.problems.stack;

import java.util.Stack;

/**
 * Designing a Min Stack
 * <a href="https://gemini.google.com/share/285d719b8f84">Gemini Link</a>
 */
class MinStack {

    // Main stack to store all elements
    private Stack<Integer> stack;

    // Auxiliary stack to store the minimums
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // Always push to the main stack
        stack.push(val);

        // Push to minStack if it is empty OR
        // if the new value is smaller than or equal to the current minimum.
        // The '<=' is crucial to handle duplicate minimums correctly.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // We use pop() which returns the value so we can check it
        int val = stack.pop();

        // If the value we just removed is the same as the current minimum,
        // we must remove it from the minStack as well.
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        System.out.println("Initializing MinStack...");
        MinStack minStack = new MinStack();

        System.out.println("Pushing -2");
        minStack.push(-2);

        System.out.println("Pushing 0");
        minStack.push(0);

        System.out.println("Pushing -3");
        minStack.push(-3);

        // Expected: -3
        System.out.println("getMin() (Expected -3): " + minStack.getMin());

        System.out.println("Popping top element...");
        minStack.pop();

        // Expected: 0 (Since -3 was popped, 0 is now top)
        System.out.println("top() (Expected 0): " + minStack.top());

        // Expected: -2 (Since -3 was popped, the previous min -2 is restored)
        System.out.println("getMin() (Expected -2): " + minStack.getMin());
    }
}
