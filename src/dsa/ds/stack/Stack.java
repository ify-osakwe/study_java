package dsa.ds.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stack<T> {
    /**
     * When a list is declared as final, it means that the reference
     * to the list cannot be changed. However, the contents of the list
     * can still be modified. This is because final prevents reassignment
     * of the variable but does not make the object it refers to immutable.
     */
    private final List<T> storage;

    public Stack() {
        this.storage = new ArrayList<>();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return this.storage.isEmpty();
    }

    // Return the size of the stack
    public int size() {
        return this.storage.size();
    }

    // Push an item onto the stack
    public void push(T data) {
        this.storage.add(data);
    }

    // Pop an item off the stack
    public T pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.storage.remove(this.storage.size() - 1);
        }
    }

    // Peek at the topmost item of the stack
    public T peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.storage.get(this.storage.size() - 1);
        }
    }

    // Check if an item is in the stack
    public boolean contains(T item) {
        return this.storage.contains(item);
    }

    // String representation of the stack
    @Override
    public String toString() {
        return storage.toString();
    }
}

class StackUtils {

    public static <T> Stack<T> createStackFromIterable(Collection<T> items) {
        Stack<T> stack = new Stack<>();
        for (T item : items) {
            stack.push(item);
        }
        return stack;
    }
}

