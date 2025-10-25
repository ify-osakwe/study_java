package dsa.ds.heap;

import java.util.ArrayList;
import java.util.List;


public class HeapMax<T extends Comparable<T>> {
    private final List<T> array;

    public HeapMax() {
        this.array = new ArrayList<>();
    }

    @Override
    public String toString() {
        return array.toString();
    }

    public int size() {
        return array.size();
    }

    private int leftIndex(int index) {
        int leftChildIndex = (2 * index) + 1;
        return leftChildIndex < size() ? leftChildIndex : -1;
    }

    private int rightIndex(int index) {
        int rightChildIndex = (2 * index) + 2;
        return rightChildIndex < size() ? rightChildIndex : -1;
    }

    private int parentIndex(int index) {
        return index > 0 ? (index - 1) / 2 : -1;
    }

    public T peek() {
        if (size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return array.get(0);
    }

    public void insert(T value) {
        array.add(value);
        siftUp(size() - 1);
    }

    private void siftUp(int index) {
        int parentIdx = parentIndex(index);
        while (parentIdx >= 0 && array.get(index).compareTo(array.get(parentIdx)) > 0) {
            swap(index, parentIdx);
            index = parentIdx;
            parentIdx = parentIndex(index);
        }
    }

    public T remove() {
        if (size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T maxValue = array.get(0);
        T lastElement = array.remove(size() - 1);
        if (!array.isEmpty()) {
            array.set(0, lastElement);
            siftDown(0);
        }
        return maxValue;
    }

    /*public T remove() {
        if (size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int lastIndex = size() - 1;
        swap(0, lastIndex);
        T maxValue = array.remove(lastIndex);
        siftDown(0);
        return maxValue;
    }*/

    /**
     * Swaps the current node with its larger child,
     * Repeats until the node is in its proper place.
     */
    private void siftDown(int index) {
        int maxIndex = index;
        int leftChildIndex = leftIndex(index);
        int rightChildIndex = rightIndex(index);

        if (leftChildIndex != -1 && array.get(leftChildIndex).compareTo(array.get(maxIndex)) > 0) {
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex != -1 && array.get(rightChildIndex).compareTo(array.get(maxIndex)) > 0) {
            maxIndex = rightChildIndex;
        }

        if (index != maxIndex) {
            swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }

    /*private void siftDown(int index) {
        while (leftIndex(index) != -1) {
            int leftChildIdx = leftIndex(index);
            int largerChildIdx = leftChildIdx;

            if (rightIndex(index) != -1 && array.get(rightIndex(index)).compareTo(array.get(leftChildIdx)) > 0) {
                largerChildIdx = rightIndex(index);
            }

            if (array.get(index).compareTo(array.get(largerChildIdx)) >= 0) {
                break;
            }

            swap(index, largerChildIdx);
            index = largerChildIdx;
        }
    }*/

    private void swap(int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
