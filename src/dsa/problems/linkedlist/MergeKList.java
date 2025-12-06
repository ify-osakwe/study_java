package dsa.problems.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K List
 * <a href="https://gemini.google.com/share/965c289c87d4">Gemini Link</a>
 */
public class MergeKList {

    public static ListNode mergeKLists(ListNode[] lists) {
        // 1. Handle edge cases
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 2. Initialize Min-Heap (PriorityQueue)
        // We define a comparator to sort ListNodes by their 'val'
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // 3. Add the head of each non-empty list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // 4. Create a dummy head to simplify list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 5. Process the heap until empty
        while (!minHeap.isEmpty()) {
            // Extract the smallest node currently available
            ListNode minNode = minHeap.poll();

            // Append to our result list
            current.next = minNode;
            current = current.next;

            // Important: If the extracted node has a next node,
            // add it to the heap so it can be considered next.
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        // Return the list starting after the dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1: lists = [[1,4,5],[1,3,4],[2,6]]
        System.out.println("--- Example 1 ---");
        ListNode l1 = createList(new int[]{1, 4, 5});
        ListNode l2 = createList(new int[]{1, 3, 4});
        ListNode l3 = createList(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode result = mergeKLists(lists);
        System.out.print("Merged List: ");
        printList(result); // Expected: [1, 1, 2, 3, 4, 4, 5, 6]

        // Example 2: lists = []
        System.out.println("\n--- Example 2 ---");
        ListNode[] emptyLists = new ListNode[]{};
        ListNode result2 = mergeKLists(emptyLists);
        System.out.print("Merged List: ");
        printList(result2); // Expected: []

        // Example 3: lists = [[]]
        System.out.println("\n--- Example 3 ---");
        ListNode[] listsWithEmpty = new ListNode[]{null}; // null represents an empty list in the array
        ListNode result3 = mergeKLists(listsWithEmpty);
        System.out.print("Merged List: ");
        printList(result3); // Expected: []
    }

    // Helper to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    // Helper to create a linked list from an array of integers
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }
}
