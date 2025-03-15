package dsa.notes.linkedlist;

import java.util.Iterator;
import java.util.Stack;

public class SinglyLinkedList<T> implements Iterable<T> {
    private SingleNode<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private SingleNode<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                var data = currentNode.value;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

//    public int size() {
//        int count = 0;
//        for (int value : this) {
//            count++;
//        }
//        return count;
//    }

    public int size() {
        int count = 0;
        SingleNode<T> currentNode = head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        SingleNode<T> currentNode = head;

        while (currentNode != null) {
            result.append(currentNode.value);
            currentNode = currentNode.next;
            if (currentNode != null) {
                result.append("--");
            }
        }

        return result.toString();
    }

    // Indexing Support. Used to get a node at the given index
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("List index out of range");
        }

        // Traverse the linked list to find the node at the given index
        SingleNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    // Indexing Support. Used to change the data of a node at the given index
    public void set(int index, T data) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        SingleNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.value = data;
    }

    // Check if Linked List is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert a node at a given index
    public void insertNth(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        SingleNode<T> newNode = new SingleNode<T>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            SingleNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    // Delete a node at a given index
    public void deleteNth(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            head = head.next;
        } else {
            SingleNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    // Returns the node at the given index.
    // Similar to implementation of get() function
    public SingleNode<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        SingleNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    // Insert a node at the beginning of the Linked List
    // another name is 'insert_head()' function'
    public void push(T data) {
        insertNth(0, data);
    }

    // Insert a node at the end of the Linked List
    // another name is 'insert_tail()' function
    public void append(T data) {
        insertNth(size(), data);
    }

    // Delete Node at the beginning of the Linked List
    public void deleteHead() {
        deleteNth(0);
    }

    // Delete Node at the end of the Linked List
    public void deleteTail() {
        deleteNth(size() - 1);
    }

    // Prints all elements of a Linked List
    public void print() {
        SingleNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Reverse the list. Prints all element in reverse
    // THIS IMPLEMENTATION USES A STACK
    public void printReverse() {
        Stack<SingleNode<T>> stack = new Stack<>();
        SingleNode<T> currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }
        System.out.println();
    }

    // Returns the last element in the list
    public SingleNode<T> lastElement() {
        SingleNode<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * Returns the node at the middle index.
     * In the while loop, you bind the next node to fast. If there's a next node,
     * you update fast to the next node of fast, effectively traversing down the
     * list twice. slow is updated only once.
     * This is also known as the RUNNER TECHNIQUE.
     * O(n) time complexity since the list is traversed in a single pass.
     */
    public SingleNode<T> getMiddleNode() {
        SingleNode<T> slowPointer = head;
        SingleNode<T> fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    // Function to merge two sorted linked lists.
    // @:return: the head of the merged linked list
    /*public SingleNode<T> mergeTwoLists(SingleNode<T> head1, SingleNode<T> head2) {
        SingleNode dummyNode = new SingleNode<Integer>(-1); // dummy node
        SingleNode<T> tail = dummyNode;
        while (true) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }
            if (head1.value <= head2.value) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return dummyNode.next;
    }*/


}
