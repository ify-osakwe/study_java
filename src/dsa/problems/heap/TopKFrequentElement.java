package dsa.problems.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Top K Frequent Element
 * <a href="https://gemini.google.com/share/ac9805dd59d4">Gemini Link</a>
 */
public class TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build the frequency map
        // Key = number, Value = frequency
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // Step 2: Initialize the Min-Heap
        // The comparator compares the frequencies derived from the map.
        // (a, b) -> map.get(a) - map.get(b) ensures ascending order of frequency.
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> countMap.get(n1) - countMap.get(n2)
        );

        // Step 3: Iterate over the unique numbers in the map
        for (int n : countMap.keySet()) {
            heap.add(n);

            // If the heap size exceeds k, remove the element with the
            // lowest frequency (the head of the queue).
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Convert the heap to an array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // Note: We are not checking if heap is empty because constraints
            // guarantee k is within range [1, unique elements].
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        printResult(1, nums1, k1);

        // Example 2
        int[] nums2 = {1};
        int k2 = 1;
        printResult(2, nums2, k2);

        // Example 3
        int[] nums3 = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k3 = 2;
        printResult(3, nums3, k3);

    }

    private static void printResult(int exampleId, int[] nums, int k) {
        System.out.println("Example " + exampleId + ":");
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
        long startTime = System.nanoTime();
        int[] result = topKFrequent(nums, k);
        long endTime = System.nanoTime();
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        System.out.println("--------------------------------------------------");
    }
}
