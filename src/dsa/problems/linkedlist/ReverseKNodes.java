package dsa.problems.linkedlist;

/**
 * Reverse K Nodes
 * <a href="https://gemini.google.com/share/963fba1e907b">Gemini Link</a>
 */
public class ReverseKNodes {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 1. Create a dummy node to handle edge cases where the head changes.
        ListNode dummy = new ListNode(0, head);

        // groupPrev points to the node immediately before the group we are interested in.
        // Initially, it points to the dummy.
        ListNode groupPrev = dummy;

        while (true) {
            // 2. Check if we have k nodes left to reverse
            ListNode kth = getKthNode(groupPrev, k);

            if (kth == null) {
                // Not enough nodes left to form a group of k.
                // We leave the remaining nodes as they are and break.
                break;
            }

            // 3. Define the boundaries of our group
            ListNode groupNext = kth.next; // The node immediately after our group

            // "prev" and "curr" are used for the standard reversal logic inside the group
            // We initialize prev to groupNext. Why?
            // Because when we reverse 1->2, 1 needs to point to whatever came after 2.
            // By setting prev = groupNext initially, the first node (1) will naturally
            // point to groupNext (3) after the reversal loop.
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            // 4. Reverse the group (Standard Linked List Reversal)
            // We run this exactly k times to reverse k nodes.
            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 5. Connect the previous part of the list to the newly reversed group
            // 'prev' is now the new head of this group (was the kth node)
            // 'groupPrev.next' was the old head (now the tail), so we need a temp reference
            // to it so we can move groupPrev forward later.
            ListNode tmp = groupPrev.next;

            groupPrev.next = prev;

            // 6. Move groupPrev forward to prepare for the next group
            // The old head (tmp) is now the tail of this group, so it becomes the
            // 'groupPrev' for the next iteration.
            groupPrev = tmp;
        }

        return dummy.next;
    }

    /**
     * Helper method to get the k-th node from a starting position.
     *
     * @param curr The starting node (exclusive, we jump k times from here usually)
     * @param k    The number of steps to jump
     * @return The k-th node, or null if list ends before k
     */
    private static ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {

    }

    // Helper to print the list
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

    // Helper to create a list from an array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}
