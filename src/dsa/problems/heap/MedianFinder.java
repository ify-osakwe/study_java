package dsa.problems.heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    // Max-heap to store the smaller half of the numbers
    private PriorityQueue<Integer> small;
    // Min-heap to store the larger half of the numbers
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        // Initialize max-heap using reverseOrder
        small = new PriorityQueue<>(Collections.reverseOrder());
        // Initialize min-heap (default)
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to max-heap
        small.offer(num);

        // Step 2: Move the largest element of max-heap to min-heap
        // This ensures the element is in the correct half if it's large
        large.offer(small.poll());

        // Step 3: Balance sizes
        // We enforce that small.size() >= large.size()
        // Specifically, small can have at most 1 element more than large
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // If small has more elements, the median is the top of small
        // If sizes are equal, median is the average of the two tops
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        // 1. addNum(1)
        medianFinder.addNum(1);
        System.out.println("Added 1");

        // 2. addNum(2)
        medianFinder.addNum(2);
        System.out.println("Added 2");

        // 3. findMedian() -> Expected 1.5
        System.out.println("Current Median: " + medianFinder.findMedian());

        // 4. addNum(3)
        medianFinder.addNum(3);
        System.out.println("Added 3");

        // 5. findMedian() -> Expected 2.0
        System.out.println("Current Median: " + medianFinder.findMedian());

        // Additional Test Case
        System.out.println("\n--- Additional Test ---");
        medianFinder.addNum(8);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        // Current elements: [1, 2, 3, 4, 5, 8] -> Median should be (3+4)/2 = 3.5
        System.out.println("Added 8, 4, 5. Elements: [1, 2, 3, 4, 5, 8]");
        System.out.println("Current Median: " + medianFinder.findMedian());
    }
}
