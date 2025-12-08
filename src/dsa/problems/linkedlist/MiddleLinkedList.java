package dsa.problems.linkedlist;

/**
 * Find Middle Node of Linked List
 * <a href="https://gemini.google.com/share/42e4ca17e0c9">Gemini Link</a>
 */
public class MiddleLinkedList {

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers
        ListNode slow = head; // The Tortoise (moves 1 step)
        ListNode fast = head; // The Hare (moves 2 steps)

        // Loop as long as 'fast' has a place to jump to.
        // We check fast != null (in case list length is even and it jumped to null)
        // We check fast.next != null (to ensure we can jump 2 steps)
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move 1 step
            fast = fast.next.next;  // Move 2 steps
        }

        // When fast reaches the end, slow is exactly in the middle
        return slow;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Odd number of nodes ---");
        int[] input1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(input1);
        System.out.print("Input List: ");
        printList(head1);

        ListNode middle1 = middleNode(head1);
        System.out.print("Middle Node to End: ");
        printList(middle1); // Expected: [3, 4, 5]

        System.out.println("\n--- Test Case 2: Even number of nodes ---");
        int[] input2 = {1, 2, 3, 4, 5, 6};
        ListNode head2 = createList(input2);
        System.out.print("Input List: ");
        printList(head2);

        ListNode middle2 = middleNode(head2);
        System.out.print("Middle Node to End: ");
        printList(middle2); // Expected: [4, 5, 6]

        System.out.println("\n--- Test Case 3: Single node ---");
        int[] input3 = {1};
        ListNode head3 = createList(input3);
        System.out.print("Input List: ");
        printList(head3);

        ListNode middle3 = middleNode(head3);
        System.out.print("Middle Node to End: ");
        printList(middle3); // Expected: [1]
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

    // Helper to print list from a specific node to the end
    public static void printList(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(", ");
            node = node.next;
        }
        System.out.println("]");
    }

}
