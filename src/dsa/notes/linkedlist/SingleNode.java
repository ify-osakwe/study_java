package dsa.notes.linkedlist;

public class SingleNode<T> {
    T value;
    SingleNode<T> next;

    public SingleNode(T value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
