package dsa.problems.linkedlist;

/**
 * Reorder List
 * <a href="https://gemini.google.com/share/f944dec60ebb">Gemini Link</a>
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // --- STEP 1: Find the Middle ---
        // We use the slow/fast pointer approach to split the list into two halves.
        ListNode slow = head;
        ListNode fast = head;

        // While fast has room to move two steps
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' is now at the end of the first half.
        // 'secondHalf' starts at slow.next.
        ListNode secondHalf = slow.next;

        // Sever the connection between the two halves
        slow.next = null;

        // --- STEP 2: Reverse the Second Half ---
        // We reverse the second list so we can weave it backwards.
        // Input: 3 -> 4 -> 5 | Output: 5 -> 4 -> 3
        ListNode secondHalfHead = reverse(secondHalf);
        ListNode firstHalfHead = head;

        // --- STEP 3: Merge the Two Lists ---
        // Weave them together: L1 -> L2_rev -> L1_next -> L2_rev_next ...
        while (secondHalfHead != null) {
            // 1. Save the next pointers for both lists so we don't lose track
            ListNode temp1 = firstHalfHead.next;
            ListNode temp2 = secondHalfHead.next;

            // 2. Point current first half node to current second half node
            firstHalfHead.next = secondHalfHead;

            // 3. Point current second half node to the saved next of first half
            secondHalfHead.next = temp1;

            // 4. Move pointers forward for the next iteration
            firstHalfHead = temp1;
            secondHalfHead = temp2;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse the pointer
            prev = curr;                   // Move prev step forward
            curr = nextTemp;               // Move curr step forward
        }

        return prev; // prev is now the new head
    }

    public static void main(String[] args) {

        // Test Case 1: [1, 2, 3, 4]
        // Expected: [1, 4, 2, 3]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Original List 1: " + head1);
        reorderList(head1);
        System.out.println("Reordered List 1: " + head1);
        System.out.println("-----------------------------");

        // Test Case 2: [1, 2, 3, 4, 5]
        // Expected: [1, 5, 2, 4, 3]
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original List 2: " + head2);
        reorderList(head2);
        System.out.println("Reordered List 2: " + head2);
    }
}
