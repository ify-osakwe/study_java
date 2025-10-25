package dsa.ds.linkedlist;

public class DoubleNode<T> {
    T data;
    DoubleNode<T> previous;
    DoubleNode<T> next;

    public DoubleNode(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

