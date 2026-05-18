package dsa.grokbook.fastslowpointer;

/**
 * Given the head of a LinkedList with a cycle, find the length of the cycle.
 */
public class FastSlowPointer2 {
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = new ListNode1(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + findCycleLength(head));

    }

    private static int findCycleLength(ListNode1 head) {
        ListNode1 slow = head;
        ListNode1 fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(ListNode1 slow) {
        ListNode1 current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }
}
