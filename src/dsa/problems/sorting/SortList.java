package dsa.problems.sorting;

import dsa.problems.linkedlist.ListNode;

/**
 * Sort Linked List
 * <a href="https://gemini.google.com/share/37b9a544e8f9">Gemini Link</a>
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode left = head;
        ListNode right = getMiddleAndSplit(head);

        // Step 2: Recursively sort each half
        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        // Step 3: Merge the two sorted halves
        return merge(sortedLeft, sortedRight);
    }

    private static ListNode getMiddleAndSplit(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' is now at the end of the first half.
        // 'slow.next' is the start of the second half.
        ListNode secondHalfHead = slow.next;

        // CRITICAL STEP: Sever the connection to create two independent lists
        slow.next = null;

        return secondHalfHead;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the starting point (simplifies logic)
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // While both lists have nodes, compare and attach the smaller one
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If one list is not empty, attach the rest of it
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the real head (skipping the dummy)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Case 1: [4, 2, 1, 3]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List: " + printList(head));

        ListNode sorted = sortList(head);

        System.out.println("Sorted List:   " + printList(sorted));

        // Test Case 2: [-1, 5, 3, 4, 0]
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        System.out.println("\nOriginal List 2: " + printList(head2));
        ListNode sorted2 = sortList(head2);
        System.out.println("Sorted List 2:   " + printList(sorted2));
    }

    public static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
