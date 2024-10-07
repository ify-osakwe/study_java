package playground.bcs;

public class StackImpl {
    private static final int MAX = 5;  // Maximum size of the stack
    private final int[] array;  // Array to store stack elements
    private int topIndex;  // Index of the top element

    // Constructor to initialize the stack
    public StackImpl() {
        array = new int[MAX];
        topIndex = -1;
    }

    // Function to check if the stack is empty
    public boolean stackEmpty() {
        return topIndex == -1;
    }

    // Function to check if the stack is full
    public boolean stackFull() {
        return topIndex == MAX - 1;
    }

    // Function to push an integer onto the stack
    public int push(int value) {
        if (stackFull() || value < 0) {
            return -1;  // Stack is full or value is negative
        }
        array[++topIndex] = value;
        return value;
    }

    // Function to pop the top integer from the stack
    public int pop() {
        if (stackEmpty()) {
            return -1;  // Stack is empty
        }
        return array[topIndex--];
    }

    // Main function to test the stack implementation
    public static void main(String[] args) {
        StackImpl s = new StackImpl();

        // Test stackEmpty function
        System.out.println("Stack is empty: " + s.stackEmpty());

        // Test push function
        System.out.println("Pushing 10: " + s.push(10));
        System.out.println("Pushing 20: " + s.push(20));
        System.out.println("Pushing -5 (invalid): " + s.push(-5));  // Negative value, should return -1
        System.out.println("Pushing 30: " + s.push(30));
        System.out.println("Pushing 40: " + s.push(40));
        System.out.println("Pushing 50: " + s.push(50));
        System.out.println("Pushing 60 (stack full): " + s.push(60));  // Stack is full, should return -1

        // Test stackFull function
        System.out.println("Stack is full: " + s.stackFull());

        // Test pop function
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping (empty stack): " + s.pop());  // Stack is empty, should return -1

        // Test stackEmpty function after popping all elements
        System.out.println("Stack is empty: " + s.stackEmpty());
    }
}
