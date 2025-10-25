package dsa.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapMin<T extends Comparable<T>> {
    private final List<T> array;

    public HeapMin() {
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
        return array.isEmpty() ? null : array.get(0);
    }

    public void insert(T value) {
        array.add(value);
        siftUp(size() - 1);
    }

    private void siftUp(int index) {
        int parentIdx = parentIndex(index);
        while (parentIdx >= 0 && array.get(index).compareTo(array.get(parentIdx)) < 0) {
            swap(index, parentIdx);
            index = parentIdx;
            parentIdx = parentIndex(parentIdx);
        }
    }

    public T remove() {
        if (array.isEmpty()) {
            return null;
        }
        int lastIndex = size() - 1;
        swap(0, lastIndex);
        T minValue = array.remove(lastIndex);
        siftDown(0);
        return minValue;
    }

    private void siftDown(int index) {
        while (leftIndex(index) != -1) {
            int leftChildIdx = leftIndex(index);
            int smallerChildIdx = leftChildIdx;

            if (rightIndex(index) != -1 && array.get(rightIndex(index)).compareTo(array.get(leftChildIdx)) < 0) {
                smallerChildIdx = rightIndex(index);
            }

            if (array.get(index).compareTo(array.get(smallerChildIdx)) <= 0) {
                break;
            }

            swap(index, smallerChildIdx);
            index = smallerChildIdx;
        }
    }

    private void siftDown2(int index) {
        while (true) {
            int leftChildIndex = leftIndex(index);
            int rightChildIndex = rightIndex(index);
            if (leftChildIndex == -1) {
                break;
            }

            int smallerChildIndex = leftChildIndex;
            if (rightChildIndex != -1 && array.get(rightChildIndex).compareTo(array.get(leftChildIndex)) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (array.get(index).compareTo(array.get(smallerChildIndex)) <= 0) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void swap(int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
