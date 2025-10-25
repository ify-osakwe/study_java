package dsa.ds.heap;

import timBuchalka.UtilsX;

public class TestHeapMax {
    public static void main(String[] args) {
        HeapMax<Integer> heap1 = new HeapMax<>();
        heap1.insert(6);
        heap1.insert(10);
        heap1.insert(15);
        heap1.insert(12);
        System.out.println("Heap-1: " + heap1);

        HeapMax<Integer> heap2 = new HeapMax<>();
        int[] a1 = {103, 9, 1, 7, 11, 15, 25, 201, 209, 107, 5};
        for (int num : a1) {
            heap2.insert(num);
        }
        System.out.println("Heap-2: " + heap2);

        HeapMax<Integer> heap3 = new HeapMax<>();
        int[] a2 = {88, 100, 25, 87, 16, 8, 86, 12, 50, 2, 15, 3};
        for (int num : a2) {
            heap3.insert(num);
        }
        System.out.println("Heap-3: " + heap3);
        UtilsX.newLineSpace();

        // peek operation on heap
        System.out.println("element at top: Heap-1: " + heap1.peek());
        System.out.println("element at top: Heap-2: " + heap2.peek());
        System.out.println("element at top: Heap-3: " + heap3.peek());
        UtilsX.newLineSpace();

        // insert operation on a heap
        heap1.insert(19);
        System.out.println("insert 19 in Heap-1: " + heap1);
        heap2.insert(300);
        System.out.println("insert 300 in Heap-2: " + heap2);
        heap3.insert(105);
        System.out.println("insert 105 in heap3 =" + heap3);

        // remove operation on a heap
        heap1.remove();
        System.out.println("after deletion, Heap-1: " + heap1);
        heap2.remove();
        System.out.println("after deletion, Heap-2: " + heap2);
        heap3.remove();
        System.out.println("after deletion, Heap-3: " + heap3);
    }
}
