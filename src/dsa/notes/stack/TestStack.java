package dsa.notes.stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println("stack: " + stack);
        System.out.println("is stack empty: " + stack.isEmpty() + "\n");

        stack.push("Dora");
        stack.push("Abel");
        stack.push("Tory");
        stack.push("Karl");
        stack.push("Cory");
        stack.push("Earl");
        System.out.println("stack: " + stack);

        System.out.println("stack size: " + stack.size());
        System.out.println("topmost item: " + stack.peek());
        System.out.println("is 'Abel' in stack: " + stack.contains("Abel") + "\n");

        System.out.println("stack: " + stack);
        stack.pop();
        stack.pop();
        System.out.println("stack: after popping twice: " + stack);
    }
}
