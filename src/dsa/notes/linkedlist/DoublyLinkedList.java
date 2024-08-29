package dsa.notes.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Iterable interface implementation
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private DoubleNode<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    // String representation of the linked list
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        DoubleNode<T> currentNode = head;

        while (currentNode != null) {
            result.append(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null) {
                result.append("~~");
            }
        }
        return result.toString();
    }

    // Return the length of the linked list
    public int getLength() {
        int length = 0;
        DoubleNode<T> currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    // Get item at the given index
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("List index out of range");
        }
        DoubleNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    // Set item at the given index
    public void set(int index, T data) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("List index out of range");
        }
        DoubleNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = data;
    }

    // Insert a node at a given index
    public void insertNth(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("List index out of range");
        }

        DoubleNode<T> newNode = new DoubleNode<>(data);

        if (size == 0) {  // inserting into an empty list
            head = tail = newNode;
        } else if (index == 0) {  // inserting at head
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) {  // inserting at tail
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {  // inserting at any other index
            DoubleNode<T> currentNode = getNodeAtIndex(index);
            newNode.next = currentNode;
            newNode.previous = currentNode.previous;
            if (currentNode.previous != null) {
                currentNode.previous.next = newNode;
            }
            currentNode.previous = newNode;
        }
        size++;
    }

    // Delete a node at a given index
    public void deleteNth(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List index out of range");
        }

        if (size == 1) {  // deleting a 1-item list
            head = tail = null;
        } else if (index == 0) {  // deleting at head
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (index == size - 1) {  // deleting at tail
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {  // deleting at any other index
            DoubleNode<T> currentNode = getNodeAtIndex(index);
            if (currentNode.previous != null) {
                currentNode.previous.next = currentNode.next;
            }
            if (currentNode.next != null) {
                currentNode.next.previous = currentNode.previous;
            }
        }
        size--;
    }

    // Get the node at a given index
    public DoubleNode<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List index out of range");
        }
        DoubleNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    // Insert a node at the beginning (push)
    public void push(T data) {
        insertNth(0, data);
    }

    // Insert a node at the end (append)
    public void append(T data) {
        insertNth(size, data);
    }

    // Delete the node at the beginning (deleteHead)
    public void deleteHead() {
        deleteNth(0);
    }

    // Delete the node at the end (deleteTail)
    public void deleteTail() {
        deleteNth(size - 1);
    }

    // Return the size of the list
    public int size() {
        return size;
    }

    // Print all elements of the doubly linked list
    public void print() {
        DoubleNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Print all elements in reverse order (first version)
    public void printReverse() {
        DoubleNode<T> currentNode = head;
        // Collect nodes in a list
        List<DoubleNode<T>> nodes = new ArrayList<>();
        while (currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        // Print nodes in reverse
        for (int i = nodes.size() - 1; i >= 0; i--) {
            System.out.print(nodes.get(i).data + " ");
        }
        System.out.println();
    }

    // Print all elements in reverse order (second version)
    public void printReverse2() {
        DoubleNode<T> currentNode = tail;
        // Traverse from the tail to the head
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.previous;
        }
        System.out.println();
    }
}

