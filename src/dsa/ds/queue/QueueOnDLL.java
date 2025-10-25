package dsa.ds.queue;

import dsa.ds.linkedlist.DoublyLinkedList;

/**
 * DLLs have immediate access to both the front and end of the list, they can insert
 * data on either side at O(1) as well as delete data on either side at O(1).
 * This makes DLLs a perfect underlying data structure for a queue.
 */
public class QueueOnDLL<T> {
    private final DoublyLinkedList<T> list;

    public QueueOnDLL() {
        this.list = new DoublyLinkedList<>();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Add element at the back of the queue.
     * Implementation - add element at the tail of the DLL.
     * O(1) Time.
     */
    public void enqueue(T element) {
        list.append(element);
    }

    /**
     * Remove element at the front of the queue.
     * Implementation - remove element at the head of the DLL.
     * O(1) Time.
     */
    public void dequeue() {
        if (isEmpty()) {
           throw new IllegalStateException("Queue is empty");
        } else {
            list.deleteHead();
        }
    }

    /**
     * Return the element at the front of the queue without removing it.
     * O(1) Time.
     */
    public T peek() {
        return list.get(0);
    }


}
