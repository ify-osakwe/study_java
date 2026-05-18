package dsa.grokbook.fastslowpointer;

/**
 * Start of LinkedList Cycle (medium)
 * Given the head of a Singly LinkedList that contains a cycle,
 * write a function to find the starting node of the cycle.
 */
public class FastSlowPointer3 {
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = new ListNode1(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
    }

    // time complexity is O(N)
    // space complexity is O(1)
    private static ListNode1 findCycleStart(ListNode1 head) {
        int cycleLength = 0;
        ListNode1 slow = head;
        ListNode1 fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }
        return findStart(head, cycleLength);
    }

    private static int calculateCycleLength(ListNode1 slow) {
        ListNode1 current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }

    private static ListNode1 findStart(ListNode1 head, int cycleLength) {
        ListNode1 pointer1 = head, pointer2 = head;
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

        }
        return pointer1;
    }
}
