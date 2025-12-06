package dsa.problems.linkedlist;

/**
 * Reverse Linked List
 * <a href="https://gemini.google.com/share/b4273da4f303">Gemini Link</a>
 */
public class ReverseLinkedList {

    // Time: O(N) - We visit every node once.
    // Space: O(1) - We only use 3 variables regardless of list size.
    public static ListNode reverseListIterative(ListNode head) {
        // Use three pointers to flip the direction of the list
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Save the next node so we don't lose it
            curr.next = prev;              // 2. Reverse the link (point backwards)
            prev = curr;                   // 3. Move prev forward to current
            curr = nextTemp;               // 4. Move curr forward to next
        }

        // At the end, curr is null, and prev is the new head
        return prev;
    }

    // Time: O(N) - We visit every node.
    // Space: O(N) - The recursion stack uses memory proportional to the length of the list.
    public static ListNode reverseListRecursive(ListNode head) {
        // Base case: If list is empty or has only one node, it's already reversed.
        // This effectively finds the tail of the original list and returns it as the new head.
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive step: Go all the way to the end
        ListNode newHead = reverseListRecursive(head.next);

        // The "Re-wiring" step happening as the recursion stack unwinds:
        // If we are at node 4 -> 5, 'head' is 4. 'head.next' is 5.
        // We want 5 to point back to 4.
        head.next.next = head;

        // We must break the old forward link (4 -> 5) to prevent a cycle (4 <-> 5)
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("--- TEST CASE 1: Standard List ---");
        int[] data1 = {1, 2, 3, 4, 5};

        // Test Iterative
        ListNode list1 = createList(data1);
        printList("Original", list1);
        ListNode result1 = reverseListIterative(list1);
        printList("Reversed (Iterative)", result1);

        System.out.println("\n--- TEST CASE 2: Short List (Recursive Test) ---");
        int[] data2 = {1, 2};

        // Test Recursive
        ListNode list2 = createList(data2);
        printList("Original", list2);
        ListNode result2 = reverseListRecursive(list2);
        printList("Reversed (Recursive)", result2);

        System.out.println("\n--- TEST CASE 3: Empty List ---");
        ListNode list3 = createList(new int[]{});
        printList("Original", list3);
        ListNode result3 = reverseListIterative(list3);
        printList("Reversed", result3);
    }

    // Helper to print the list: 1 -> 2 -> 3 -> null
    public static void printList(String label, ListNode head) {
        System.out.print(label + ": ");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

    // Helper to create a list from an array of integers
    public static ListNode createList(int[] values) {
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
