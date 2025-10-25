package dsa.ds.heap;

import timBuchalka.UtilsX;

public class TestHeapMin {
    public static void main(String[] args) {
        HeapMin<Integer> heap1 = new HeapMin<>();
        heap1.insert(12);
        heap1.insert(20);
        heap1.insert(5);
        heap1.insert(25);
        heap1.insert(13);
        System.out.println("Heap-1: " + heap1);

        HeapMin<Integer> heap2 = new HeapMin<>();
        int[] n1 = {1, 2, 25, 7, 17, 36, 3, 19, 100};
        for (int num : n1) {
            heap2.insert(num);
        }
        System.out.println("Heap-2: " + heap2);
        UtilsX.newLineSpace();

        // peek operation on a min-heap
        System.out.println("element at top: Heap-2: " + heap1.peek());
        System.out.println("element at top: Heap-2: " + heap2.peek());
        UtilsX.newLineSpace();

        // Insert operation on a min-heap
        heap1.insert(3);
        System.out.println("insert 3 in Heap-1" + heap1);
        heap2.insert(5);
        System.out.println("insert 5 in Heap-2 =" + heap2);
        UtilsX.newLineSpace();

        // Remove operation on a min-heap
        heap1.remove();
        System.out.println("after deletion, Heap-1: " + heap1);
        heap2.remove();
        System.out.println("after deletion, Heap-2: " + heap2);
    }
}
