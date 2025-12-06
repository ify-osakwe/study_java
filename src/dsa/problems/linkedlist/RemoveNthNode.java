package dsa.problems.linkedlist;

/**
 * Remove Nth Node in a Linked List
 * <a href="https://gemini.google.com/share/4b938e0bde5e">Gemini Link</a>
 */
public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Create a dummy node.
        // This simplifies edge cases, like removing the very first node (head).
        // If we remove the head, dummy.next will simply point to the new head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. Initialize two pointers starting at the dummy node.
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 3. Move the 'fast' pointer n steps ahead.
        // This creates a gap of 'n' nodes between slow and fast.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 4. Move both pointers one step at a time until 'fast' reaches the end.
        // We stop when fast.next is null, meaning fast is at the last node.
        // Because of the gap, 'slow' will be pointing to the node just BEFORE the target.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 5. Remove the nth node.
        // slow.next is the node we want to remove.
        // We skip it by pointing slow.next to slow.next.next.
        slow.next = slow.next.next;

        // 6. Return the start of the list (dummy.next).
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Case 1: Head = [1,2,3,4,5], n = 2
        System.out.println("Test Case 1:");
        ListNode list1 = buildList(new int[]{1, 2, 3, 4, 5});
        printList("Original", list1);
        ListNode result1 = removeNthFromEnd(list1, 2);
        printList("Modified", result1); // Expected: 1->2->3->5

        // Test Case 2: Head = [1], n = 1
        System.out.println("\nTest Case 2 (Remove Head/Only Node):");
        ListNode list2 = buildList(new int[]{1});
        printList("Original", list2);
        ListNode result2 = removeNthFromEnd(list2, 1);
        printList("Modified", result2); // Expected: Empty

        // Test Case 3: Head = [1, 2], n = 1
        System.out.println("\nTest Case 3 (Remove Tail):");
        ListNode list3 = buildList(new int[]{1, 2});
        printList("Original", list3);
        ListNode result3 = removeNthFromEnd(list3, 1);
        printList("Modified", result3); // Expected: 1
    }

    private static void printList(String label, ListNode head) {
        System.out.print(label + ": [");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(",");
            current = current.next;
        }
        System.out.println("]");
    }

    // Helper to build a linked list from an array
    private static ListNode buildList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}
